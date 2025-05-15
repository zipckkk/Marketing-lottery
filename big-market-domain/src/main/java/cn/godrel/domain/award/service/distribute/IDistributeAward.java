package cn.godrel.domain.award.service.distribute;

import cn.godrel.domain.award.model.entity.DistributeAwardEntity;

/**
 * ClassName: IUserCreditAccountDao
 * Package: cn.godrel.domain.award.service.distribute
 * Description:分发奖品接口
 *
 * @Author 张世召
 * @Create 2025/5/14 17:05
 * @Version 1.0
 */
public interface IDistributeAward {
    void giveOutPrize(DistributeAwardEntity distributeAwardEntity);
}
