package cn.godrel.domain.rebate.model.entity;

import cn.godrel.domain.rebate.event.SendRebateMessageEvent;
import cn.godrel.domain.rebate.model.valobj.TaskStateVO;
import cn.godrel.types.event.BaseEvent;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * ClassName: TaskEntity
 * Package: cn.godrel.domain.rebate.model.entity
 * Description: 任务实体对象
 *
 * @Author 张世召
 * @Create 2025/3/20 15:05
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
    private BaseEvent.EventMessage<SendRebateMessageEvent.RebateMessage> message;
    /** 任务状态；create-创建、completed-完成、fail-失败 */
    private TaskStateVO state;
}
