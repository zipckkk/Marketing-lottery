package cn.godrel.domain.award.model.volobj;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * ClassName: AwardStateVO
 * Package: cn.godrel.domain.award.model.volobj
 * Description: 奖品状态枚举值对象 【值对象，用于描述对象属性的值，一个对象中，一个属性，有多个状态值。】
 *
 * @Author 张世召
 * @Create 2025/3/18 13:59
 * @Version 1.0
 */
@Getter
@AllArgsConstructor
public enum AwardStateVO {
    create("create", "创建"),
    complete("complete", "发奖完成"),
    fail("fail", "发奖失败"),
    ;

    private final String code;
    private final String desc;
}
