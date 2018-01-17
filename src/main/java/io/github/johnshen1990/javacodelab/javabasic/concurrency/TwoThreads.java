package io.github.johnshen1990.javacodelab.javabasic.concurrency;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class TwoThreads {
    private final int LIMIT = 500;
    private volatile int n = 0;

    private void runWithReentrantLock() {
        final ReentrantLock lock = new ReentrantLock(true);
        final Condition t1CanRun = lock.newCondition();
        final Condition t2CanRun = lock.newCondition();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (n < LIMIT) {
                    lock.lock();
                    try {
                        while (n < LIMIT && n % 2 != 0) {
                            t1CanRun.await();
                        }
                        if(n < LIMIT) {
                            System.out.println(Thread.currentThread().getName() + "-->" + ++n);
                        }
                        t2CanRun.signalAll();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        lock.unlock();
                    }
                }
            }
        }, "t1");

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (n < LIMIT) {
                    lock.lock();
                    try {
                        while (n % 2 == 0) {
                            t2CanRun.await();
                        }
                        if(n < LIMIT) {
                            System.out.println(Thread.currentThread().getName() + "-->" + ++n);
                        }
                        t1CanRun.signalAll();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        lock.unlock();
                    }
                }
            }
        }, "t2");

        t1.start();
        t2.start();
    }

    public static void main(String[] args) throws Exception{
        TwoThreads instance = new TwoThreads();
        instance.runWithReentrantLock();
    }
}