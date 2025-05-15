package cn.godrel.domain.award.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * ClassName: DistributeAwardEntity
 * Package: cn.godrel.domain.award.model.entity
 * Description: 分发奖品的实体对象
 *
 * @Author 张世召
 * @Create 2025/5/14 17:07
 * @Version 1.0
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DistributeAwardEntity {

    /**
     * 用户ID
     */
    private String userId;
    /**
     * 订单ID
     */
    private String orderId;
    /**
     * 奖品ID
     */
    private Integer awardId;
    /**
     * 奖品配置信息
     */
    private String awardConfig;

}