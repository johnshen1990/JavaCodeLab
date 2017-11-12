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
     * @param source
     * @param target
     * @return
     */
    public static int strStr(String source, String target) {
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

        for(int i = 0; i <= n - m; i++) {
            int j;
            for(j = 0; j < m; j++) {
                if(source.charAt(i + j) != target.charAt(j)) {
                    break;
                }
            }
            if(j >= m) {
                return i;
            }
        }

        return -1;
    }


}
