package cn.godrel.api.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * ClassName: RaffleResponseDTO
 * Package: cn.godrel.api.dto
 * Description: 抽奖应答结果
 *
 * @Author 张世召
 * @Create 2025/3/13 11:43
 * @Version 1.0
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RaffleStrategyResponseDTO {
    // 奖品ID
    private Integer awardId;
    // 排序编号【策略奖品配置的奖品顺序编号】
    private Integer awardIndex;

}
