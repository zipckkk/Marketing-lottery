package cn.godrel.infrastructure.persistent.dao;

import cn.bugstack.middleware.db.router.annotation.DBRouter;
import cn.godrel.infrastructure.persistent.po.Task;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * ClassName: ITaskDao
 * Package: cn.godrel.infrastructure.persistent.dao
 * Description: 任务表，发送MQ
 *
 * @Author 张世召
 * @Create 2025/3/17 17:47
 * @Version 1.0
 */
@Mapper
public interface ITaskDao {
    @DBRouter
    void updateTaskSendMessageCompleted(Task task);

    @DBRouter
    void updateTaskSendMessageFail(Task task);

    void insert(Task task);

    List<Task> queryNoSendMessageTaskList();
}
