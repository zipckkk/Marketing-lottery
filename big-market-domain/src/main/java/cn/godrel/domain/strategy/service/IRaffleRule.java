package cn.godrel.domain.strategy.service;

import java.util.Map;

/**
 * ClassName: IRaffleRule
 * Package: cn.godrel.domain.strategy.service
 * Description: 抽奖规则接口
 *
 * @Author 张世召
 * @Create 2025/3/19 14:56
 * @Version 1.0
 */
public interface IRaffleRule {
    /**
     * 根据规则树ID集合查询奖品中加锁数量的配置「部分奖品需要抽奖N次解锁」
     *
     * @param treeIds 规则树ID值
     * @return key 规则树，value rule_lock 加锁值
     */
    Map<String, Integer> queryAwardRuleLockCount(String[] treeIds);
}
