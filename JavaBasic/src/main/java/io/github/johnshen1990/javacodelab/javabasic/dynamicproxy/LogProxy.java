package io.github.johnshen1990.javacodelab.javabasic.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class LogProxy implements InvocationHandler {
    private Object target;

    LogProxy(Object target) {
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

    /**
     *
     * @param proxy 被代理的对象（真实对象）
     * @param method 被代理对象的方法（真实对象的真实方法）
     * @param args 要调用真实对象的方法时接受的参数
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("start logging...");
        method.invoke(target, args);
        System.out.println("end logging...");
        return null;
    }
}
