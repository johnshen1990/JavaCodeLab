package io.github.johnshen1990.javacodelab.javabasic.forkjoin;

import org.apache.commons.lang3.time.StopWatch;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveTask;

/**
 * Author: zhun.shen
 * Date: 2017-02-10 12:44
 * Description:
 */
public class CountTask extends RecursiveTask<Integer> {
    int start = 0;
    int end = 0;
    // fork的阈值,即start,end相差大于2的时候,进行fork操作
    int threshold = 2;

    public CountTask(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public static int sum(int start, int end) {
        int sum = 0;
        for (int i = start; i <= end; i++) {
            sum += i;

            // 让当前线程睡5秒,模拟某个耗时操作
//            try {
//                Thread.sleep(5000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
        }
        return sum;
    }

    @Override
    protected Integer compute() {
        if (end - start <= threshold) {
            return sum(start, end);
        } else {
            int middle = (end + start) / 2;
            CountTask left = new CountTask(start, middle);
            CountTask right = new CountTask(middle + 1, end);
            left.fork();
            right.fork();

            int leftResult = left.join();
            int rightResult = right.join();
            return leftResult + rightResult;
        }
    }

    public static void main(String[] args) throws Exception {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        ForkJoinPool forkJoinPool = new ForkJoinPool();
        Future<Integer> task = forkJoinPool.submit(new CountTask(1, 6));
        System.out.println("ForkJoin执行结果:" + task.get());

        stopWatch.stop();
        System.out.println("ForkJoin执行耗时:" + stopWatch.getTime() + "ms");

        stopWatch.reset();
        stopWatch.start();

        System.out.println("单线程顺序执行结果:" + sum(1, 6));

        stopWatch.stop();
        System.out.println("单线程顺序执行耗时:" + stopWatch.getTime() + "ms");
    }
}
