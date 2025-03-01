package cn.godrel.infrastructure.persistent.dao;

import cn.godrel.infrastructure.persistent.po.Strategy;
import cn.godrel.infrastructure.persistent.po.StrategyRule;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * ClassName: IStrategyRuleDao
 * Package: cn.godrel.infrastructure.persistent.dao
 * Description:
 *
 * @Author 张世召
 * @Create 2025/2/24 15:07
 * @Version 1.0
 */
@Mapper
public interface IStrategyRuleDao {

    List<StrategyRule> queryStrategyRuleList();

    StrategyRule queryStrategyRule(StrategyRule strategyRuleReq);

    String queryStrategyRuleValue(StrategyRule strategyRule);
}
