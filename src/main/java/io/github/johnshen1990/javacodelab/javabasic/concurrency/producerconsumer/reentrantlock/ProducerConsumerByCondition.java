package io.github.johnshen1990.javacodelab.javabasic.concurrency.producerconsumer.reentrantlock;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ProducerConsumerByCondition {
    private final int MAX = 10;
    private final Queue<Object> queue = new LinkedList<>();
    private final ReentrantLock lock = new ReentrantLock();
    // 生产者等待的条件（队列非满）
    private final Condition notFull = lock.newCondition();
    // 消费者等待的条件（队列非空）
    private final Condition notEmpty = lock.newCondition();

    public void produce() throws InterruptedException {
        try {
            lock.lock();
            while (queue.size() >= MAX) {
                System.out.println(Thread.currentThread().getName() + " is waiting on produce.");
                notFull.await();
                System.out.println(Thread.currentThread().getName() + " is after waiting on produce.");
            }
            queue.offer(new Object());
            System.out.println(Thread.currentThread().getName() + "向队列中加入了1个对象，当前大小：" + queue.size());
            notEmpty.signalAll();
        } finally {
            lock.unlock();
        }
    }

    public void consume() throws InterruptedException {
        try {
            lock.lock();
            while (queue.isEmpty()) {
                System.out.println(Thread.currentThread().getName() + " is waiting on consume.");
                notEmpty.await();
                System.out.println(Thread.currentThread().getName() + " is after waiting on consume.");
            }
            queue.poll();
            System.out.println(Thread.currentThread().getName() + "从队列中取出了1个对象，当前大小：" + queue.size());
            notFull.signalAll();
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        ProducerConsumerByCondition producerConsumerByCondition = new ProducerConsumerByCondition();
        Producer p1 = new Producer(producerConsumerByCondition);
        Producer p2 = new Producer(producerConsumerByCondition);
        Producer p3 = new Producer(producerConsumerByCondition);
        Producer p4 = new Producer(producerConsumerByCondition);

        Consumer c1 = new Consumer(producerConsumerByCondition);
        Consumer c2 = new Consumer(producerConsumerByCondition);

        new Thread(p1, "p1").start();
        new Thread(p2, "p2").start();
        new Thread(p3, "p3").start();
        new Thread(p4, "p4").start();
        new Thread(c1, "c1").start();
        new Thread(c2, "c2").start();
    }

}

class Producer implements Runnable {
    private ProducerConsumerByCondition producerConsumerByCondition;
    public Producer(ProducerConsumerByCondition producerConsumerByCondition) {
        this.producerConsumerByCondition = producerConsumerByCondition;
    }
    @Override
    public void run() {
        for(int i = 0; i < 10; i++) {
            try {
                producerConsumerByCondition.produce();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Consumer implements Runnable {
    private ProducerConsumerByCondition producerConsumerByCondition;
    public Consumer(ProducerConsumerByCondition producerConsumerByCondition) {
        this.producerConsumerByCondition = producerConsumerByCondition;
    }
    @Override
    public void run() {
        for(int i = 0; i < 20; i++) {
            try {
                producerConsumerByCondition.consume();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
