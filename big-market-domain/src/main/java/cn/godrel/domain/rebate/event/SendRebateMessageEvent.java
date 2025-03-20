package cn.godrel.domain.rebate.event;

import cn.godrel.types.event.BaseEvent;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * ClassName: SendRebateMessageEvent
 * Package: cn.godrel.domain.rebate.event
 * Description: 发送返利消息事件
 *
 * @Author 张世召
 * @Create 2025/3/20 15:21
 * @Version 1.0
 */
@Component
public class SendRebateMessageEvent extends BaseEvent<SendRebateMessageEvent.RebateMessage> {

    @Value("${spring.rabbitmq.topic.send_rebate}")
    private String topic;

    @Override
    public EventMessage<RebateMessage> buildEventMessage(RebateMessage data) {
        return EventMessage.<SendRebateMessageEvent.RebateMessage>builder()
                .id(RandomStringUtils.randomNumeric(11))
                .timestamp(new Date())
                .data(data)
                .build();
    }

    @Override
    public String topic() {
        return topic;
    }

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class RebateMessage {
        /** 用户ID */
        private String userId;
        /** 返利描述 */
        private String rebateDesc;
        /** 返利类型 */
        private String rebateType;
        /** 返利配置 */
        private String rebateConfig;
        /** 业务ID - 唯一ID，确保幂等 */
        private String bizId;
    }

}
