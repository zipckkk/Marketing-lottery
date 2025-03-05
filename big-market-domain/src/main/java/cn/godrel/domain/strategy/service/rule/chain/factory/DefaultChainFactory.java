package cn.godrel.domain.strategy.service.rule.chain.factory;

import cn.godrel.domain.strategy.model.entity.StrategyEntity;
import cn.godrel.domain.strategy.repository.IStrategyRepository;
import cn.godrel.domain.strategy.service.rule.chain.ILogicChain;
import org.springframework.stereotype.Service;

import javax.xml.ws.ServiceMode;
import java.util.Map;

/**
 * ClassName: DefaultChainFactory
 * Package: cn.godrel.domain.strategy.service.rule.chain.factory
 * Description: 工厂
 * @Author 张世召
 * @Create 2025/3/5 17:02
 * @Version 1.0
 */
@Service
public class DefaultChainFactory {

    private final Map<String, ILogicChain> logicChainGroup;
    private final IStrategyRepository repository;

    public DefaultChainFactory(Map<String, ILogicChain> logicChainGroup, IStrategyRepository repository) {
        this.logicChainGroup = logicChainGroup;
        this.repository = repository;
    }

    public ILogicChain openLogicChain(Long strategyId) {
        StrategyEntity strategy = repository.queryStrategyEntityByStrategyId(strategyId);
        String[] ruleModels = strategy.ruleModels();
        if (ruleModels == null || ruleModels.length == 0) return logicChainGroup.get("default");

        ILogicChain logicChain = logicChainGroup.get(ruleModels[0]);
        ILogicChain current = logicChain;
        for (int i = 1; i < ruleModels.length; i++){
            ILogicChain nextChain = logicChainGroup.get(ruleModels[i]);
            current = current.appendNext(nextChain);
        }

        current.appendNext(logicChainGroup.get("default"));
        return logicChain;
    }
}
