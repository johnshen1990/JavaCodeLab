package io.github.johnshen1990.javacodelab.javabasic.lintcode.dfs;

public class PalindromePartitioning {
    public static void main(String[] args) {
        PalindromePartitioning p = new PalindromePartitioning();
        System.out.println(p.isPalindrome("a"));
        System.out.println(p.isPalindrome("abc"));
        System.out.println(p.isPalindrome("aba"));
        System.out.println(p.isPalindrome("abba"));
        System.out.println(p.isPalindrome("acacb"));
        System.out.println(p.isPalindrome("acaca"));
    }
    boolean isPalindrome(String s) {
        char[] array = s.toCharArray();
        for(int i = 0, j = array.length - 1; i + 1 <= j - 1; i++, j--) {
            if(array[i] != array[j]) {
                return false;
            }
        }
        return true;
    }
}
