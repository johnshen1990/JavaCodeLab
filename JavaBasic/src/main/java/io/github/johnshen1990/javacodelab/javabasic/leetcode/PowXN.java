package io.github.johnshen1990.javacodelab.javabasic.leetcode;

/**
 * Author: zhun.shen
 * Date: 2016-11-16 16:15
 * Description:
 */
public class PowXN {
    public static double myPow(double x, int n) {
        if(n == 0) return 1;
        if(n == 1) return x;
        if(n == -1) return 1/x;

        if(n>0){
            if(n % 2 == 0) {
                double t = myPow(x, n / 2);
                return t * t;
            }else{
                double t = myPow(x, (n-1)/2);
                return t * t * x;
            }
        }else{
            if(n % 2 == 0){
                double t = myPow(x, n / 2);
                return t * t;
            }else{
                double t = myPow(x, (n+1)/2);
                return t * t / x;
            }
        }

    }

    public static void main(String[] args) {
        System.out.println(myPow(2, -2));
    }


}
