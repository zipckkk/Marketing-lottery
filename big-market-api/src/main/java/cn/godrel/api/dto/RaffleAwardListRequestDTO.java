package cn.godrel.api.dto;

import lombok.Data;

/**
 * ClassName: RaffleAwardListRequestDTO
 * Package: cn.godrel.api.dto
 * Description: 抽奖奖品列表，请求对象
 *
 * @Author 张世召
 * @Create 2025/3/13 11:39
 * @Version 1.0
 */
@Data
public class RaffleAwardListRequestDTO {

    // 抽奖策略ID
    @Deprecated
    private Long strategyId;

    // 用户ID
    private String userId;
    // 抽奖活动ID
    private Long activityId;


}
