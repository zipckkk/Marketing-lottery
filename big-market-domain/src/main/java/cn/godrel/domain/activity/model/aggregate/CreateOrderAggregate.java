package cn.godrel.domain.activity.model.aggregate;

import cn.godrel.domain.activity.model.entity.ActivityAccountEntity;
import cn.godrel.domain.activity.model.entity.ActivityOrderEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * ClassName: CreateOrderAggregate
 * Package: cn.godrel.domain.activity.model.aggregate
 * Description: 下单聚合对象
 *
 * @Author 张世召
 * @Create 2025/3/15 10:13
 * @Version 1.0
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateOrderAggregate {

    /**
     * 活动账户实体
     */
    private ActivityAccountEntity activityAccountEntity;
    /**
     * 活动订单实体
     */
    private ActivityOrderEntity activityOrderEntity;


}
