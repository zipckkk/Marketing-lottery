package cn.godrel.domain.rebate.model.valobj;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.apache.logging.log4j.message.StringFormattedMessage;

/**
 * ClassName: BehaviorTypeVO
 * Package: cn.godrel.domain.rebate.model.valobj
 * Description: 行为类型枚举对象
 *
 * @Author 张世召
 * @Create 2025/3/20 13:44
 * @Version 1.0
 */
@Getter
@AllArgsConstructor
public enum BehaviorTypeVO {

    SIGN("sign", "签到（日历）"),
    OPENAI_PAY("openai_pay", "openai 外部支付完成"),
    ;

    private final String code;
    private final String info;
}
