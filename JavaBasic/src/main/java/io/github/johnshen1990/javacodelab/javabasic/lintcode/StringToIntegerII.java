package io.github.johnshen1990.javacodelab.javabasic.lintcode;

import java.util.HashMap;
import java.util.Map;

public class StringToIntegerII {
    public static void main(String[] args) {
        System.out.println(new StringToIntegerII().atoi("123123123123123"));
    }
    /**
     * 时间复杂度：O(n)，n为字符串的长度
     * 空间复杂度：O(1)
     */
    public int atoi(String str) {
        int value = 0;
        if(str == null || str.length() == 0) {
            return value;
        }

        // 初始化<数字字符 -> 数字>的映射
        Map<Character, Integer> map = new HashMap<>();
        map.put('0', 0);
        map.put('1', 1);
        map.put('2', 2);
        map.put('3', 3);
        map.put('4', 4);
        map.put('5', 5);
        map.put('6', 6);
        map.put('7', 7);
        map.put('8', 8);
        map.put('9', 9);

        // 是否为负数
        boolean isNegative = false;
        // flag表示是否处理过正负符号
        boolean flag = false;
        for(int i = 0; i < str.length(); i++) {
            Character c = str.charAt(i);
            // 跳过空白字符
            if(c == ' ') {
                continue;
            }
            // 处理正负字符
            if(c == '-') {
                if(flag) { // 处理过正负号，但依然出现负号。比如：--1
                    return value;
                }
                flag = true;
                isNegative = true;
                continue;
            }
            if(c == '+') {
                if(flag) { // 处理过正负号，但依然出现正号。比如：-+1
                    return value;
                }
                flag = true;
                isNegative = false;
                continue;
            }
            // 处理0-9字符
            if(map.containsKey(c)) {
                // 已经开始处理数字字符，表示正负号字符已经处理过
                flag = true;
                if(isNegative) {
                    // 处理越下界
                    if(Integer.MIN_VALUE + map.get(c) > value * 10) {
                        value = Integer.MIN_VALUE;
                        break;
                    }
                    value = value * 10 - map.get(c);
                } else {
                    // 处理越上界
                    if(Integer.MAX_VALUE - value * 10 < map.get(c)) {
                        value = Integer.MAX_VALUE;
                        break;
                    } else {
                        value = value * 10 + map.get(c);
                    }
                }
            } else { // 非0-9字符，中止
                break;
            }
        }
        return value;
    }
}
