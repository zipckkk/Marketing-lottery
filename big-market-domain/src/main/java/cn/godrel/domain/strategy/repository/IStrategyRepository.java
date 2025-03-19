package cn.godrel.domain.strategy.repository;

import cn.godrel.domain.strategy.model.entity.StrategyAwardEntity;
import cn.godrel.domain.strategy.model.entity.StrategyEntity;
import cn.godrel.domain.strategy.model.entity.StrategyRuleEntity;
import cn.godrel.domain.strategy.model.valobj.RuleTreeVO;
import cn.godrel.domain.strategy.model.valobj.StrategyAwardRuleModelVO;
import cn.godrel.domain.strategy.model.valobj.StrategyAwardStockKeyVO;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    /**
     * 查询：strategy_id, strategy_desc, rule_models
     * @param strategyId
     * @return
     */
    StrategyEntity queryStrategyEntityByStrategyId(Long strategyId);

    StrategyRuleEntity queryStrategyRule(Long strategyId, String ruleModel);

    String queryStrategyRuleValue(Long strategyId, String ruleModel);
    String queryStrategyRuleValue(Long strategyId, Integer awardId, String ruleModel);

    StrategyAwardRuleModelVO queryStrategyAwardRuleModelVO(Long strategyId, Integer awardId);

    RuleTreeVO queryRuleTreeVOByTreeId(String tree_lock);

    /**
     * 缓存奖品库存
     * @param cacheKey key
     * @param awardCount 库存值
     */
    void cacheStrategyAwardCount(String cacheKey, Integer awardCount);

    /**
     * 扣减奖品库存
     * @param cacheKey key
     * @return
     */
    Boolean subtractionAwardStock(String cacheKey);

    /**
     * 缓存key，decr 方式扣减库存
     *
     * @param cacheKey 缓存Key
     * @param endDateTime 活动结束时间
     * @return 扣减结果
     */
    Boolean subtractionAwardStock(String cacheKey, Date endDateTime);

    /**
     * 写入奖品库存消费队列
     *
     * @param strategyAwardStockKeyVO 对象值对象
     */
    void awardStockConsumeSendQueue(StrategyAwardStockKeyVO strategyAwardStockKeyVO);

    StrategyAwardStockKeyVO takeQueueValue();

    /**
     * 获取奖品库存消费队列
     */
    void updateStrategyAwardStock(Long strategyId, Integer awardId);

    /**
     * 根据策略ID+奖品ID的唯一值组合，查询奖品信息
     * @param strategyId 策略ID
     * @param awardId    奖品ID
     * @return           奖品信息
     */
    StrategyAwardEntity queryStrategyAwardEntity(Long strategyId, Integer awardId);

    /**
     * 查询策略ID
     *
     * @param activityId 活动ID
     * @return 策略ID
     */
    Long queryStrategyIdByActivityId(Long activityId);

    /**
     * 查询用户抽奖次数 - 当天的；策略ID:活动ID 1:1 的配置，可以直接用 strategyId 查询。
     *
     * @param userId     用户ID
     * @param strategyId 策略ID
     * @return 用户今日参与次数
     */
    Integer queryTodayUserRaffleCount(String userId, Long strategyId);

    /**
     * 根据规则树ID集合查询奖品中加锁数量的配置「部分奖品需要抽奖N次解锁」
     *
     * @param treeIds 规则树ID值
     * @return key 规则树，value rule_lock 加锁值
     */
    Map<String, Integer> queryAwardRuleLockCount(String[] treeIds);
}
