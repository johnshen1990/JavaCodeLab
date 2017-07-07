package io.github.johnshen1990.javacodelab.javabasic.lintcode.binarysearch.optional;

/**
 * Author: zhun.shen
 * Date: 2017-03-20 20:49
 * Description:
 */
public class KClosestNumbersInSortedArray {
    public static void main(String[] args) {
        int[] A = new int[]{1,2,3};
        System.out.println(new KClosestNumbersInSortedArray().kClosestNumbers(A, 2, 3));

    }


    public int[] kClosestNumbers(int[] A, int target, int k) {
        if(A == null || A.length == 0 || A.length <= k) {
            return A;
        }

        int firstCloestIndex = firstClosest(A, target);

        int start = firstCloestIndex;
        int end = firstCloestIndex;
        while (start >= 0 && end < A.length && (end - start + 1) <= k ) {
            if(start == 0 ) {
                end--;
                continue;
            }
            if(end == 0) {
                start--;
                continue;
            }
            if(Math.abs(A[start-1] - target) <= Math.abs(A[end+1] - target)) {
                start--;
            }else {
                end--;
            }
        }
        int[] result = new int[k];
        for(int i = start; i<=end; i++) {
            result[start-i] = A[i];
        }
        return result;
    }

    public int firstClosest(int[] A, int target) {
        if(A == null || A.length == 0) {
            return -1;
        }
        if(A.length == 1) {
            return A[0];
        }
        int start = 0;
        int end = A.length - 1;

        while (start + 1 < end) {
            int middle = start + (end - start) / 2;
            if(A[middle] > target) {
                end = middle;
            } else if(A[middle] < target) {
                start = middle;
            } else {
                end = middle;
            }
        }
        if(Math.abs(A[start] - target) <= Math.abs(A[end] - target)) {
            return start;
        }
        return end;
    }
}
