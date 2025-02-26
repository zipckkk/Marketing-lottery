package cn.godrel.domain.strategy.repository;

import cn.godrel.domain.strategy.model.entity.StrategyAwardEntity;

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

    void storeStrategyAwardSearchRateTables(Long strategyId, Integer rateRange, HashMap<Integer, Integer> shuffleStrategyAwardSearchRateTables);

    int getRateRange(Long strategyId);

    Integer getStrategyAwardAssemble(Long strategyId, Integer rateKey);
}
