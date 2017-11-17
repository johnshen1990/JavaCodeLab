package io.github.johnshen1990.javacodelab.javabasic.concurrency.producerconsumer.blockingqueue;

import java.util.Random;
import java.util.UUID;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Producer implements Runnable{

    private BlockingQueue<MyTask> taskQueue;
    private CyclicBarrier cyclicBarrier;

    Producer(BlockingQueue<MyTask> taskQueue, CyclicBarrier cyclicBarrier) {
        this.taskQueue = taskQueue;
        this.cyclicBarrier = cyclicBarrier;
    }

    @Override
    public void run() {
        try {
            // 等待其它线程就绪
            cyclicBarrier.await();
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }

        for(int i = 0; i < ProducerConsumer.numberOfTaskPerProducer; i++) {
            try {
                // 模拟耗时的生产过程
                Thread.sleep(new Random().nextInt(1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try { // 生产一个任务，加入到阻塞队列
                MyTask task = new MyTask(UUID.randomUUID().toString());
                System.out.println("produce:" + task.getTaskName());
                taskQueue.put(task); // 如果队列已满，无限期等待
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
