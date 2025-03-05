package cn.godrel.domain.strategy.service.annotation;

import cn.godrel.domain.strategy.service.rule.filter.factory.DefaultLogicFactory;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * ClassName: LogicStrategy
 * Package: cn.godrel.domain.strategy.service.annotation
 * Description:策略自定义枚举
 * @Author 张世召
 * @Create 2025/2/28 17:17
 * @Version 1.0
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface LogicStrategy {
    DefaultLogicFactory.LogicModel logicMode();
}
