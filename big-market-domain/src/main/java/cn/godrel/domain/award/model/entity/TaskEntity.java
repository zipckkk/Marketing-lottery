package cn.godrel.domain.award.model.entity;

import cn.godrel.domain.award.event.SendAwardMessageEvent;
import cn.godrel.domain.award.model.volobj.TaskStateVO;
import cn.godrel.types.event.BaseEvent;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * ClassName: TaskEntity
 * Package: cn.godrel.domain.award.model.entity
 * Description: 任务实体对象
 *
 * @Author 张世召
 * @Create 2025/3/18 13:57
 * @Version 1.0
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TaskEntity {
    /** 活动ID */
    private String userId;
    /** 消息主题 */
    private String topic;
    /** 消息编号 */
    private String messageId;
    /** 消息主体 */
    private BaseEvent.EventMessage<SendAwardMessageEvent.SendAwardMessage> message;
    /** 任务状态；create-创建、completed-完成、fail-失败 */
    private TaskStateVO state;
}
