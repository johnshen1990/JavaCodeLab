package io.github.johnshen1990.javacodelab.javabasic.quartz;


import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

/**
 * Author: zhun.shen
 * Date: 2016-03-08 15:48
 * Description:
 */
public class Demo {
    public static void main(String[] args) throws SchedulerException, InterruptedException {
        SchedulerFactory schedulerFactory = new StdSchedulerFactory();
        Scheduler scheduler = schedulerFactory.getScheduler();

        /**
         * 启动调度器线程，并且注销其上的所以触发器对象，
         * 如果需要保留其上的触发器，应该调用standby()方法
         */
        scheduler.start();

        /**
         * 使用JobBuilder构建一个任务。
         *
         * 这个任务通过“一个实现了Job接口的类”指定任务的执行实现类，
         * withIdentity(name, group)方法指定类任务的“名称”和“组名”，可以理解为key，用于标识这个任务；
         * build()方法执行构建，构建出的对象为JobDetail。
         */
        JobDetail job = JobBuilder.newJob(DemoJob.class)
                .withIdentity("myJob", "group1")
                .usingJobData("strData", "Tom")
                .usingJobData("intData", 15)
                .build();

        /**
         * 使用TriggerBuilder构建一个触发器。
         *
         * withIdentity(name, group)方法指定类触发器的“名称”和“组名”，用于标识这个触发器；
         * startNow()方法表示这个触发器在当前的时间就应该开始触发任务，然而这个时候触发器可能还没有作用在调度器上；
         * withSchedule(scheduleBuilder)方法指定这个触发器的调度规则，例子中的为“每2秒触发一次，永不停止”。
         */
        Trigger trigger = TriggerBuilder.newTrigger()
                .withIdentity("myTrigger", "group1")
                .startNow()
                .withSchedule(SimpleScheduleBuilder.simpleSchedule()
                        .withIntervalInSeconds(2)
                        .repeatForever())
                .build();

        /**
         * 调度器真正开始调度任务
         */
        scheduler.scheduleJob(job, trigger);
    }
}
