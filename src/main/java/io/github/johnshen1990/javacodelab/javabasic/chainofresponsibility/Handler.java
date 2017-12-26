package io.github.johnshen1990.javacodelab.javabasic.chainofresponsibility;

/**
 * Author: zhun.shen
 * Date: 2017-07-07 11:04
 * Description:
 */
public abstract class Handler {
    // 处理者的后继处理者
    private Handler successor;
    // 处理者能够处理的最大请假天数
    protected int maxDay;

    public void setSuccessor(Handler successor) {
        this.successor = successor;
    }

    // 处理请求
    public void handle(Request request) {
        if (request.getApplyDay() <= maxDay) {
            doHandle(request);
        } else if (successor != null) {
            successor.handle(request);
        }
    }

    // 实际处理请求的方法，需要被各个具体的Handler实现
    public abstract void doHandle(Request request);
}
