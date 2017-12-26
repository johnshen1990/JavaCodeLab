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
     * @param source "abcde"
     * @param target "cde"
     * @return 2
     */
    public static int strStr2(String source, String target) {
        // 容错
        if(source == null || target == null) {
            return -1;
        }
        int n = source.length();
        int m = target.length();
        // target = ""
        if(m == 0) {
            return 0;
        }
        // source = "abc", target = "abcde"
        if(n < m) {
            return -1;
        }
        // HASH_SIZE = 10^6
        int HASH_SIZE = 1000000;
        // pow = 31^m
        int pow = 1;
        for(int i = 0; i < m; i++) { // O(m)
            pow = pow * 31 % HASH_SIZE;
        }
        // targetCode = hash(target)
        int targetCode = 0;
        for(int i = 0; i < m; i++) { // O(m)
            targetCode = (targetCode * 31 + target.charAt(i)) % HASH_SIZE;
        }
        // hash(abc)
        int hashCode = 0;
        for(int i = 0; i < m; i++) { // O(m)
            hashCode = (hashCode * 31 + source.charAt(i)) % HASH_SIZE;
        }
        for(int i = 0; i <= n - m; i++) { // O(n-m+1)
            if(hashCode == targetCode) {
                String subStr = source.substring(i, i + m);
                int j;
                for(j = 0; j < m; j++) { // O(m)
                    if(subStr.charAt(j) != target.charAt(j)) {
                        break;
                    }
                }
                if(j >= m) {
                    return i;
                }
            }
            if(i == n - m) {
                continue;
            }
            // hash(abc) --> hash(abcd)
            hashCode = (hashCode * 31 + source.charAt(i + m)) % HASH_SIZE;
            // hash(abcd) --> hash(bcd)
            hashCode = hashCode - source.charAt(i) * pow % HASH_SIZE;
            if(hashCode < 0) {
                hashCode += HASH_SIZE;
            }
        }
        return -1;
    }
}
