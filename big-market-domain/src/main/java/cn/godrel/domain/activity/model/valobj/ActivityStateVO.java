package cn.godrel.domain.activity.model.valobj;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * ClassName: ActivityStateVO
 * Package: cn.godrel.domain.activity.model.valobj
 * Description: 活动状态值对象
 *
 * @Author 张世召
 * @Create 2025/3/15 10:18
 * @Version 1.0
 */
@Getter
@AllArgsConstructor
public enum ActivityStateVO {
    create("create", "创建"),
    open("open", "开启"),
    close("close", "关闭"),
    ;

    private final String code;
    private final String desc;


}
