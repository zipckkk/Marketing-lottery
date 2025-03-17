package cn.godrel.domain.activity.repository;

import cn.godrel.domain.activity.model.aggregate.CreateOrderAggregate;
import cn.godrel.domain.activity.model.entity.ActivityCountEntity;
import cn.godrel.domain.activity.model.entity.ActivityEntity;
import cn.godrel.domain.activity.model.entity.ActivitySkuEntity;
import cn.godrel.domain.activity.model.valobj.ActivitySkuStockKeyVO;

import java.util.Date;

/**
 * ClassName: IActivityRepository
 * Package: cn.godrel.domain.activity.repository
 * Description: 活动仓储接口
 *
 * @Author 张世召
 * @Create 2025/3/15 10:12
 * @Version 1.0
 */
public interface IActivityRepository {

    ActivitySkuEntity queryActivitySku(Long sku);

    ActivityEntity queryRaffleActivityByActivityId(Long activityId);

    ActivityCountEntity queryRaffleActivityCountByActivityCountId(Long activityCountId);

    void doSaveOrder(CreateOrderAggregate createOrderAggregate);

    void cacheActivitySkuStockCount(String cacheKey, Integer stockCount);

    boolean subtractionActivitySkuStock(Long sku, String cacheKey, Date endDateTime);

    void activitySkuStockConsumeSendQueue(ActivitySkuStockKeyVO activitySkuStockKeyVO);

    void updateActivitySkuStock(Long sku);

    ActivitySkuStockKeyVO takeQueueValue();

    void clearQueueValue();

    void clearActivitySkuStock(Long sku);
}
