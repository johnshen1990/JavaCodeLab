package io.github.johnshen1990.javacodelab.javabasic.designpattern.singleton;

public class LazySingleton2 {
    private LazySingleton2() {}
    private static class InstanceHolder {
        private static final LazySingleton2 INSTANCE = new LazySingleton2();
    }
    public static LazySingleton2 getInstance() {
        return InstanceHolder.INSTANCE;
    }
}
