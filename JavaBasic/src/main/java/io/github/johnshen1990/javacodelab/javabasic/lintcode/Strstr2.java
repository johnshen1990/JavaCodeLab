package io.github.johnshen1990.javacodelab.javabasic.lintcode;

/**
 * Author: zhun.shen
 * Date: 2017-01-14 20:00
 * Description:
 */
public class Strstr2 {
    public static void main(String[] args) {
        String source = "asdbd";
        String target = "bd";
        int r = strStr2(source, target);
        System.out.println(r);

    }

    /**
     * 逐位比较两个字符串的值,判断是否equal
     * 最坏时间复杂度O(m)
     * @param a
     * @param b
     * @return
     */
    private static boolean isEqual(String a, String b) {
        if(a == null || b == null) {
            return false;
        }
        if(a.length() != b.length()) {
            return false;
        }

        for(int i = 0; i < a.length(); i++) {
            if(a.charAt(i) != b.charAt(i)) {
                return false;
            }
        }
        return true;
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

        if(n < m) {
            return -1;
        }

        // 语义上 空串为任何串的子串 返0
        if(target.length() == 0) {
            return 0;
        }

//        int targetHashcode = 0;
//        for(int i = 0; i < m; i++) {
//            targetHashcode * 31
//        }

        return -1;
    }
}
