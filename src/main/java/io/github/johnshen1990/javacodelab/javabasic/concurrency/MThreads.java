package io.github.johnshen1990.javacodelab.javabasic.concurrency;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class MThreads {
    private final int LIMIT = 500;
    private volatile int n = 0;

    private void runWithReentrantLock(final int numOfThread) {
        final ReentrantLock lock = new ReentrantLock(true);
        final Condition[] cons = new Condition[numOfThread];
        Thread[] threads = new Thread[numOfThread];

        // init conditions
        for(int i = 0; i < numOfThread; i++) {
            cons[i] = lock.newCondition();
        }

        // init threads
        for(int i = 0; i < numOfThread; i++) {
            final int finalI = i;
            threads[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    while (n < LIMIT) {
                        lock.lock();
                        try {
                            // precondition
                            while (n < LIMIT && n % numOfThread != finalI) {
                                cons[finalI].await();
                            }
                            // double check
                            if(n < LIMIT) {
                                System.out.println(Thread.currentThread().getName() + "-->" + ++n);
                            }
                            // 如果当前为最后一个线程，那么通知第一个线程
                            if(finalI == numOfThread - 1) {
                                cons[0].signalAll();
                            } else { // 如果非最后一个线程，那么通知自己的下一个线程
                                cons[finalI + 1].signalAll();
                            }
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        } finally {
                            lock.unlock();
                        }
                    }
                }
            }, "t" + i);
        }

        // start threads
        for(int i = 0; i < numOfThread; i++) {
            threads[i].start();
        }
    }

    public static void main(String[] args) throws Exception{
        MThreads instance = new MThreads();
        instance.runWithReentrantLock(10);
    }
}