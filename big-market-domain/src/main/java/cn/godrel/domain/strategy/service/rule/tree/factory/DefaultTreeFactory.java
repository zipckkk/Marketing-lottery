package cn.godrel.domain.strategy.service.rule.tree.factory;

import cn.godrel.domain.strategy.model.valobj.RuleLogicCheckTypeVO;
import cn.godrel.domain.strategy.model.valobj.RuleTreeVO;
import cn.godrel.domain.strategy.service.rule.tree.ILogicTreeNode;
import cn.godrel.domain.strategy.service.rule.tree.factory.engine.IDecisionTreeEngine;
import cn.godrel.domain.strategy.service.rule.tree.factory.engine.impl.DecisionTreeEngine;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * ClassName: DefaultTreeFactory
 * Package: cn.godrel.domain.strategy.service.rule.tree.factory
 * Description: 规则树工厂 - 填充数据、提供规则引擎的决策处理
 *
 * @Author 张世召
 * @Create 2025/3/6 10:57
 * @Version 1.0
 */
@Service
public class DefaultTreeFactory {

    private final Map<String, ILogicTreeNode> logicTreeNodeGroup;

    public DefaultTreeFactory(Map<String, ILogicTreeNode> logicTreeNodeGroup) {
        this.logicTreeNodeGroup = logicTreeNodeGroup;
    }

    public IDecisionTreeEngine openLogicTree(RuleTreeVO ruleTreeVO){
        return new DecisionTreeEngine(logicTreeNodeGroup, ruleTreeVO);
    }

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class TreeActionEntity {
        private RuleLogicCheckTypeVO ruleLogicCheckType;
        private StrategyAwardVO strategyAwardVO;
    }

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class StrategyAwardVO {
        //抽奖奖品 - 内部流转使用
        private Integer awardId;
        //抽奖奖品策略规则
        private String awardRuleValue;
    }
}
