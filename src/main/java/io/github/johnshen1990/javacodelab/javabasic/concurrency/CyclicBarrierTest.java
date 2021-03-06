package io.github.johnshen1990.javacodelab.javabasic.concurrency;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * Author: zhun.shen
 * Date: 2017-03-07 14:03
 * Description:
 */
public class CyclicBarrierTest {
    public static void main(String[] args) throws InterruptedException {
        new CyclicBarrierTest().go();
    }

    private void go() throws InterruptedException {
        // 初始化栅栏的参与者数为3
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3);
        // 依次创建3个线程,并启动
        new Thread(new Task(cyclicBarrier), "Thread1").start();
        Thread.sleep(1000);
        new Thread(new Task(cyclicBarrier), "Thread2").start();
        Thread.sleep(1000);
        new Thread(new Task(cyclicBarrier), "Thread3").start();

    }

    class Task implements Runnable {
        private CyclicBarrier cyclicBarrier;

        public Task(CyclicBarrier cyclicBarrier) {
            this.cyclicBarrier = cyclicBarrier;
        }

        @Override
        public void run() {
            System.out.println("线程" + Thread.currentThread().getName() + "已经到达" + System.currentTimeMillis());
            try {
                cyclicBarrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
            System.out.println("线程" + Thread.currentThread().getName() + "开始处理" + System.currentTimeMillis());
        }
    }
}
