package cn.godrel.domain.activity.service;

import cn.godrel.domain.activity.model.entity.ActivityOrderEntity;
import cn.godrel.domain.activity.model.entity.ActivityShopCartEntity;

/**
 * ClassName: IRaffleOrder
 * Package: cn.godrel.domain.activity.service
 * Description: 抽奖活动订单接口
 *
 * @Author 张世召
 * @Create 2025/3/15 11:11
 * @Version 1.0
 */
public interface IRaffleOrder {
    /**
     * 以sku创建抽奖活动订单，获得参与抽奖资格（可消耗的次数）
     *
     * @param activityShopCartEntity 活动sku实体，通过sku领取活动。
     * @return 活动参与记录实体
     */
    ActivityOrderEntity createRaffleActivityOrder(ActivityShopCartEntity activityShopCartEntity);

}
