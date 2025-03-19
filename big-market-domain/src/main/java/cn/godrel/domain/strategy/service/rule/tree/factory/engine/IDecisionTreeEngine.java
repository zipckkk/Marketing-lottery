package cn.godrel.domain.strategy.service.rule.tree.factory.engine;

import cn.godrel.domain.strategy.service.rule.tree.factory.DefaultTreeFactory;

import java.util.Date;

/**
 * ClassName: IDecisionTreeNode
 * Package: cn.godrel.domain.strategy.service.rule.tree.factory.engine
 * Description: 规则树的组合接口
 * @Author 张世召
 * @Create 2025/3/6 11:12
 * @Version 1.0
 */
public interface IDecisionTreeEngine {

    DefaultTreeFactory.StrategyAwardVO process(String userId, Long strategyId, Integer awardId, Date endDateTime);
}
