package cn.godrel.infrastructure.persistent.dao;

import cn.godrel.infrastructure.persistent.po.RaffleActivitySku;
import org.apache.ibatis.annotations.Mapper;

/**
 * ClassName: IRaffleActivitySkuDao
 * Package: cn.godrel.infrastructure.persistent.dao
 * Description: 商品SKU的dao
 *
 * @Author 张世召
 * @Create 2025/3/14 20:56
 * @Version 1.0
 */
@Mapper
public interface IRaffleActivitySkuDao {

    RaffleActivitySku queryActivitySku(Long sku);

    void updateActivitySkuStock(Long sku);

    void clearActivitySkuStock(Long sku);
}
