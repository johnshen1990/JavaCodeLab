package io.github.johnshen1990.javacodelab.javabasic.utils;

import java.math.BigDecimal;

/**
 * Author: zhun.shen
 * Date: 2016-05-25 20:18
 * Description:
 */
public class DecimalTest {
    public static void main(String[] args) {
        //数字字符串
        String StrBd="1048576.1024";
//构造以字符串内容为值的BigDecimal类型的变量bd
        BigDecimal bd=new BigDecimal(StrBd);
//设置小数位数，第一个变量是小数位数，第二个变量是取舍方法(四舍五入)
        bd = bd.setScale(0, BigDecimal.ROUND_HALF_UP);
//转化为字符串输出
        String s = bd.toString();
        System.out.println(s);
    }
}
