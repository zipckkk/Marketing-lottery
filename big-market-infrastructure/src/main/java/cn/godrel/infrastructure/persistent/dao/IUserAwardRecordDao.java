package cn.godrel.infrastructure.persistent.dao;

import cn.bugstack.middleware.db.router.annotation.DBRouterStrategy;
import cn.godrel.infrastructure.persistent.po.UserAwardRecord;
import org.apache.ibatis.annotations.Mapper;

/**
 * ClassName: IUserAwardRecordDao
 * Package: cn.godrel.infrastructure.persistent.dao
 * Description: 用户中奖记录表
 *
 * @Author 张世召
 * @Create 2025/3/17 17:47
 * @Version 1.0
 */
@Mapper
@DBRouterStrategy(splitTable = true)
public interface IUserAwardRecordDao {
    void insert(UserAwardRecord userAwardRecord);

    int updateAwardRecordCompletedState(UserAwardRecord userAwardRecordReq);


}
