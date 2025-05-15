package cn.godrel.infrastructure.persistent.dao;

import cn.godrel.infrastructure.persistent.po.Award;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * ClassName: IAwardDao
 * Package: cn.godrel.infrastructure.persistent.dao
 * Description:奖品表Dao
 * @Author 张世召
 * @Create 2025/2/24 14:20
 * @Version 1.0
 */
@Mapper
public interface IAwardDao {

    List<Award> queryAwardList();

    String queryAwardConfigByAwardId(Integer awardId);

    String queryAwardKeyByAwardId(Integer awardId);
}
