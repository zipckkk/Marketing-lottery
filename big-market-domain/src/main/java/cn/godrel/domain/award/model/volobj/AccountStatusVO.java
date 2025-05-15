package cn.godrel.domain.award.model.volobj;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * ClassName: AccountStatusVO
 * Package: cn.godrel.domain.award.model.volobj
 * Description:账户状态枚举
 *
 * @Author 张世召
 * @Create 2025/5/14 20:09
 * @Version 1.0
 */
@Getter
@AllArgsConstructor
public enum AccountStatusVO {

    open("open", "开启"),
    close("close", "冻结"),
    ;

    private final String code;
    private final String desc;

}
