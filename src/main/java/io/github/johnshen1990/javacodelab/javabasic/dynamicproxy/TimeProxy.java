package io.github.johnshen1990.javacodelab.javabasic.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class TimeProxy implements InvocationHandler {
    private Object target;

    TimeProxy(Object target) {
        this.target = target;
    }

    public <T> T getProxy(){
        /**
         * 参数1：被代理类的classLoader
         * 参数2：被代理类实现的接口集合
         * 参数3：代理类的对象实例
         */
        return (T) Proxy.newProxyInstance(
                target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        long start = System.currentTimeMillis();
        System.out.println("startTime:" + start);
        method.invoke(target, args);
        long end = System.currentTimeMillis();
        System.out.println("endTime" + end);
        System.out.println("timeCost:" + (end - start));
        return null;
    }
}
