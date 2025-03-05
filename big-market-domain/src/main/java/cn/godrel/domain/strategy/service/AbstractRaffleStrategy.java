package cn.godrel.domain.strategy.service;

import cn.godrel.domain.strategy.model.entity.RaffleAwardEntity;
import cn.godrel.domain.strategy.model.entity.RaffleFactorEntity;
import cn.godrel.domain.strategy.model.entity.RuleActionEntity;
import cn.godrel.domain.strategy.model.entity.StrategyEntity;
import cn.godrel.domain.strategy.model.valobj.RuleLogicCheckTypeVO;
import cn.godrel.domain.strategy.model.valobj.StrategyAwardRuleModelVO;
import cn.godrel.domain.strategy.repository.IStrategyRepository;
import cn.godrel.domain.strategy.service.IRaffleStrategy;
import cn.godrel.domain.strategy.service.armory.IStrategyDispatch;
import cn.godrel.domain.strategy.service.rule.chain.ILogicChain;
import cn.godrel.domain.strategy.service.rule.chain.factory.DefaultChainFactory;
import cn.godrel.domain.strategy.service.rule.filter.ILogicFilter;
import cn.godrel.domain.strategy.service.rule.filter.factory.DefaultLogicFactory;
import cn.godrel.types.enums.ResponseCode;
import cn.godrel.types.exception.AppException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.util.Map;

/**
 * ClassName: AbstractRaffleStrategy
 * Package: cn.godrel.domain.strategy.service.raffle
 * Description:抽奖策略抽象类
 * @Author 张世召
 * @Create 2025/2/28 15:11
 * @Version 1.0
 */
@Slf4j
public abstract class AbstractRaffleStrategy implements IRaffleStrategy {

    // 策略仓储服务 -> domain层像一个大厨，仓储层提供米面粮油
    protected IStrategyRepository repository;
    // 策略调度服务 -> 只负责抽奖处理，通过新增接口的方式，隔离职责，不需要使用方关心或者调用抽奖的初始化
    protected IStrategyDispatch strategyDispatch;

    private DefaultChainFactory defaultChainFactory;

    public AbstractRaffleStrategy(IStrategyRepository repository, IStrategyDispatch strategyDispatch, DefaultChainFactory defaultChainFactory) {
        this.repository = repository;
        this.strategyDispatch = strategyDispatch;
        this.defaultChainFactory = defaultChainFactory;
    }

    public AbstractRaffleStrategy(IStrategyRepository repository, IStrategyDispatch strategyDispatch) {
        this.repository = repository;
        this.strategyDispatch = strategyDispatch;
    }

    @Override
    public RaffleAwardEntity performRaffle(RaffleFactorEntity raffleFactorEntity) {
        // 1. 参数校验
        String userId = raffleFactorEntity.getUserId();
        Long strategyId = raffleFactorEntity.getStrategyId();
        //StringUtils.isBlank(userId)：用于判断字符串 userId 是否为 null、空字符串（""）或仅包含空白字符（如空格、制表符、换行符等）。
        //                            它的作用是速验证字符串的有效性，避免空指针异常和冗余的格式处理。
        if (null == strategyId || StringUtils.isBlank(userId)) {
            throw new AppException(ResponseCode.ILLEGAL_PARAMETER.getCode(), ResponseCode.ILLEGAL_PARAMETER.getInfo());
        }

        // 2. 责任链处理抽奖
        ILogicChain logicChain = defaultChainFactory.openLogicChain(strategyId);
        Integer awardId = logicChain.logic(userId, strategyId);

        // 3. 查询奖品规则「抽奖中（拿到奖品ID时，过滤规则）、抽奖后（扣减完奖品库存后过滤，抽奖中拦截和无库存则走兜底）」
        StrategyAwardRuleModelVO strategyAwardRuleModelVO = repository.queryStrategyAwardRuleModel(strategyId, awardId);

        // 4. 抽奖中 - 规则过滤
        RuleActionEntity<RuleActionEntity.RaffleCenterEntity> ruleActionCenterEntity = this.doCheckRaffleCenterLogic(RaffleFactorEntity.builder()
                .userId(userId)
                .strategyId(strategyId)
                .awardId(awardId)
                .build(), strategyAwardRuleModelVO.raffleCenterRuleModelList());

        if (RuleLogicCheckTypeVO.TAKE_OVER.getCode().equals(ruleActionCenterEntity.getCode())){
            log.info("【临时日志】中奖中规则拦截，通过抽奖后规则 rule_luck_award 走兜底奖励。");
            return RaffleAwardEntity.builder()
                    .awardDesc("中奖中规则拦截，通过抽奖后规则 rule_luck_award 走兜底奖励。")
                    .build();
        }

        return RaffleAwardEntity.builder()
                .awardId(awardId)
                .build();
    }

    /**
     * 类型：String...（可变参数）
     * 参数名：logics
     * 可以接受任意数量的String参数，或一个String数组
     * 例如：调用时可以是 doCheck(... "A", "B") 或 doCheck(... new String[]{"A","B"})
     * <p>
     * 这是一个需要子类实现的受保护抽象方法，它的作用是执行抽奖前的逻辑校验。接收一个抽奖因子实体和若干逻辑规则字符串作为输入，
     * 最终返回一个包含特定校验结果（RaffleBeforeEntity）的规则动作实体。
     * <p>
     * 类比理解：
     * 就像你定义了一个"做蛋糕"的抽象步骤（abstract），具体怎么做的面粉和糖的比例（实现）由每个徒弟（子类）自己决定，
     * 但必须返回一个写着制作过程的纸条（RuleActionEntity），而纸条里必须包含预热烤箱的步骤（RaffleBeforeEntity）。
     */
    protected abstract RuleActionEntity<RuleActionEntity.RaffleBeforeEntity> doCheckRaffleBeforeLogic(RaffleFactorEntity raffleFactorEntity, String... logics);

    protected abstract RuleActionEntity<RuleActionEntity.RaffleCenterEntity> doCheckRaffleCenterLogic(RaffleFactorEntity raffleFactorEntity, String... logics);

}
