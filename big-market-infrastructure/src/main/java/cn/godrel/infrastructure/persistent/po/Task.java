package cn.godrel.infrastructure.persistent.po;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * ClassName: Task
 * Package: cn.godrel.infrastructure.persistent.po
 * Description: 任务表，发送MQ
 *
 * @Author 张世召
 * @Create 2025/3/17 17:43
 * @Version 1.0
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Task {
    /** 自增ID */
    private String id;
    /** 用户ID */
    private String userId;
    /** 消息主题 */
    private String topic;
    /** 消息主体 */
    private String message;
    /** 消息编号 */
    private String messageId;
    /** 任务状态；create-创建、completed-完成、fail-失败 */
    private String state;
    /** 创建时间 */
    private Date createTime;
    /** 更新时间 */
    private Date updateTime;

}
