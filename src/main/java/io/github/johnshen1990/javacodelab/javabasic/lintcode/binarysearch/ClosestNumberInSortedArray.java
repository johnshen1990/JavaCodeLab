package io.github.johnshen1990.javacodelab.javabasic.lintcode.binarysearch;

import java.util.Arrays;

/**
 * Author: zhun.shen
 * Date: 2017-03-19 21:03
 * Description:
 */
public class ClosestNumberInSortedArray {

    public static void main(String[] args) {
        int[] A = new int[]{1, 2, 3};

        System.out.println(closestNumber(A, 2));
    }

    public static int closestNumber(int[] A, int target) {
        if(A == null || A.length == 0) {
            return -1;
        }
        if(A.length == 1) {
            return 0;
        }

        int start = 0;
        int end = A.length - 1;

        while (start + 1 < end) {
            int middle = start + (end - start) / 2;
            if(A[middle] < target) {
                start = middle;
            } else if(A[middle] > target) {
                end = middle;
            } else {
                return middle;
            }
        }

        if(Math.abs(A[start]-target) <= Math.abs(A[end]-target)) {
            return start;
        }
        return end;
    }

}
