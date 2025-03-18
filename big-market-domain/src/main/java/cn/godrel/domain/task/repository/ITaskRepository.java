package cn.godrel.domain.task.repository;

import cn.godrel.domain.task.model.entity.TaskEntity;

import java.util.List;

/**
 * ClassName: ITaskRepository
 * Package: cn.godrel.domain.task.repository
 * Description: 任务服务仓储接口
 *
 * @Author 张世召
 * @Create 2025/3/18 15:03
 * @Version 1.0
 */
public interface ITaskRepository {
    List<TaskEntity> queryNoSendMessageTaskList();

    void sendMessage(TaskEntity taskEntity);

    void updateTaskSendMessageCompleted(String userId, String messageId);

    void updateTaskSendMessageFail(String userId, String messageId);


}
