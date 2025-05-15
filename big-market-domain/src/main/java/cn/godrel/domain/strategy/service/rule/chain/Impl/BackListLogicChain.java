package cn.godrel.domain.strategy.service.rule.chain.Impl;

import cn.godrel.domain.strategy.repository.IStrategyRepository;
import cn.godrel.domain.strategy.service.rule.chain.AbstractLogicChain;
import cn.godrel.domain.strategy.service.rule.chain.factory.DefaultChainFactory;
import cn.godrel.types.common.Constants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * ClassName: BackListLogicChain
 * Package: cn.godrel.domain.strategy.service.rule.chain
 * Description: 黑名单方法
 * @Author 张世召
 * @Create 2025/3/5 16:33
 * @Version 1.0
 */
@Slf4j
@Component("rule_blacklist")
public class BackListLogicChain extends AbstractLogicChain {
    @Resource
    private IStrategyRepository repository;

    @Override
    public DefaultChainFactory.StrategyAwardVO logic(String userId, Long strategyId) {
        log.info("抽奖责任链-黑名单开始 userId: {} strategyId: {} ruleModel: {}", userId, strategyId, ruleModel());
        String ruleValue = repository.queryStrategyRuleValue(strategyId, ruleModel());
        String[] splitRuleValue = ruleValue.split(Constants.COLON);
        Integer awardId = Integer.parseInt(splitRuleValue[0]); //awardId = 100, 黑名单就只给个100号奖品

        // 100:user001,user002,user003
        // 过滤其他规则
        String[] userBlackIds = splitRuleValue[1].split(Constants.SPLIT);  //黑名单用户 userBlackIds = [user001,user002,user003]
        for (String userBlackId : userBlackIds) {
            if (userId.equals(userBlackId)) {
                log.info("抽奖责任链-黑名单接管 userId: {} strategyId: {} ruleModel: {} awardId: {}", userId, strategyId, ruleModel(), awardId);
                return DefaultChainFactory.StrategyAwardVO.builder()
                        .awardId(awardId)
                        .logicModel(ruleModel())
                        // 写入默认配置黑名单奖品值 0.01 ~ 1 积分，也可以配置到数据库表中
                        .awardRuleValue("0.01,1")
                        .build();
            }
        }
        // 过滤其他责任链
        log.info("抽奖责任链-黑名单放行 userId: {} strategyId: {} ruleModel: {}", userId, strategyId, ruleModel());
        return next().logic(userId, strategyId);
    }

    @Override
    protected String ruleModel() {
        return DefaultChainFactory.LogicModel.RULE_BLACKLIST.getCode();
    }
}
