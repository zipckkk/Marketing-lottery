package cn.godrel.domain.award.repository;

import cn.godrel.domain.award.model.aggregate.UserAwardRecordAggregate;

/**
 * ClassName: IAwardRepository
 * Package: cn.godrel.domain.award.repository
 * Description: 奖品仓储服务
 *
 * @Author 张世召
 * @Create 2025/3/18 14:36
 * @Version 1.0
 */
public interface IAwardRepository {

    void saveUserAwardRecord(UserAwardRecordAggregate userAwardRecordAggregate);

}
