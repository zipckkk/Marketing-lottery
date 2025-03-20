package cn.godrel.infrastructure.persistent.po;

import lombok.Data;

import java.util.Date;

/**
 * ClassName: DailyBehaviorRebate
 * Package: cn.godrel.infrastructure.persistent.po
 * Description:日常行为返利活动配置 持久化对象
 *
 * @Author 张世召
 * @Create 2025/3/19 22:26
 * @Version 1.0
 */
@Data
public class DailyBehaviorRebate {
    /** 自增ID */
    private Long id;
    /** 行为类型（sign 签到、openai_pay 支付） */
    private String behaviorType;
    /** 返利描述 */
    private String rebateDesc;
    /** 返利类型（sku 活动库存充值商品、integral 用户活动积分） */
    private String rebateType;
    /** 返利配置 */
    private String rebateConfig;
    /** 状态（open 开启、close 关闭） */
    private String state;
    /** 创建时间 */
    private Date createTime;
    /** 更新时间 */
    private Date updateTime;
}
