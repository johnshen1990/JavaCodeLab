package io.github.johnshen1990.javacodelab.javabasic.lintcode;

/**
 * Author: zhun.shen
 * Date: 2017-01-14 20:00
 * Description:
 */
public class Strstr {
    public static void main(String[] args) {
        String source = "asdbd";
        String target = "bd";
        int r = strStr(source, target);
        System.out.println(r);

    }

    /**
     * 朴素匹配法
     */
    public static int strStr(String source, String target) {
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
        for(int i = 0; i <= n - m; i++) {
            String subStr = source.substring(i, i + m);
            if(subStr.hashCode() == target.hashCode()) {
                int j;
                for(j = 0; j < m; j++) {
                    if(subStr.charAt(j) != target.charAt(j)) {
                        break;
                    }
                }
                if(j >= m) {
                    return i;
                }
            }
        }
        return -1;
    }


}
