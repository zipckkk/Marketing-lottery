package cn.godrel.domain.strategy.model.valobj;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * ClassName: RuleLogicCheckTypeVO
 * Package: cn.godrel.domain.strategy.model.vo
 * Description:
 * @Author 张世召
 * @Create 2025/2/28 16:50
 * @Version 1.0
 */
@Getter
@AllArgsConstructor
public enum RuleLogicCheckTypeVO {
    ALLOW("0000", "放行；执行后续的流程，不受规则引擎影响"),
    TAKE_OVER("0001","接管；后续的流程，受规则引擎执行结果影响"),
    ;

    private final String code;
    private final String info;

}
