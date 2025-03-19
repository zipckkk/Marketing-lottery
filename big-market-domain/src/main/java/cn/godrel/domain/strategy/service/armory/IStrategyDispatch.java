package cn.godrel.domain.strategy.service.armory;

import java.util.Date;

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

    /**
     * 获取抽奖策略装配的随机结果
     *
     * @param strategyId 权重ID
     * @return 抽奖结果
     */
    Integer getRandomAwardId(Long strategyId, String ruleWeightValue);

    /**
     * 获取抽奖策略装配的随机结果
     *
     * @param key = strategyId + _ + ruleWeightValue；
     * @return 抽奖结果
     */
    Integer getRandomAwardId(String key);

    /**
     * 根据策略ID和奖品ID，扣减奖品缓存库存
     *
     * @param strategyId 策略ID
     * @param awardId    奖品ID
     * @param endDateTime 活动到期时间
     * @return 扣减结果
     */
    Boolean subtractionAwardStock(Long strategyId, Integer awardId, Date endDateTime);

}
