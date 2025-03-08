package cn.godrel.domain.strategy.service.rule.tree.impl;

import cn.godrel.domain.strategy.model.valobj.RuleLogicCheckTypeVO;
import cn.godrel.domain.strategy.service.rule.tree.ILogicTreeNode;
import cn.godrel.domain.strategy.service.rule.tree.factory.DefaultTreeFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * ClassName: RuleStockLogicTreeNode
 * Package: cn.godrel.domain.strategy.service.rule.tree.impl
 * Description: 库存节点
 * @Author 张世召
 * @Create 2025/3/6 10:55
 * @Version 1.0
 */
@Slf4j
@Component("rule_stock")
public class RuleStockLogicTreeNode implements ILogicTreeNode {
    @Override
    public DefaultTreeFactory.TreeActionEntity logic(String userId, Long strategyId, Integer awardId) {
        return DefaultTreeFactory.TreeActionEntity.builder()
                .ruleLogicCheckType(RuleLogicCheckTypeVO.TAKE_OVER)
                .build();
    }
}
