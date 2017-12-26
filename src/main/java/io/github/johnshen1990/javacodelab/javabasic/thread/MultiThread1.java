package io.github.johnshen1990.javacodelab.javabasic.thread;

public class MultiThread1 extends Thread {
    @Override
    public void run() {
        System.out.printf("A thread is running!");
    }

    public static void main(String[] args) {
        Thread thread = new MultiThread1();
        thread.start();
    }
}
