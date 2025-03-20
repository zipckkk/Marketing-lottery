package cn.godrel.domain.rebate.model.valobj;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * ClassName: RebateTypeVO
 * Package: cn.godrel.domain.rebate.model.valobj
 * Description: 返利类型（sku 活动库存充值商品、integral 用户活动积分）
 *
 * @Author 张世召
 * @Create 2025/3/20 15:02
 * @Version 1.0
 */
@Getter
@AllArgsConstructor
public enum RebateTypeVO {
    SKU("sku", "活动库存充值商品"),
    INTEGRAL("integral", "用户活动积分"),
    ;

    private final String code;
    private final String info;
}
