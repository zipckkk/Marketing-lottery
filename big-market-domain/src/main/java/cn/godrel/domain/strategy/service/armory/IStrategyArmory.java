package cn.godrel.domain.strategy.service.armory;

/**
 * ClassName: IStrategyArmory
 * Package: cn.godrel.domain.strategy.service.armory
 * Description:负责初始化策略计算
 * @Author 张世召
 * @Create 2025/2/25 19:24
 * @Version 1.0
 */
public interface IStrategyArmory {

    void assembleLotteryStrategy(Long strategyId);

    Integer getRandomAwardId(Long strategyId);
}
