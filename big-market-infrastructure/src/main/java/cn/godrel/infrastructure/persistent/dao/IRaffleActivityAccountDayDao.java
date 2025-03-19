package cn.godrel.infrastructure.persistent.dao;

import cn.bugstack.middleware.db.router.annotation.DBRouter;
import cn.godrel.infrastructure.persistent.po.RaffleActivityAccountDay;
import org.apache.ibatis.annotations.Mapper;

/**
 * ClassName: IRaffleActivityAccountDayDao
 * Package: cn.godrel.infrastructure.persistent.dao
 * Description: 抽奖活动账户表-日次数
 *
 * @Author 张世召
 * @Create 2025/3/17 17:46
 * @Version 1.0
 */
@Mapper
public interface IRaffleActivityAccountDayDao {

    @DBRouter
    RaffleActivityAccountDay queryActivityAccountDayByUserId(RaffleActivityAccountDay raffleActivityAccountDayReq);

    int updateActivityAccountDaySubtractionQuota(RaffleActivityAccountDay raffleActivityAccountDay);

    void insertActivityAccountDay(RaffleActivityAccountDay raffleActivityAccountDay);

    @DBRouter
    Integer queryRaffleActivityAccountDayPartakeCount(RaffleActivityAccountDay raffleActivityAccountDay);
}
