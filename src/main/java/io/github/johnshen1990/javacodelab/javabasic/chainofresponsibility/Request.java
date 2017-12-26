package io.github.johnshen1990.javacodelab.javabasic.chainofresponsibility;

/**
 * Author: zhun.shen
 * Date: 2017-07-07 15:28
 * Description:
 */
public class Request {
    // 申请者的名字
    String applicant;
    // 申请者的请假天数
    int applyDay;

    public Request(String applicant, int applyDay) {
        this.applicant = applicant;
        this.applyDay = applyDay;
    }

    public String getApplicant() {
        return applicant;
    }

    public int getApplyDay() {
        return applyDay;
    }
}
