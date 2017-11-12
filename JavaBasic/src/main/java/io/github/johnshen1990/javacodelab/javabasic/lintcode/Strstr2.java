package io.github.johnshen1990.javacodelab.javabasic.lintcode;

/**
 * Author: zhun.shen
 * Date: 2017-01-14 20:00
 * Description:
 */
public class Strstr2 {
    public static void main(String[] args) {
        String source = "abcde";
        String target = "abc";
        int r = strStr2(source, target);
        System.out.println(r);

    }

    /**
     * 使用Rabin-Karp算法
     * @param source
     * @param target
     * @return
     */
    public static int strStr2(String source, String target) {
        // 容错
        if(source == null || target == null) {
            return -1;
        }
        int n = source.length();
        int m = target.length();

        if(m == 0) {
            return 0;
        }

        if(n < m) {
            return -1;
        }


        // BASE = 10^6
        int BASE = 1000000;

        // pow = 31^m
        int pow = 1;
        for(int i = 0; i < m; i++) {
            pow = pow * 31 % BASE;
        }

        // targetCode = hash(target)
        int targetCode = 0;
        for(int i = 0; i < m; i++) {
            targetCode = (targetCode * 31 + target.charAt(i)) % BASE;
        }

        // source = abcde
        // target = cde

        // hash(abc)
        int hashCode = 0;
        for(int i = 0; i < m; i++) {
            hashCode = (hashCode * 31 + source.charAt(i)) % BASE;
        }

        for(int i = 0; i <= n - m; i++) {
            if(hashCode == targetCode) {
                String subStr = source.substring(i, i + m);
                if(subStr.equals(target)) {
                    return i;
                }
            }

            if(i < n - m) {
                // hash(abc) --> hash(abcd)
                hashCode = (hashCode * 31 + source.charAt(i + m)) % BASE;

                // hash(abcd) --> hash(bcd)
                hashCode = hashCode - source.charAt(i) * pow % BASE;

                if(hashCode < 0) {
                    hashCode += BASE;
                }
            }

        }

        return -1;
    }
}
