package cn.godrel.domain.task.service;

import cn.godrel.domain.task.model.entity.TaskEntity;

import java.util.List;

/**
 * ClassName: ITaskService
 * Package: cn.godrel.domain.task
 * Description: 消息任务服务接口
 *
 * @Author 张世召
 * @Create 2025/3/18 15:01
 * @Version 1.0
 */
public interface ITaskService {
    /**
     * 查询发送MQ失败和超时1分钟未发送的MQ
     *
     * @return 未发送的任务消息列表10条
     */
    List<TaskEntity> queryNoSendMessageTaskList();

    void sendMessage(TaskEntity taskEntity);

    void updateTaskSendMessageCompleted(String userId, String messageId);

    void updateTaskSendMessageFail(String userId, String messageId);


}
