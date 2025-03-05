package cn.godrel.domain.strategy.service.rule.filter;

import cn.godrel.domain.strategy.model.entity.RuleActionEntity;
import cn.godrel.domain.strategy.model.entity.RuleMatterEntity;

/**
 * ClassName: ILogicFilter
 * Package: cn.godrel.domain.strategy.service.rule
 * Description:抽奖策略
 * @Author 张世召
 * @Create 2025/2/28 15:13
 * @Version 1.0
 */
public interface ILogicFilter<T extends RuleActionEntity.RaffleEntity> {

    RuleActionEntity<T> filter(RuleMatterEntity ruleMatterEntity);


}
