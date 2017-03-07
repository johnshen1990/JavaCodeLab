package io.github.johnshen1990.javacodelab.javabasic.lintcode;

/**
 * Author: zhun.shen
 * Date: 2017-02-14 14:11
 * Description:
 */
public class Fibonacci {
    /**
     * @param n: an integer
     * @return an integer f(n)
     * Time complex: O(n)
     */
    public int fibonacci1(int n) {
        if(n == 1) {
            return 0;
        }
        if(n == 2) {
            return 1;
        }
        return fibonacci1(n - 1) + fibonacci1(n - 2);
    }

    /**
     * n=1 return 0;
     * n=2 return 1;
     * n=3 return 1;
     * n=4 return 2;
     * n=5 return 3;
     * O( 1 + 1 + (n-4)*3 + 1) = O(n)
     * @param n
     * @return
     */
    public static int fibonacci2(int n) {
        int a = 0;
        int b = 1;
        for (int i = 0; i < n-1; i++) {
            int temp = a + b;
            a = b;
            b = temp;
        }

        return a;
    }


    public static void main(String[] args) {
    }
}
