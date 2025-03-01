package cn.godrel.domain.strategy.model.entity;

import cn.godrel.domain.strategy.model.vo.RuleLogicCheckTypeVO;
import lombok.*;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * ClassName: RuleActionEntity
 * Package: cn.godrel.domain.strategy.model.entity
 * Description:规则动作实体
 * @Author 张世召
 * @Create 2025/2/28 15:18
 * @Version 1.0
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RuleActionEntity<T extends RuleActionEntity.RaffleEntity> {  // 泛型容器类：RuleActionEntity 是一个可以装任何 RaffleEntity 子类的盒子

    // 盒子里的公共属性
    private String code = RuleLogicCheckTypeVO.ALLOW.getCode();
    private String info = RuleLogicCheckTypeVO.ALLOW.getInfo();
    private String ruleModel;

    // 核心：盒子里的具体内容物，类型由泛型参数 T 决定
    private T data;


    // 基类：所有抽奖相关实体的父类（空盒子，用于继承）
    static public class RaffleEntity{
    }

    @EqualsAndHashCode(callSuper = true)
    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    //抽奖前
    //具体实现类：抽奖前的实体（往空盒子里装了具体东西）
    static public class RaffleBeforeEntity extends RaffleEntity{
        //策略ID
        private Long strategyId;
        ///权重值Key；用于抽奖时可以选择权重抽奖。
        private String ruleWeightValueKey;
        //奖品ID；
        private Integer awardId;
    }

    //抽奖中
    static public class RaffleCenterEntity extends RaffleEntity{

    }

    //抽奖后
    static public class RaffleAfterEntity extends RaffleEntity{
    }


}
