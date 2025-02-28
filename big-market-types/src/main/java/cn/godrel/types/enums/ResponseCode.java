package cn.godrel.types.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * ClassName: ResponseCode
 * Package: cn.godrel.types.enums
 * Description:
 *
 * @Author 张世召
 * @Create 2025/2/26 16:54
 * @Version 1.0
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
public enum ResponseCode {
    SUCCESS("0000", "成功"),
    UN_ERROR("0001", "未知失败"),
    ILLEGAL_PARAMETER("0002", "非法参数"),
    STRATEGY_RULE_WEIGHT_IS_NULL("ERR_BIZ_001", "业务异常，策略规则中 rule_weight 权重规则已适用但未配置"),
    ;

    private String code;
    private String info;

}
