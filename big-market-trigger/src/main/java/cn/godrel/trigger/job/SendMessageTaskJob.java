package cn.godrel.trigger.job;

import cn.bugstack.middleware.db.router.strategy.IDBRouterStrategy;
import cn.godrel.domain.task.model.entity.TaskEntity;
import cn.godrel.domain.task.service.ITaskService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * ClassName: SendMessageTaskJob
 * Package: cn.godrel.trigger.job
 * Description: 发送MQ消息任务队列
 *
 * @Author 张世召
 * @Create 2025/3/18 14:58
 * @Version 1.0
 */
@Slf4j
@Component()
public class SendMessageTaskJob {
    @Resource
    private ITaskService taskService;
    @Resource
    private ThreadPoolExecutor executor;
    @Resource
    private IDBRouterStrategy dbRouter;

    @Scheduled(cron = "0/5 * * * * ?")
    public void exec() {
//        测试用
//        try {
//            dbRouter.setDBKey(1);
//            dbRouter.setTBKey(0);
//
//            List<TaskEntity> taskEntities = taskService.queryNoSendMessageTaskList();
//            log.info("测试结果：{}", taskEntities.size());
//        } catch (Exception e){
//            log.error("定时任务，扫描失败");
//        } finally {
//            dbRouter.clear();
//        }
        try {
            // 获取分库数量
            int dbCount = dbRouter.dbCount();

            // 逐个库扫描表【每个库一个任务表】
            for (int dbIdx = 1; dbIdx <= dbCount; dbIdx++) {
                int finalDbIdx = dbIdx;
                executor.execute(() -> {
                    try {
                        dbRouter.setDBKey(finalDbIdx);
                        dbRouter.setTBKey(0);
                        List<TaskEntity> taskEntities = taskService.queryNoSendMessageTaskList();
                        if (taskEntities.isEmpty()) return;
                        // 发送MQ消息
                        for (TaskEntity taskEntity : taskEntities) {
                            // 开启线程发送，提高发送效率。配置的线程池策略为 CallerRunsPolicy，在 ThreadPoolConfig 配置中有4个策略，面试中容易对比提问。可以检索下相关资料。
                            executor.execute(() -> {
                                try {
                                    taskService.sendMessage(taskEntity);
                                    taskService.updateTaskSendMessageCompleted(taskEntity.getUserId(), taskEntity.getMessageId());
                                } catch (Exception e) {
                                    log.error("定时任务，发送MQ消息失败 userId: {} topic: {}", taskEntity.getUserId(), taskEntity.getTopic());
                                    taskService.updateTaskSendMessageFail(taskEntity.getUserId(), taskEntity.getMessageId());
                                }
                            });
                        }
                    } finally {
                        dbRouter.clear();
                    }
                });
            }
        } catch (Exception e) {
            log.error("定时任务，扫描MQ任务表发送消息失败。", e);
        } finally {
            dbRouter.clear();
        }
    }
}
