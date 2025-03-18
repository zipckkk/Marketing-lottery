package cn.godrel.domain.task.model.entity;

import lombok.Data;

/**
 * ClassName: TaskEntity
 * Package: cn.godrel.domain.task.model.entity
 * Description: 任务实体对象
 *
 * @Author 张世召
 * @Create 2025/3/18 15:03
 * @Version 1.0
 */
@Data
public class TaskEntity {
    /** 活动ID */
    private String userId;
    /** 消息主题 */
    private String topic;
    /** 消息编号 */
    private String messageId;
    /** 消息主体 */
    private String message;
}
