package io.github.johnshen1990.javacodelab.javabasic.executor;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorTest implements Callable<String>{
    public static void main(String[] args) {
        ExecutorService executorService1 = Executors.newCachedThreadPool();
        ExecutorService executorService2 = Executors.newFixedThreadPool(10);
        ExecutorService executorService3 = Executors.newSingleThreadExecutor();


    }

    @Override
    public String call() throws Exception {
        Thread.sleep(60000);
        return "ok";
    }
}
