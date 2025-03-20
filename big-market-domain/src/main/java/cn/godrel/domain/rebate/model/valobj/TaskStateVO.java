package cn.godrel.domain.rebate.model.valobj;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * ClassName: TaskStateVO
 * Package: cn.godrel.domain.rebate.model.valobj
 * Description: 任务状态值对象
 *
 * @Author 张世召
 * @Create 2025/3/20 15:03
 * @Version 1.0
 */
@Getter
@AllArgsConstructor
public enum TaskStateVO {
    create("create", "创建"),
    complete("complete", "发送完成"),
    fail("fail", "发送失败"),
    ;

    private final String code;
    private final String desc;
}
