package io.github.johnshen1990.javacodelab.javabasic.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Author: zhun.shen
 * Date: 2016-11-22 14:55
 * Description:
 */
public class ThreadPool {
    ExecutorService pool =  Executors.newFixedThreadPool(100);
    public static void main(String[] args) {
    }

}
