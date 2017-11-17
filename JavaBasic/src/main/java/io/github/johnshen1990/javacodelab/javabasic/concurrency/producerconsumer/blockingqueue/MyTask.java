package io.github.johnshen1990.javacodelab.javabasic.concurrency.producerconsumer.blockingqueue;

public class MyTask {
    private String taskName;

    public MyTask(String taskName) {
        this.taskName = taskName;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }
}
