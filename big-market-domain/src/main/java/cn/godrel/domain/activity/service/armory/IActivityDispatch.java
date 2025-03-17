package cn.godrel.domain.activity.service.armory;

import java.util.Date;

/**
 * ClassName: IActivityDispatch
 * Package: cn.godrel.domain.activity.service.armory
 * Description: 活动调度【扣减库存】
 *
 * @Author 张世召
 * @Create 2025/3/16 21:02
 * @Version 1.0
 */
public interface IActivityDispatch {
    /**
     * 根据策略ID和奖品ID，扣减奖品缓存库存
     *
     * @param sku 互动 SKU
     * @param endDateTime 活动结束时间，根据结束时间设置加锁的key为结束时间
     * @return 扣减结果
     */
    boolean subtractionActivitySkuStock(Long sku, Date endDateTime);

}
