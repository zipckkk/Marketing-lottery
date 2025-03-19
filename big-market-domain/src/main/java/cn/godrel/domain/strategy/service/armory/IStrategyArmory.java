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

    /**
     * 装配抽奖配置【触发的时机可以为活动审核通过后进行调用】
     * @param strategyId 策略id
     */
    boolean assembleLotteryStrategy(Long strategyId);

    /**
     * 装配抽奖策略配置「触发的时机可以为活动审核通过后进行调用」
     *
     * @param activityId 活动ID
     * @return 装配结果
     */
    boolean assembleLotteryStrategyByActivityId(Long activityId);


}
