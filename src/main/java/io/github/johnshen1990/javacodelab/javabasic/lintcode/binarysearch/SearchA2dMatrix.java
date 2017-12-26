package io.github.johnshen1990.javacodelab.javabasic.lintcode.binarysearch;

/**
 * Author: zhun.shen
 * Date: 2017-03-19 21:26
 * Description:
 */
public class SearchA2dMatrix {

    public static void main(String[] args) {
        int[][] src = new int[][]{{1,3,5,7},{10, 11,16,20},{23, 30, 34, 50}};
        System.out.println(new SearchA2dMatrix().searchMatrix(src, 7));
    }

    /**
     * [
     *  [1, 3, 5, 7],
     *  [10, 11, 16, 20],
     *  [23, 30, 34, 50]
     * ]
     *
     * target =3, return true
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0) {
            return false;
        }

        if(matrix.length == 1) {
            return searchArray(matrix[0], target);
        }

        // [1, 10, 23]
        int[] tempArr = new int[matrix.length];
        for(int i = 0; i < matrix.length; i++) {
            tempArr[i] = matrix[i][0];
        }

        int start = 0;
        int end = tempArr.length - 1;
        while (start + 1 < end) {
            int middle = start + (end - start) / 2;
            if(tempArr[middle] > target) {
                end = middle;
            } else if(tempArr[middle] < target) {
                start = middle;
            } else {
                return true;
            }
        }
        if(tempArr[end] > target) {
            return searchArray(matrix[start], target);
        }
        return searchArray(matrix[end], target);
    }

    public boolean searchArray(int[] arr, int target) {
        if(arr == null || arr.length == 0) {
            return false;
        }
        if(arr.length == 1) {
            return arr[0] == target;
        }
        int start = 0;
        int end = arr.length - 1;
        while (start + 1 < end) {
            int middle = start + (end - start) / 2;
            if(arr[middle] > target) {
                end = middle;
            } else if(arr[middle] < target) {
                start = middle;
            } else {
                return true;
            }
        }

        return arr[start] == target || arr[end] == target;
    }


}
