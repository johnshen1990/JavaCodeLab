package io.github.johnshen1990.javacodelab.javabasic.chainofresponsibility;

/**
 * Author: zhun.shen
 * Date: 2017-07-07 11:12
 * Description:
 */
public class ManagerHandler extends Handler {
    public ManagerHandler(int maxDay) {
        super.maxDay = maxDay;
    }

    @Override
    public void doHandle(Request request) {
        System.out.println("经理审批通过！允许"
                + request.getApplicant()
                + "请假" + request.getApplyDay()
                + "天");
    }
}
