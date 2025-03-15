package cn.godrel.infrastructure.persistent.dao;

import cn.godrel.infrastructure.persistent.po.RaffleActivityAccount;
import org.apache.ibatis.annotations.Mapper;

/**
 * ClassName: IRaffleActivityAccountDao
 * Package: cn.godrel.infrastructure.persistent.dao
 * Description: 抽奖活动账户表
 *
 * @Author 张世召
 * @Create 2025/3/14 14:42
 * @Version 1.0
 */
@Mapper
public interface IRaffleActivityAccountDao {
    int updateAccountQuota(RaffleActivityAccount raffleActivityAccount);

    void insert(RaffleActivityAccount raffleActivityAccount);
}
