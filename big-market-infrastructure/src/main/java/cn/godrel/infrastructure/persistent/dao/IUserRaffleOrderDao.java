package cn.godrel.infrastructure.persistent.dao;

import cn.bugstack.middleware.db.router.annotation.DBRouter;
import cn.bugstack.middleware.db.router.annotation.DBRouterStrategy;
import cn.godrel.infrastructure.persistent.po.UserRaffleOrder;
import org.apache.ibatis.annotations.Mapper;

/**
 * ClassName: IUserRaffleOrderDao
 * Package: cn.godrel.infrastructure.persistent.dao
 * Description: 用户抽奖订单表
 *
 * @Author 张世召
 * @Create 2025/3/17 17:48
 * @Version 1.0
 */
@Mapper
@DBRouterStrategy(splitTable = true)
public interface IUserRaffleOrderDao {
    void insert(UserRaffleOrder userRaffleOrder);

    @DBRouter
    UserRaffleOrder queryNoUsedRaffleOrder(UserRaffleOrder userRaffleOrderReq);

    int updateUserRaffleOrderStateUsed(UserRaffleOrder userRaffleOrderReq);
}
