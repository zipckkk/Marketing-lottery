package cn.godrel.domain.strategy.service.rule.chain.Impl;

import cn.godrel.domain.strategy.service.armory.IStrategyDispatch;
import cn.godrel.domain.strategy.service.rule.chain.AbstractLogicChain;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * ClassName: DefaultLogicChain
 * Package: cn.godrel.domain.strategy.service.rule.chain.Impl
 * Description: 兜底的责任链节点
 * @Author 张世召
 * @Create 2025/3/5 16:36
 * @Version 1.0
 */
@Slf4j
@Component("default")
public class DefaultLogicChain extends AbstractLogicChain {

    @Resource
    protected IStrategyDispatch strategyDispatch;

    @Override
    public Integer logic(String userId, Long strategyId) {
        Integer awardId = strategyDispatch.getRandomAwardId(strategyId);
        log.info("抽奖责任链-默认处理 userId:{} strategyId:{} ruleModel:{} awardId:{}",userId,strategyId,ruleModel(),awardId);
        return awardId;
    }

    @Override
    protected String ruleModel() {
        return "default";
    }
}
