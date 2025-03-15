package cn.godrel.domain.activity.model.valobj;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * ClassName: OrderStateVO
 * Package: cn.godrel.domain.activity.model.valobj
 * Description: 订单状态枚举值对象（用于描述对象属性的值，如枚举，不影响数据库操作的对象，无生命周期）
 *
 * @Author 张世召
 * @Create 2025/3/15 10:19
 * @Version 1.0
 */
@Getter
@AllArgsConstructor
public enum OrderStateVO {
    completed("completed", "完成");

    private final String code;
    private final String desc;

}
