package cn.godrel.domain.activity.model.valobj;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * ClassName: ActivitySkuStockKeyVO
 * Package: cn.godrel.domain.activity.model.valobj
 * Description: 活动sku库存 key 值对象
 *
 * @Author 张世召
 * @Create 2025/3/16 22:10
 * @Version 1.0
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ActivitySkuStockKeyVO {
    /** 商品sku */
    private Long sku;
    /** 活动ID */
    private Long activityId;

}
