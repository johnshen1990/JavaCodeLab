package io.github.johnshen1990.javacodelab.javabasic.lintcode.dfs;

import java.util.ArrayList;
import java.util.List;

public class Test {
    /**
     *
     *
     * aab
     [
        ["aa","b"],
        ["a","a","b"]
     ]

     0:[aab]
     1:[a, ab], [aa, b]
     2:[a, a, b]

     abcd

     */

    public List<List<String>> partition(String s) {
        List<List<String>> results = new ArrayList<>();
        if(s == null || s.length() == 0) {
            return results;
        }




        List<String> subset = new ArrayList<>();

        return results;
    }


    public boolean isPalindrome(String str) {
        int n = str.length();
        int i = 0, j = n - 1;
        while(i < j) {
            if(str.charAt(i) != str.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Test().isPalindrome("a"));
        System.out.println(new Test().isPalindrome("abc"));
        System.out.println(new Test().isPalindrome("aba"));
    }
}
