package cn.godrel.domain.activity.service;

import cn.godrel.domain.activity.model.entity.PartakeRaffleActivityEntity;
import cn.godrel.domain.activity.model.entity.UserRaffleOrderEntity;

/**
 * ClassName: IRaffleActivityPartakeService
 * Package: cn.godrel.domain.activity.service
 * Description: 抽奖活动参与服务
 *
 * @Author 张世召
 * @Create 2025/3/17 19:50
 * @Version 1.0
 */
public interface IRaffleActivityPartakeService {
    /**
     * 创建抽奖单；用户参与抽奖活动，扣减活动账户库存，产生抽奖单。如存在未被使用的抽奖单则直接返回已存在的抽奖单。
     *
     * @param partakeRaffleActivityEntity 参与抽奖活动实体对象
     * @return 用户抽奖订单实体对象
     */
    UserRaffleOrderEntity createOrder(PartakeRaffleActivityEntity partakeRaffleActivityEntity);

}
