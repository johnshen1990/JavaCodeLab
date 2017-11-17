package io.github.johnshen1990.javacodelab.javabasic.test;

import java.util.HashSet;
import java.util.Set;

/**
 * Author: zhun.shen
 * Date: 2016-12-12 06:32
 * Description:
 */
public class TestBoolean {
    public static void main(String[] args) {
//        String src = "abcabd";
//        Set<String> dict = new HashSet<>();
//        dict.add("ab");
//        dict.add("abcd");

//        System.out.println(new TestBoolean().minLength(src, dict));
        double a = 1.1;
        System.out.println(a / 1);
        System.out.println(a % 1);
    }

    public int minLength(String s, Set<String> dict) {

        if (s == null || dict == null) {
            return 0;
        }

        boolean valid = valid(s, dict);
        while(valid){
            for (String substring : dict) {
                s = s.replaceAll(substring, "");
            }
            valid = valid(s, dict);
        }
        return s.length();
    }

    public boolean valid(String s, Set<String> dict) {
        for (String substring : dict) {
            if(s.contains(substring)) {
                return true;
            }
        }
        return false;
    }
}
