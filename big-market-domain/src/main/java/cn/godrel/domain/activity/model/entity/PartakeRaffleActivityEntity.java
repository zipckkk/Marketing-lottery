package cn.godrel.domain.activity.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * ClassName: PartakeRaffleActivityEntity
 * Package: cn.godrel.domain.activity.model.entity
 * Description: 参与抽奖活动实体对象
 *
 * @Author 张世召
 * @Create 2025/3/17 19:53
 * @Version 1.0
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PartakeRaffleActivityEntity {
    /**
     * 用户ID
     */
    private String userId;

    /**
     * 活动ID
     */
    private Long activityId;

}
