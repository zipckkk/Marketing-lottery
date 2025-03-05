package cn.godrel.domain.strategy.service.rule.chain;

/**
 * ClassName: AbstractLogicChain
 * Package: cn.godrel.domain.strategy.service.rule.chain
 * Description:
 *
 * @Author 张世召
 * @Create 2025/3/5 16:31
 * @Version 1.0
 */
public abstract class AbstractLogicChain implements ILogicChain{
    private ILogicChain next;

    @Override
    public ILogicChain appendNext(ILogicChain next) {
        this.next = next;
        return next;
    }

    @Override
    public ILogicChain next() {
        return next;
    }

    protected abstract String ruleModel();
}
