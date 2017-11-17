package io.github.johnshen1990.javacodelab.javabasic.callable;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicLong;

public class FutureTest {

    private static AtomicLong atomicLong = new AtomicLong(0);

    public static class MyTask implements Callable<String> {

        @Override
        public String call() throws Exception {
            String threadId = String.valueOf(Thread.currentThread().getId());
            return threadId + "-->" + atomicLong.incrementAndGet();
        }
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        List<Future<String>> futureList = new ArrayList<>();

        // 线程池创建
        ExecutorService es = Executors.newCachedThreadPool();

        for(int i = 0; i < 50; i++) {
            futureList.add(es.submit(new MyTask()));
        }

        for(Future<String> future : futureList) {
            System.out.println(future.get());
        }

        // 线程池使用以后要销毁
        es.shutdown();
    }
}
