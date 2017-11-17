package io.github.johnshen1990.javacodelab.javabasic.thread;

import java.util.concurrent.*;

public class MultiThread3 implements Callable<String> {
    @Override
    public String call() throws Exception {
        System.out.println("A thread is running!");
        return "OK";
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        try {
            Future<String> future = executorService.submit(new MultiThread3());
            System.out.println("return:" + future.get());
        } finally {
            executorService.shutdown();
        }
    }
}
