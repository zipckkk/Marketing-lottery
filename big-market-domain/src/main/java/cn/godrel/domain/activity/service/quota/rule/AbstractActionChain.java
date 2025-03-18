package cn.godrel.domain.activity.service.quota.rule;

/**
 * ClassName: AbstractActionChain
 * Package: cn.godrel.domain.activity.service.rule
 * Description: 下单规则责任链抽象类
 *
 * @Author 张世召
 * @Create 2025/3/15 17:01
 * @Version 1.0
 */
public abstract class AbstractActionChain implements IActionChain {
    private IActionChain next;

    @Override
    public IActionChain next() {
        return next;
    }

    @Override
    public IActionChain appendNext(IActionChain next) {
        this.next = next;
        return next;
    }

}
