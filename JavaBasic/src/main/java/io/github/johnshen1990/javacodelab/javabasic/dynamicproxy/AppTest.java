package io.github.johnshen1990.javacodelab.javabasic.dynamicproxy;

public class AppTest {
    public static void main(String[] args) {
        Movable tank = new Tank();
        Movable tankLogProxy = new LogProxy(tank).getProxy();
        Movable tankTimeProxy = new TimeProxy(tankLogProxy).getProxy();
        tankTimeProxy.move();
    }
}
