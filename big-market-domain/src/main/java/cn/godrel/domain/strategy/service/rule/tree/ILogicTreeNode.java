package cn.godrel.domain.strategy.service.rule.tree;

import cn.godrel.domain.strategy.service.rule.tree.factory.DefaultTreeFactory;

/**
 * ClassName: ILogicTreeNode
 * Package: cn.godrel.domain.strategy.service.rule.tree
 * Description: 规则树接口
 *
 * @Author 张世召
 * @Create 2025/3/5 22:17
 * @Version 1.0
 */
public interface ILogicTreeNode {

    public DefaultTreeFactory.TreeActionEntity logic(String userId, Long strategyId, Integer awardId,String ruleValue);
}
