package io.github.johnshen1990.javacodelab.javabasic.thread;

public class MultiThread2 implements Runnable {
    @Override
    public void run() {
        System.out.printf("A thread is running!");
    }

    public static void main(String[] args) {
        Thread thread = new Thread(new MultiThread2());
        thread.start();
    }
}
