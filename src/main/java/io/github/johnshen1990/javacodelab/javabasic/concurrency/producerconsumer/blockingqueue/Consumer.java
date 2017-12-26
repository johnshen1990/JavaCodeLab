package io.github.johnshen1990.javacodelab.javabasic.concurrency.producerconsumer.blockingqueue;

import java.util.Random;
import java.util.concurrent.*;

public class Consumer implements Runnable {
    private BlockingQueue<MyTask> taskQueue;
    private CyclicBarrier cyclicBarrier;
    private CountDownLatch countDownLatch;

    Consumer(BlockingQueue<MyTask> taskQueue, CyclicBarrier cyclicBarrier, CountDownLatch countDownLatch) {
        this.taskQueue = taskQueue;
        this.cyclicBarrier = cyclicBarrier;
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        try {
            cyclicBarrier.await();
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }

        MyTask task = null;
        // 如果没有消费完，则循环
        while (countDownLatch.getCount() > 0) {
            try {
                // 从队列中拿出一个任务，如果等待3秒中队列依然为空，则不再继续等待
                task = taskQueue.poll(3000, TimeUnit.MILLISECONDS);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(task != null) {
                // 消费一个任务
                consume(task);
                // 任务数减1
                countDownLatch.countDown();
            }
        }
    }

    private void consume(MyTask task) {
        try {
            // 模拟耗时的消费过程
            Thread.sleep(new Random().nextInt(2000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("consume:" + task.getTaskName());
    }
}
