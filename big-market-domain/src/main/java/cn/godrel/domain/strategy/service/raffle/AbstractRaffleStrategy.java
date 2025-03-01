package cn.godrel.domain.strategy.service.raffle;

import cn.godrel.domain.strategy.model.entity.RaffleAwardEntity;
import cn.godrel.domain.strategy.model.entity.RaffleFactorEntity;
import cn.godrel.domain.strategy.model.entity.RuleActionEntity;
import cn.godrel.domain.strategy.model.entity.StrategyEntity;
import cn.godrel.domain.strategy.model.vo.RuleLogicCheckTypeVO;
import cn.godrel.domain.strategy.repository.IStrategyRepository;
import cn.godrel.domain.strategy.service.IRaffleStrategy;
import cn.godrel.domain.strategy.service.armory.IStrategyDispatch;
import cn.godrel.domain.strategy.service.rule.factory.DefaultLogicFactory;
import cn.godrel.types.enums.ResponseCode;
import cn.godrel.types.exception.AppException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

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

        // 2. 策略查询
        StrategyEntity strategy = repository.queryStrategyEntityByStrategyId(strategyId);

        // 3. 抽奖前 - 规则过滤
        RuleActionEntity<RuleActionEntity.RaffleBeforeEntity> ruleActionEntity = this.doCheckRaffleBeforeLogic(RaffleFactorEntity.builder().userId(userId).strategyId(strategyId).build(), strategy.ruleModels());

        //满足条件说明此用户有抽奖规则，要么是rule_weight，要么是黑名单
        if (RuleLogicCheckTypeVO.TAKE_OVER.getCode().equals(ruleActionEntity.getCode())) {
            if (DefaultLogicFactory.LogicModel.RULE_BLACKLIST.getCode().equals(ruleActionEntity.getRuleModel())) {
                // 黑名单返回固定的奖品ID
                return RaffleAwardEntity.builder()
                        .awardId(ruleActionEntity.getData().getAwardId())
                        .build();
            } else if (DefaultLogicFactory.LogicModel.RULE_WIGHT.getCode().equals(ruleActionEntity.getRuleModel())) {
                // 权重根据返回的信息进行抽奖
                RuleActionEntity.RaffleBeforeEntity raffleBeforeEntity = ruleActionEntity.getData();
                String ruleWeightValueKey = raffleBeforeEntity.getRuleWeightValueKey();
                Integer awardId = strategyDispatch.getRandomAwardId(strategyId, ruleWeightValueKey);
                return RaffleAwardEntity.builder()
                        .awardId(awardId)
                        .build();
            }
        }

        // 4. 默认抽奖流程
        Integer awardId = strategyDispatch.getRandomAwardId(strategyId);

        return RaffleAwardEntity.builder()
                .awardId(awardId)
                .build();
    }

    /**
     * 类型：String...（可变参数）
     * 参数名：logics
     * 可以接受任意数量的String参数，或一个String数组
     * 例如：调用时可以是 doCheck(... "A", "B") 或 doCheck(... new String[]{"A","B"})
     *
     * 这是一个需要子类实现的受保护抽象方法，它的作用是执行抽奖前的逻辑校验。接收一个抽奖因子实体和若干逻辑规则字符串作为输入，
     * 最终返回一个包含特定校验结果（RaffleBeforeEntity）的规则动作实体。
     *
     * 类比理解：
     * 就像你定义了一个"做蛋糕"的抽象步骤（abstract），具体怎么做的面粉和糖的比例（实现）由每个徒弟（子类）自己决定，
     * 但必须返回一个写着制作过程的纸条（RuleActionEntity），而纸条里必须包含预热烤箱的步骤（RaffleBeforeEntity）。
     */
    protected abstract RuleActionEntity<RuleActionEntity.RaffleBeforeEntity> doCheckRaffleBeforeLogic(RaffleFactorEntity raffleFactorEntity, String... logics);

}
