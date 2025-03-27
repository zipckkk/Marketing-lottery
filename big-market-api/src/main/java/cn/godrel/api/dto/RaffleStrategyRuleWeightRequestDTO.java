package cn.godrel.api.dto;

import lombok.Data;

/**
 * ClassName: RaffleStrategyRuleWeightRequestDTO
 * Package: cn.godrel.api.dto
 * Description: 抽奖策略规则，权重配置，查询N次抽奖可解锁奖品范围，请求对象
 *
 * @Author 张世召
 * @Create 2025/3/22 10:07
 * @Version 1.0
 */
@Data
public class RaffleStrategyRuleWeightRequestDTO {
    // 用户ID
    private String userId;
    // 抽奖活动ID
    private Long activityId;
}
