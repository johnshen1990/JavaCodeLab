package io.github.johnshen1990.javacodelab.javabasic.lintcode;

/**
 * Author: zhun.shen
 * Date: 2017-01-14 20:00
 * Description:
 */
public class Strstr {
    public static void main(String[] args) {
        String source = "abd";
        String target = "bd";
        int r = strStr(source, target);
        System.out.println(r);

    }

    public static int strStr(String source, String target) {
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
}
