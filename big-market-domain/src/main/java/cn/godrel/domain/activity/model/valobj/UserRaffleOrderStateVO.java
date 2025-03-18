package cn.godrel.domain.activity.model.valobj;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * ClassName: UserRaffleOrderStateVO
 * Package: cn.godrel.domain.activity.model.valobj
 * Description: 用户抽奖订单状态枚举
 *
 * @Author 张世召
 * @Create 2025/3/17 19:58
 * @Version 1.0
 */
@Getter
@AllArgsConstructor
public enum UserRaffleOrderStateVO {
    create("create", "创建"),
    used("used", "已使用"),
    cancel("cancel", "已作废"),
    ;

    private final String code;
    private final String desc;

}
