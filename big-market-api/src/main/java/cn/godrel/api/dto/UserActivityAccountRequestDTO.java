package cn.godrel.api.dto;

import lombok.Data;

/**
 * ClassName: UserActivityAccountResponseDTO
 * Package: cn.godrel.api.dto
 * Description: 用户活动账户请求对象
 *
 * @Author 张世召
 * @Create 2025/3/21 17:07
 * @Version 1.0
 */
@Data
public class UserActivityAccountRequestDTO {
    /**
     * 用户ID
     */
    private String userId;

    /**
     * 活动ID
     */
    private Long activityId;
}
