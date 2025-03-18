package cn.godrel.domain.task.service;

import cn.godrel.domain.task.model.entity.TaskEntity;
import cn.godrel.domain.task.repository.ITaskRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * ClassName: TaskService
 * Package: cn.godrel.domain.task.service
 * Description: 消息任务服务
 *
 * @Author 张世召
 * @Create 2025/3/18 15:07
 * @Version 1.0
 */
@Service
public class TaskService implements ITaskService{
    @Resource
    private ITaskRepository taskRepository;

    @Override
    public List<TaskEntity> queryNoSendMessageTaskList() {
        return taskRepository.queryNoSendMessageTaskList();
    }

    @Override
    public void sendMessage(TaskEntity taskEntity) {
        taskRepository.sendMessage(taskEntity);
    }

    @Override
    public void updateTaskSendMessageCompleted(String userId, String messageId) {
        taskRepository.updateTaskSendMessageCompleted(userId, messageId);
    }

    @Override
    public void updateTaskSendMessageFail(String userId, String messageId) {
        taskRepository.updateTaskSendMessageFail(userId, messageId);
    }

}
