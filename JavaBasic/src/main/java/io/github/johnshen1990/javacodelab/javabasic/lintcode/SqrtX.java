package io.github.johnshen1990.javacodelab.javabasic.lintcode;


import sun.jvm.hotspot.utilities.Assert;

/**
 * Author: zhun.shen
 * Date: 2017-01-21 18:59
 * Description:
 */
public class SqrtX {

    public static int sqrt(int x) {
        // 这里使用long防止大数溢出
        long start = 1;
        long end = x;
        // 找到平方后不超过x的最大的那个数
        while (start + 1 < end) {
            long middle = (end - start) / 2 + start;
            if (middle * middle <= x) {
                start = middle;
            } else {
                end = middle;
            }
        }

        if (end * end <= x) {
            return (int) end;
        }
        return (int) start;
    }

    public static void main(String[] args) {

        Assert.that(sqrt(1) == 1, "");
        Assert.that(sqrt(3) == 1, "");
        Assert.that(sqrt(4) == 2, "");
        Assert.that(sqrt(5) == 2, "");
        Assert.that(sqrt(10) == 3, "");
        /*样例:
        sqrt(3) = 1
        sqrt(4) = 2
        sqrt(5) = 2
        sqrt(10) = 3
        */
    }
}
