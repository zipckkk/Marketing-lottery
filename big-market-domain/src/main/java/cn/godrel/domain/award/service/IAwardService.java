package cn.godrel.domain.award.service;

import cn.godrel.domain.award.model.entity.UserAwardRecordEntity;

/**
 * ClassName: IAwardService
 * Package: cn.godrel.domain.award.service
 * Description: 奖品服务接口
 *
 * @Author 张世召
 * @Create 2025/3/18 13:44
 * @Version 1.0
 */
public interface IAwardService {

    void saveUserAwardRecord(UserAwardRecordEntity userAwardRecordEntity);
}
