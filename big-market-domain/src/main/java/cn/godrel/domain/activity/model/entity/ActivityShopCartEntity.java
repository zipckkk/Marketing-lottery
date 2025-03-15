package cn.godrel.domain.activity.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * ClassName: ActivityShopCartEntity
 * Package: cn.godrel.domain.activity.model.entity
 * Description: 活动购物车实体对象
 *
 * @Author 张世召
 * @Create 2025/3/15 10:17
 * @Version 1.0
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ActivityShopCartEntity {
    /** 用户ID */
    private String userId;
    /** 商品SKU - activity + activity count */
    private Long sku;

}
