package io.github.johnshen1990.javacodelab.httpclient.basic;

import java.io.IOException;
import java.net.URI;
import java.util.concurrent.CountDownLatch;

/**
 * Author: zhun.shen
 * Date: 2016-04-18 10:58
 * Description:
 */
public class Visitor implements Runnable {
    private final CountDownLatch startSignal;
    private final CountDownLatch doneSignal;
    Visitor(CountDownLatch startSignal, CountDownLatch doneSignal) {
        this.startSignal = startSignal;
        this.doneSignal = doneSignal;
    }

    @Override
    public void run(){

        try {
            startSignal.await(); // 等待Driver线程执行完毕，获得开始信号
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            System.out.println(HttpClientHelper.doGetStatusCode(URI.create("http://www.baidu.com/")));
        } catch (IOException e) {
            e.printStackTrace();
        }

//        System.out.println("wwwww");
//        try {
//            Thread.currentThread().sleep(3000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        doneSignal.countDown(); // 当前worker执行完毕，释放一个完成信号

    }
}
