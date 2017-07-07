package io.github.johnshen1990.javacodelab.javabasic.chainofresponsibility;

/**
 * Author: zhun.shen
 * Date: 2017-07-07 11:13
 * Description:
 */
public class DirectorHandler extends Handler {
    public DirectorHandler(int maxDay) {
        super.maxDay = maxDay;
    }

    @Override
    public void doHandle(Request request) {
        System.out.println("总监审批通过！允许"
                + request.getApplicant()
                + "请假" + request.getApplyDay()
                + "天");
    }
}
