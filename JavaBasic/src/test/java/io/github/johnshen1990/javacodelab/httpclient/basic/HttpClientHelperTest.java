package io.github.johnshen1990.javacodelab.httpclient.basic;

import org.junit.Test;

import java.io.IOException;
import java.net.URI;
import java.util.concurrent.CountDownLatch;

/**
 * Author: zhun.shen
 * Date: 2016-04-15 18:00
 * Description:
 */
public class HttpClientHelperTest {

    @Test
    public void testDoGet() throws InterruptedException {
        CountDownLatch startSignal = new CountDownLatch(1);
        CountDownLatch doneSignal = new CountDownLatch(5);

        // 依次创建并启动5个worker线程
        for (int i = 0; i < 5; ++i) {
            new Thread(new Visitor(startSignal, doneSignal)).start();
        }

        System.out.println("Driver is doing something...");
        System.out.println("Driver is Finished, start all workers ...");
        startSignal.countDown(); // Driver执行完毕，发出开始信号，使所有的worker线程开始执行
        doneSignal.await(); // 等待所有的worker线程执行结束
        System.out.println("Finished.");
    }
}
