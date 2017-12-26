package io.github.johnshen1990.javacodelab.javabasic.leetcode;

/**
 * Author: zhun.shen
 * Date: 2016-11-12 21:02
 * Description:
 */
public class ZigzagConversion {
    public static void main(String[] args) {
        convert("PAYPALISHIRING", 3);
    }
    public static String convert(String s, int numRows) {
        char[] sArr = new char[s.length()];
        s.getChars(0, s.length(), sArr, 0);
        char[][] canvas = new char[s.length()][numRows];
        for(int i=0;i<sArr.length;i++){

        }

        return null;
    }
}
