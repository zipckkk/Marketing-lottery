package cn.godrel.domain.award.model.volobj;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * ClassName: TaskStateVO
 * Package: cn.godrel.domain.award.model.volobj
 * Description: 任务状态值对象
 *
 * @Author 张世召
 * @Create 2025/3/18 13:58
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
