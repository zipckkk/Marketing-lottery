package cn.godrel.domain.award.model.aggregate;

import cn.godrel.domain.award.model.entity.TaskEntity;
import cn.godrel.domain.award.model.entity.UserAwardRecordEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * ClassName: UserAwardRecordAggregate
 * Package: cn.godrel.domain.award.model.aggregate
 * Description: 用户中奖记录聚合对象 【聚合代表一个事务操作】
 *
 * @Author 张世召
 * @Create 2025/3/18 14:00
 * @Version 1.0
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserAwardRecordAggregate {

    private UserAwardRecordEntity userAwardRecordEntity;

    private TaskEntity taskEntity;

}
