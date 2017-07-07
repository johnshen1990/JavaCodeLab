package io.github.johnshen1990.javacodelab.javabasic.chainofresponsibility;

/**
 * Author: zhun.shen
 * Date: 2017-07-07 11:12
 * Description:
 */
public class BossHandler extends Handler {
    public BossHandler(int maxDay) {
        super.maxDay = maxDay;
    }

    @Override
    public void doHandle(Request request) {
        if(request.getApplyDay() > 20) {
            System.out.println("Boss看了"
                    + request.getApplicant()
                    + "请假" + request.getApplyDay()
                    + "天的申请，心头一万头羊驼飞奔而过～" );
        } else {
            System.out.println("Boss审批通过！允许"
                    + request.getApplicant()
                    + "请假" + request.getApplyDay()
                    + "天");
        }
    }
}
