package cn.godrel.trigger.listener;

import cn.godrel.domain.activity.model.entity.SkuRechargeEntity;
import cn.godrel.domain.activity.service.IRaffleActivityAccountQuotaService;
import cn.godrel.domain.rebate.event.SendRebateMessageEvent;
import cn.godrel.domain.rebate.model.valobj.RebateTypeVO;
import cn.godrel.types.enums.ResponseCode;
import cn.godrel.types.event.BaseEvent;
import cn.godrel.types.exception.AppException;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * ClassName: RebateMessageCustomer
 * Package: cn.godrel.trigger.listener
 * Description: 监听：行为返利消息
 *
 * @Author 张世召
 * @Create 2025/3/20 17:04
 * @Version 1.0
 */
@Slf4j
@Component
public class RebateMessageCustomer {
    @Value("${spring.rabbitmq.topic.send_rebate}")
    private String topic;
    @Resource
    private IRaffleActivityAccountQuotaService raffleActivityAccountQuotaService;

//    @RabbitListener(queuesToDeclare = @Queue(value = "${spring.rabbitmq.topic.send_rebate}"))
    @RabbitListener(queuesToDeclare = @Queue(value = "${spring.rabbitmq.topic.send_rebate}", durable = "false", autoDelete = "true", exclusive = "true"))
    public void listener(String message) {
        try {
            log.info("监听用户行为返利消息 topic: {} message: {}", topic, message);
            // 1. 转换消息
            BaseEvent.EventMessage<SendRebateMessageEvent.RebateMessage> eventMessage = JSON.parseObject(message, new TypeReference<BaseEvent.EventMessage<SendRebateMessageEvent.RebateMessage>>() {
            }.getType());
            SendRebateMessageEvent.RebateMessage rebateMessage = eventMessage.getData();
            if (!RebateTypeVO.SKU.getCode().equals(rebateMessage.getRebateType())) {
                log.info("监听用户行为返利消息 - 非sku奖励暂时不处理 topic: {} message: {}", topic, message);
                return;
            }
            // 2. 入账奖励
            SkuRechargeEntity skuRechargeEntity = new SkuRechargeEntity();
            skuRechargeEntity.setUserId(rebateMessage.getUserId());
            skuRechargeEntity.setSku(Long.valueOf(rebateMessage.getRebateConfig()));
            skuRechargeEntity.setOutBusinessNo(rebateMessage.getBizId());
            raffleActivityAccountQuotaService.createOrder(skuRechargeEntity);
        } catch (AppException e) {
            if (ResponseCode.INDEX_DUP.getCode().equals(e.getCode())) {
                log.warn("监听用户行为返利消息，消费重复 topic: {} message: {}", topic, message, e);
                return;
            }
            throw e;
        } catch (Exception e) {
            log.error("监听用户行为返利消息，消费失败 topic: {} message: {}", topic, message, e);
            throw e;
        }
    }
}
