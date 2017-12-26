package io.github.johnshen1990.javacodelab.javabasic.designpattern.singleton;

public class LazySingleton1 {
    private static LazySingleton1 instance = null;
    private LazySingleton1() {}
    public static LazySingleton1 getInstance(){
        if(instance == null) { // 当instance已经被创建时，可以实现高效的无锁化访问
            synchronized (LazySingleton1.class) {
                if (instance == null) { // double-check，防止对象多次被创建
                    instance = new LazySingleton1();
                }
            }
        }
        return instance;
    }
}
