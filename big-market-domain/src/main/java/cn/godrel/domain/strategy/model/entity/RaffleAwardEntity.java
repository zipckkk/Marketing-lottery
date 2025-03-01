package cn.godrel.domain.strategy.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * ClassName: RaffleAwardEntity
 * Package: cn.godrel.domain.strategy.model.entity
 * Description: 抽奖奖品实体
 * @Author 张世召
 * @Create 2025/2/28 15:05
 * @Version 1.0
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RaffleAwardEntity {

    //策略ID
    private Long strategyId;
    //抽奖奖品ID
    private Integer awardId;
    //奖品对接标识 - 每一个都是一个对应的发奖策略
    private String awardKey;
    //奖品配置信息
    private String awardConfig;
    //奖品内容描述
    private String awardDesc;
}
