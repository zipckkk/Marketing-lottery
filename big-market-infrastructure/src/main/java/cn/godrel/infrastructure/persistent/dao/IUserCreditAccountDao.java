package cn.godrel.infrastructure.persistent.dao;

import cn.godrel.infrastructure.persistent.po.UserCreditAccount;
import org.apache.ibatis.annotations.Mapper;

/**
 * ClassName: IUserCreditAccountDao
 * Package: cn.godrel.infrastructure.persistent.dao
 * Description:用户积分账户
 *
 * @Author 张世召
 * @Create 2025/5/14 17:03
 * @Version 1.0
 */
@Mapper
public interface IUserCreditAccountDao {
    void insert(UserCreditAccount userCreditAccountReq);

    int updateAddAmount(UserCreditAccount userCreditAccountReq);

    UserCreditAccount queryUserCreditAccount(UserCreditAccount userCreditAccountReq);
}
