package cn.godrel.domain.strategy.service.rule.chain;

/**
 * ClassName: ILogicChainArmory
 * Package: cn.godrel.domain.strategy.service.rule.chain
 * Description: 装配接口
 * @Author 张世召
 * @Create 2025/3/5 17:30
 * @Version 1.0
 */
public interface ILogicChainArmory {

    ILogicChain appendNext(ILogicChain next);

    ILogicChain next();
}
