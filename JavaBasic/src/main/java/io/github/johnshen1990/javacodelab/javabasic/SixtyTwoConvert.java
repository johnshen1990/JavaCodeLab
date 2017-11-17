package io.github.johnshen1990.javacodelab.javabasic;

import java.util.Stack;

public class SixtyTwoConvert {
    private static String arrayStr = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public static String convert_10_64(int i) {

        int num = i;
        Stack<Character> stack = new Stack<>();
        while (num != 0) {
            stack.push(arrayStr.charAt(num % arrayStr.length()));
            num /= arrayStr.length();
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.empty()) {
            sb.append(stack.pop());
        }
        return sb.toString();
    }

    public static int convert_64_10(String str_64) {
        char[] chars = str_64.toCharArray();
        int result = 0;
        for(int i = 0; i < chars.length; i++) {
            result += arrayStr.indexOf(str_64.charAt(i)) * Math.pow(arrayStr.length(), chars.length - i - 1);
        }
        return result;
    }
    public static void main(String[] args) {
        System.out.println("100 -> " + convert_10_64(100));
        System.out.println("1C -> " + convert_64_10("1C"));
    }
}
