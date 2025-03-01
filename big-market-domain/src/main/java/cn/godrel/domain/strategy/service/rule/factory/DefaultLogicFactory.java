package cn.godrel.domain.strategy.service.rule.factory;

import cn.godrel.domain.strategy.model.entity.RuleActionEntity;
import cn.godrel.domain.strategy.service.annotation.LogicStrategy;
import cn.godrel.domain.strategy.service.rule.ILogicFilter;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * ClassName: DefaultLogicFactory
 * Package: cn.godrel.domain.strategy.service.rule.factory
 * Description: 规则工厂
 * @Author 张世召
 * @Create 2025/2/28 17:16
 * @Version 1.0
 */
@Service
public class DefaultLogicFactory {
    public Map<String, ILogicFilter<?>> logicFilterMap = new ConcurrentHashMap<>();

    /**
     * 作用：存储所有规则过滤器的实例，Key 为规则编码（如 "rule_weight"），Value 为对应的过滤器。
     * 线程安全：使用 ConcurrentHashMap 保证并发安全。
     * 泛型说明：ILogicFilter<?> 表示接受任意类型的规则实体（如 RuleActionEntity.RaffleBeforeEntity）。
     */
    public DefaultLogicFactory(List<ILogicFilter<?>> logicFilters) {
        logicFilters.forEach(logic -> {
            // 获取类上的 @LogicStrategy 注解
            LogicStrategy strategy = AnnotationUtils.findAnnotation(logic.getClass(), LogicStrategy.class);
            if (null != strategy) {
                // 将过滤器的规则编码作为 Key，实例作为 Value
                logicFilterMap.put(strategy.logicMode().getCode(), logic);
            }
        });
    }

    /**
     * 作用：对外提供已注册的规则过滤器集合。
     * 泛型转换：将 ILogicFilter<?> 转换为 ILogicFilter<T>，可能存在类型转换警告（需确保类型安全）。
     */
    public <T extends RuleActionEntity.RaffleEntity> Map<String, ILogicFilter<T>> openLogicFilter() {
        return (Map<String, ILogicFilter<T>>) (Map<?, ?>) logicFilterMap;
    }

    @Getter
    @AllArgsConstructor
    public enum LogicModel {

        RULE_WIGHT("rule_weight","【抽奖前规则】根据抽奖权重返回可抽奖范围KEY"),
        RULE_BLACKLIST("rule_blacklist","【抽奖前规则】黑名单规则过滤，命中黑名单则直接返回"),
        ;

        private final String code;
        private final String info;

    }

}
