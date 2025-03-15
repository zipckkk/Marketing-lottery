package cn.godrel.domain.activity.service.rule;

import cn.godrel.domain.activity.model.entity.ActivityCountEntity;
import cn.godrel.domain.activity.model.entity.ActivityEntity;
import cn.godrel.domain.activity.model.entity.ActivitySkuEntity;

/**
 * ClassName: IActivityChain
 * Package: cn.godrel.domain.activity.service.rule
 * Description: 下单规则责任链接口
 *
 * @Author 张世召
 * @Create 2025/3/15 16:50
 * @Version 1.0
 */
public interface IActionChain extends IActionChainArmory{   //继承的好处？？

    boolean action(ActivitySkuEntity activitySkuEntity, ActivityEntity activityEntity, ActivityCountEntity activityCountEntity);

}
