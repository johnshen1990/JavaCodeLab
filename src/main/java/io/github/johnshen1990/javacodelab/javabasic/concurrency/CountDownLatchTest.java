package io.github.johnshen1990.javacodelab.javabasic.concurrency;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

/**
 * Author: zhun.shen
 * Date: 2017-03-07 14:03
 * Description:
 */
public class CountDownLatchTest {
    public static void main(String[] args) throws InterruptedException {
        new CountDownLatchTest().go();
    }

    private void go() throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(3);
        // 依次创建3个线程,并启动
        new Thread(new Task(countDownLatch), "Thread1").start();
        Thread.sleep(1000);
        new Thread(new Task(countDownLatch), "Thread2").start();
        Thread.sleep(1000);
        new Thread(new Task(countDownLatch), "Thread3").start();
        countDownLatch.await();
        System.out.println("所有线程已到达,主线程开始执行" + System.currentTimeMillis());

    }

    class Task implements Runnable {
        private CountDownLatch countDownLatch;

        public Task(CountDownLatch countDownLatch) {
            this.countDownLatch = countDownLatch;
        }

        @Override
        public void run() {
            System.out.println("线程" + Thread.currentThread().getName() + "已经到达" + System.currentTimeMillis());
            countDownLatch.countDown();
        }
    }
}
