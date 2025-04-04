package cn.godrel.infrastructure.persistent.po;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * ClassName: UserRaffleOrder
 * Package: cn.godrel.infrastructure.persistent.po
 * Description: 用户抽奖订单表
 *
 * @Author 张世召
 * @Create 2025/3/17 17:45
 * @Version 1.0
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserRaffleOrder {
    /** 用户ID */
    private String id;
    /** 活动ID */
    private String userId;
    /** 活动名称 */
    private Long activityId;
    /** 抽奖策略ID */
    private String activityName;
    /** 订单ID */
    private Long strategyId;
    /** 下单时间 */
    private String orderId;
    /** 订单状态；create-创建、used-已使用、cancel-已作废 */
    private Date orderTime;
    /** 创建时间 */
    private String orderState;
    /** 更新时间 */
    private Date createTime;
    /**  */
    private Date updateTime;

}
