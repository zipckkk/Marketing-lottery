package cn.godrel.domain.strategy.service.armory;

/**
 * ClassName: IStrategyDispath
 * Package: cn.godrel.domain.strategy.service.armory
 * Description: 策略抽奖调度
 * @Author 张世召
 * @Create 2025/2/26 14:41
 * @Version 1.0
 */
public interface IStrategyDispatch {

    /**
     * 获取抽奖策略的随机结果
     * @param strategyId 策略id
     * @return 抽奖结果
     */
    Integer getRandomAwardId(Long strategyId);

    Integer getRandomAwardId(Long strategyId, String ruleWeightValue);
}
