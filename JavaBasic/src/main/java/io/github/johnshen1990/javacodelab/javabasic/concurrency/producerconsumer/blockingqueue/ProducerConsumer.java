package io.github.johnshen1990.javacodelab.javabasic.concurrency.producerconsumer.blockingqueue;

import java.util.concurrent.*;

public class ProducerConsumer {

    private static BlockingQueue<MyTask> taskQueue = new ArrayBlockingQueue<>(3, false);
    private static final int totalProducer = 4;
    private static final int totalConsumer = 4;
    public static final int totalThread = totalProducer + totalConsumer;
    public static final int numberOfTaskPerProducer = 2;
    private static final int numberOfTask = totalProducer * numberOfTaskPerProducer;

    public static void main(String[] args) {
        // 用于记录所有的线程数，每个生产者或者消费者对应一个线程
        CyclicBarrier cyclicBarrier = new CyclicBarrier(totalThread);
        // 用于表示一共创建的task数目，以便于生产消费完成后关闭线程池
        CountDownLatch countDownLatch = new CountDownLatch(numberOfTask);

        // 创建4个生产者
        Producer p1 = new Producer(taskQueue, cyclicBarrier);
        Producer p2 = new Producer(taskQueue, cyclicBarrier);
        Producer p3 = new Producer(taskQueue, cyclicBarrier);
        Producer p4 = new Producer(taskQueue, cyclicBarrier);
        // 创建4个消费者
        Consumer c1 = new Consumer(taskQueue, cyclicBarrier, countDownLatch);
        Consumer c2 = new Consumer(taskQueue, cyclicBarrier, countDownLatch);
        Consumer c3 = new Consumer(taskQueue, cyclicBarrier, countDownLatch);
        Consumer c4 = new Consumer(taskQueue, cyclicBarrier, countDownLatch);

        // 创建一个容量为8的线程池，并向池中提交任务
        ExecutorService executorService = Executors.newFixedThreadPool(totalThread);
        executorService.submit(p1);
        executorService.submit(p2);
        executorService.submit(p3);
        executorService.submit(p4);
        executorService.submit(c1);
        executorService.submit(c2);
        executorService.submit(c3);
        executorService.submit(c4);

        // 待池中线程全部空闲后，销毁线程池资源
        executorService.shutdown();
    }
}
