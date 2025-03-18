package cn.godrel.domain.activity.model.aggregate;

import cn.godrel.domain.activity.model.entity.ActivityAccountDayEntity;
import cn.godrel.domain.activity.model.entity.ActivityAccountEntity;
import cn.godrel.domain.activity.model.entity.ActivityAccountMonthEntity;
import cn.godrel.domain.activity.model.entity.UserRaffleOrderEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * ClassName: CreatePartakeOrderAggregate
 * Package: cn.godrel.domain.activity.model.aggregate
 * Description: 参与活动订单聚合对象
 *
 * @Author 张世召
 * @Create 2025/3/17 20:11
 * @Version 1.0
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreatePartakeOrderAggregate {
    /**
     * 用户ID
     */
    private String userId;

    /**
     * 活动ID
     */
    private Long activityId;

    /**
     * 账户总额度
     */
    private ActivityAccountEntity activityAccountEntity;

    /**
     * 是否存在月账户
     */
    private boolean isExistAccountMonth = true;

    /**
     * 账户月额度
     */
    private ActivityAccountMonthEntity activityAccountMonthEntity;

    /**
     * 是否存在日账户
     */
    private boolean isExistAccountDay = true;

    /**
     * 账户日额度
     */
    private ActivityAccountDayEntity activityAccountDayEntity;

    /**
     * 抽奖单实体
     */
    private UserRaffleOrderEntity userRaffleOrderEntity;

}
