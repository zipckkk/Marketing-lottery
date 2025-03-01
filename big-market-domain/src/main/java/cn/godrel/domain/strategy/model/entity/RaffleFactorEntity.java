package cn.godrel.domain.strategy.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * ClassName: RaffleFactorEntity
 * Package: cn.godrel.domain.strategy.model.entity
 * Description: 抽奖因子
 * @Author 张世召
 * @Create 2025/2/28 15:02
 * @Version 1.0
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RaffleFactorEntity {

    private String userId;
    private Long strategyId;
}
