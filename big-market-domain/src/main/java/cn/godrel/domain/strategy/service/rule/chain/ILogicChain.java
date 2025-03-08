package cn.godrel.domain.strategy.service.rule.chain;

import cn.godrel.domain.strategy.service.rule.chain.factory.DefaultChainFactory;

/**
 * ClassName: ILogicChain
 * Package: cn.godrel.domain.strategy.service.rule.chain
 * Description: 责任链接口
 * @Author 张世召
 * @Create 2025/3/5 16:28
 * @Version 1.0
 */
public interface ILogicChain extends ILogicChainArmory{
    /**
     * 责任链接口
     * @param userId      用户id
     * @param strategyId  策略id
     * @return 奖品id
     */
    DefaultChainFactory.StrategyAwardVO logic(String userId, Long strategyId);
}
