package cn.godrel.api.dto;

import lombok.Data;

/**
 * ClassName: ActivityDrawRequestDTO
 * Package: cn.godrel.api.dto
 * Description: 活动抽奖请求对象
 *
 * @Author 张世召
 * @Create 2025/3/18 17:47
 * @Version 1.0
 */
@Data
public class ActivityDrawRequestDTO {
    /**
     * 用户ID
     */
    private String userId;

    /**
     * 活动ID
     */
    private Long activityId;

}
