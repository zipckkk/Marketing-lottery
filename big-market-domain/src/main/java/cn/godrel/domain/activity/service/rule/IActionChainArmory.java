package cn.godrel.domain.activity.service.rule;

/**
 * ClassName: IActionChainArmory
 * Package: cn.godrel.domain.activity.service.rule
 * Description: 抽奖动作责任链（装配）
 *
 * @Author 张世召
 * @Create 2025/3/15 17:01
 * @Version 1.0
 */
public interface IActionChainArmory {
    IActionChain next();

    IActionChain appendNext(IActionChain next);
}
