package cn.godrel.domain.activity.model.entity;

import cn.godrel.domain.activity.model.valobj.UserRaffleOrderStateVO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * ClassName: UserRaffleOrderEntity
 * Package: cn.godrel.domain.activity.model.entity
 * Description: 用户抽奖订单实体对象
 *
 * @Author 张世召
 * @Create 2025/3/17 19:54
 * @Version 1.0
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserRaffleOrderEntity {
    /** 用户ID */
    private String userId;
    /** 活动ID */
    private Long activityId;
    /** 活动名称 */
    private String activityName;
    /** 抽奖策略ID */
    private Long strategyId;
    /** 订单ID */
    private String orderId;
    /** 下单时间 */
    private Date orderTime;
    /** 订单状态；create-创建、used-已使用、cancel-已作废 */
    private UserRaffleOrderStateVO orderState;
    /**
     * 结束时间
     */
    private Date endDateTime;
}
