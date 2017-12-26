package io.github.johnshen1990.javacodelab.javabasic.chainofresponsibility;

/**
 * Author: zhun.shen
 * Date: 2017-07-07 11:20
 * Description:
 */
public class Tester {
    // 构建处理链，返回链头
    public static Handler buildHandlerChain(){
        Handler manager = new ManagerHandler(3);
        Handler director = new DirectorHandler(7);
        Handler boss = new BossHandler(Integer.MAX_VALUE);

        manager.setSuccessor(director);
        director.setSuccessor(boss);
        return manager;
    }

    public static void main(String[] args) {
        Handler handlerChain = buildHandlerChain();

        handlerChain.handle(new Request("张三", 2));
        handlerChain.handle(new Request("李四", 5));
        handlerChain.handle(new Request("王五", 10));
        handlerChain.handle(new Request("王尼玛", 365));
    }
}
