package cn.godrel.domain.strategy.model.valobj;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * ClassName: StrategyAwardStockKeyVO
 * Package: cn.godrel.domain.strategy.model.valobj
 * Description: 策略奖品库存Key标识值对象
 *
 * @Author 张世召
 * @Create 2025/3/11 21:11
 * @Version 1.0
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StrategyAwardStockKeyVO {
    // 策略ID
    private Long strategyId;
    // 奖品ID
    private Integer awardId;

}
