package cn.godrel.domain.activity.event;

import cn.godrel.types.event.BaseEvent;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * ClassName: ActivitySkuStockZeroMessageEvent
 * Package: cn.godrel.domain.activity.event
 * Description: 活动sku库存清空消息
 *
 * @Author 张世召
 * @Create 2025/3/16 23:02
 * @Version 1.0
 */
@Component
public class ActivitySkuStockZeroMessageEvent extends BaseEvent<Long> {
    @Value("${spring.rabbitmq.topic.activity_sku_stock_zero}")
    private String topic;

    @Override
    public EventMessage<Long> buildEventMessage(Long sku) {
        return EventMessage.<Long>builder()
                .id(RandomStringUtils.randomNumeric(11))
                .timestamp(new Date())
                .data(sku)
                .build();
    }

    @Override
    public String topic() {
        return topic;
    }

}
