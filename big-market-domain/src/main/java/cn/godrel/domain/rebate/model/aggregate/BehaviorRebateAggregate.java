package cn.godrel.domain.rebate.model.aggregate;

import cn.godrel.domain.rebate.model.entity.BehaviorRebateOrderEntity;
import cn.godrel.domain.rebate.model.entity.TaskEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * ClassName: BehaviorRebateAggregate
 * Package: cn.godrel.domain.rebate.model.aggregate
 * Description: 行为返利聚合对象
 *
 * @Author 张世召
 * @Create 2025/3/20 15:15
 * @Version 1.0
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BehaviorRebateAggregate {
    /** 用户ID */
    private String userId;
    /** 行为返利订单实体对象 */
    private BehaviorRebateOrderEntity behaviorRebateOrderEntity;
    /** 任务实体对象 */
    private TaskEntity taskEntity;
}
