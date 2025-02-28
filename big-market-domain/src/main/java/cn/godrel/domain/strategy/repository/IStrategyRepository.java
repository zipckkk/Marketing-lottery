package cn.godrel.domain.strategy.repository;

import cn.godrel.domain.strategy.model.entity.StrategyAwardEntity;
import cn.godrel.domain.strategy.model.entity.StrategyEntity;
import cn.godrel.domain.strategy.model.entity.StrategyRuleEntity;

import java.util.HashMap;
import java.util.List;

/**
 * ClassName: IStrategyRepository
 * Package: cn.godrel.domain.strategy.repository
 * Description: 策略仓储接口
 * @Author 张世召
 * @Create 2025/2/25 19:33
 * @Version 1.0
 */
public interface IStrategyRepository {
    List<StrategyAwardEntity> queryStrategyAwardList(Long strategyId);

    void storeStrategyAwardSearchRateTables(String key, Integer rateRange, HashMap<Integer, Integer> shuffleStrategyAwardSearchRateTables);

    int getRateRange(Long strategyId);

    int getRateRange(String key);

    Integer getStrategyAwardAssemble(String key, Integer rateKey);

    StrategyEntity queryStrategyEntityByStrategyId(Long strategyId);

    StrategyRuleEntity queryStrategyRule(Long strategyId, String ruleModel);
}
