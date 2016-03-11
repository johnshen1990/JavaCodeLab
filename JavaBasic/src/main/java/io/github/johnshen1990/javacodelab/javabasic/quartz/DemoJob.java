package io.github.johnshen1990.javacodelab.javabasic.quartz;

import org.quartz.*;

/**
 * Author: zhun.shen
 * Date: 2016-03-08 15:52
 * Description:
 */
public class DemoJob implements Job {
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
//        System.out.println("I will sleep in 3 seconds.");
//        try {
//            Thread.currentThread().sleep(3000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        System.out.println("HA HA HA, I am running!!!");

        JobKey key = jobExecutionContext.getJobDetail().getKey();
        JobDataMap dataMap = jobExecutionContext.getJobDetail().getJobDataMap();
        String strData = dataMap.getString("strData");
        int intData = dataMap.getInt("intData");
        System.out.println("key : " + key);
        System.out.println("strData : " + strData);
        System.out.println("intData : " + intData);








    }
}
