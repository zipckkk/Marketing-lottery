package cn.godrel.domain.strategy.service;

import cn.godrel.domain.strategy.model.entity.StrategyAwardEntity;

import java.util.List;

/**
 * ClassName: IRaffleAward
 * Package: cn.godrel.domain.strategy.service
 * Description: 策略奖品接口
 *
 * @Author 张世召
 * @Create 2025/3/13 14:05
 * @Version 1.0
 */
public interface IRaffleAward {

    /**
     * 根据策略id查询抽奖奖品列表配置
     * @param strategyId 策略ID
     * @return 奖品列表
     */
    List<StrategyAwardEntity> queryRaffleStrategyAwardList(Long strategyId);
}
