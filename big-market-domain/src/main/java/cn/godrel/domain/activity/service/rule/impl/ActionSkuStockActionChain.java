package cn.godrel.domain.activity.service.rule.impl;

import cn.godrel.domain.activity.model.entity.ActivityCountEntity;
import cn.godrel.domain.activity.model.entity.ActivityEntity;
import cn.godrel.domain.activity.model.entity.ActivitySkuEntity;
import cn.godrel.domain.activity.service.rule.AbstractActionChain;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * ClassName: ActivitySkuStockActionChain
 * Package: cn.godrel.domain.activity.service.rule.impl
 * Description:
 *
 * @Author 张世召
 * @Create 2025/3/15 17:03
 * @Version 1.0
 */
@Slf4j
@Component("activity_sku_stock_action")
public class ActionSkuStockActionChain extends AbstractActionChain {
    @Override
    public boolean action(ActivitySkuEntity activitySkuEntity, ActivityEntity activityEntity, ActivityCountEntity activityCountEntity) {
        log.info("活动责任链-商品库存处理【校验&扣减】开始。");
        return true;

    }
}
