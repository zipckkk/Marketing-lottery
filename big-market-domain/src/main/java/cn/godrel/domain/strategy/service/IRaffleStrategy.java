package cn.godrel.domain.strategy.service;

import cn.godrel.domain.strategy.model.entity.RaffleAwardEntity;
import cn.godrel.domain.strategy.model.entity.RaffleFactorEntity;

/**
 * ClassName: IRaffleStrategy
 * Package: cn.godrel.domain.strategy.service
 * Description: 抽奖的策略接口
 * @Author 张世召
 * @Create 2025/2/28 15:01
 * @Version 1.0
 */
public interface IRaffleStrategy {

    RaffleAwardEntity performRaffle(RaffleFactorEntity raffleFactorEntity);
}
