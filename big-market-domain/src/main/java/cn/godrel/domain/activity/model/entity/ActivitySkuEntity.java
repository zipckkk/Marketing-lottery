package cn.godrel.domain.activity.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * ClassName: ActivitySkuEntity
 * Package: cn.godrel.domain.activity.model.entity
 * Description: 活动sku实体对象
 *
 * @Author 张世召
 * @Create 2025/3/15 10:17
 * @Version 1.0
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ActivitySkuEntity {
    /** 商品sku */
    private Long sku;
    /** 活动ID */
    private Long activityId;
    /** 活动个人参数ID；在这个活动上，一个人可参与多少次活动（总、日、月） */
    private Long activityCountId;
    /** 库存总量 */
    private Integer stockCount;
    /** 剩余库存 */
    private Integer stockCountSurplus;

}
