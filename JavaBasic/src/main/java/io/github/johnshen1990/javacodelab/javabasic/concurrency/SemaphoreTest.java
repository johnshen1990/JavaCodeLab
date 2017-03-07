package io.github.johnshen1990.javacodelab.javabasic.concurrency;

import java.util.concurrent.*;

/**
 * Author: zhun.shen
 * Date: 2017-03-07 10:29
 * Description:
 */
public class SemaphoreTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        String request = "hello";
        String reponse = null;
        try {
            reponse = new SemaphoreTest().doRequest(request).get(2000, TimeUnit.MILLISECONDS);
        } catch (TimeoutException e) {
            System.out.println(e.getMessage());
        }
        System.out.println(reponse);

    }

    private MyFuture doRequest(String request){
        final MyFuture myFuture = new MyFuture(request);

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    // 工作线程睡3秒,表示正在处理请求
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                String response = "world";
                myFuture.setResponse(response);
                myFuture.done();
            }
        }).start();

        return myFuture;
    }

    class MyFuture implements Future<String> {

        private Semaphore semaphore = new Semaphore(1);

        private String request;
        private String response;


        public MyFuture(String request) {
            // 在构造future的时候将信号量消耗到0
            semaphore.acquireUninterruptibly();
            this.request = request;
        }

        @Override
        public boolean cancel(boolean mayInterruptIfRunning) {
            return false;
        }

        @Override
        public boolean isCancelled() {
            return false;
        }

        @Override
        public boolean isDone() {
            return false;
        }

        @Override
        public String get() throws InterruptedException, ExecutionException {
            return response;
        }

        @Override
        public String get(long timeout, TimeUnit unit) throws InterruptedException, ExecutionException, TimeoutException {
            // 在timeout的时间内,阻塞获取
            boolean success = semaphore.tryAcquire(timeout, unit);
            if(success) {
                return response;
            } else {
                throw new TimeoutException("Timeout");
            }
        }

        /**
         * 请求结果已经返回,释放1个信号量,供阻塞的get(long timeout, TimeUnit unit)方法返回结果
         */
        public void done(){
            semaphore.release();
        }

        public void setResponse(String response) {
            this.response = response;

        }
    }
}
