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
        int r = strStr3(source, target);
        System.out.println(r);

    }

    /**
     * 调用了Java String的库方法(equals,substring),略有作弊嫌疑
     * @param source
     * @param target
     * @return
     */
    public static int strStr1(String source, String target) {
        int m = source.length();
        int n = target.length();
        if(m == 0 || n == 0) return -1;
        if(m < n) return -1;
        if(m == n) return source.equals(target)? 0 : -1;
        for(int i=0; m-i >= n; i++){
            String tmp = source.substring(i, i+n);
            if(tmp.equals(target)) return i;
        }
        return -1;
    }

    /**
     * 简单粗暴版
     * source.length = M
     * targe.length = N
     * 最坏时间复杂度O((N-1)*(M-N))?
     * @param source
     * @param target
     * @return
     */
    public static int strStr2(String source, String target) {
        // 容错
        if(source == null || target == null
                || source.length() < target.length()) {
            return -1;
        }
        // 语义上 空串包含空串 返0
        if(source.length() == 0 && target.length() == 0) {
            return 0;
        }

        // start指向source的开始比较的下标
        int start = 0;
        while (source.length() - start >= target.length()) {
            int j = start;
            for(int i = 0; i < target.length(); i++,j++) {
                if(target.charAt(i) != source.charAt(j)) {
                    break;
                }
            }
            if(j < start + target.length()) {
                start++;
                continue;
            }
            return start;
        }

        return -1;
    }

    /**
     * 使用Rabin-Karp算法
     * @param source
     * @param target
     * @return
     */
    public static int strStr3(String source, String target) {
        // 容错
        if(source == null || target == null
                || source.length() < target.length()) {
            return -1;
        }
        // 语义上 空串包含空串 返0
        if(source.length() == 0 && target.length() == 0) {
            return 0;
        }

        // start指向source的开始比较的下标
        int start = 0;
        int targetHash = target.hashCode();
        while (source.length() - start >= target.length()) {
            String tmp = source.substring(start, start + target.length());
            if(targetHash == tmp.hashCode()) {
                int j = start;
                for(int i = 0; i < target.length(); i++,j++) {
                    if(target.charAt(i) != source.charAt(j)) {
                        break;
                    }
                }
                if(j < start + target.length()) {
                    start++;
                    continue;
                }
                return start;
            }
        }

        return -1;
    }
}
