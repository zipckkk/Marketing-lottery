package cn.godrel.infrastructure.persistent.dao;

import cn.bugstack.middleware.db.router.annotation.DBRouter;
import cn.godrel.infrastructure.persistent.po.RaffleActivityAccountMonth;
import org.apache.ibatis.annotations.Mapper;

import javax.annotation.MatchesPattern;

/**
 * ClassName: IRaffleActivityAccountMonthDao
 * Package: cn.godrel.infrastructure.persistent.dao
 * Description: 抽奖活动账户表-月次数
 *
 * @Author 张世召
 * @Create 2025/3/17 17:47
 * @Version 1.0
 */
@Mapper
public interface IRaffleActivityAccountMonthDao {
    @DBRouter
    RaffleActivityAccountMonth queryActivityAccountMonthByUserId(RaffleActivityAccountMonth raffleActivityAccountMonthReq);

    int updateActivityAccountMonthSubtractionQuota(RaffleActivityAccountMonth raffleActivityAccountMonth);

    void insertActivityAccountMonth(RaffleActivityAccountMonth raffleActivityAccountMonth);

    void addAccountQuota(RaffleActivityAccountMonth raffleActivityAccountMonth);
}
