package cn.godrel.domain.activity.service.rule.impl;

import cn.godrel.domain.activity.model.entity.ActivityCountEntity;
import cn.godrel.domain.activity.model.entity.ActivityEntity;
import cn.godrel.domain.activity.model.entity.ActivitySkuEntity;
import cn.godrel.domain.activity.service.rule.AbstractActionChain;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * ClassName: ActivityBaseActionChain
 * Package: cn.godrel.domain.activity.service.rule.impl
 * Description: 活动规则过滤【日期、状态】
 *
 * @Author 张世召
 * @Create 2025/3/15 17:02
 * @Version 1.0
 */
@Slf4j
@Component("activity_base_action")
public class ActionBaseActionChain extends AbstractActionChain {
    @Override
    public boolean action(ActivitySkuEntity activitySkuEntity, ActivityEntity activityEntity, ActivityCountEntity activityCountEntity) {
        log.info("活动责任链-基础信息【有效期、状态】校验开始。");

        return next().action(activitySkuEntity, activityEntity, activityCountEntity);
    }
}
