package io.github.johnshen1990.javacodelab.javabasic.lintcode;

/**
 * Author: zhun.shen
 * Date: 2017-02-03 14:16
 * Description:
 * 你给出一个整数数组(size为n)，其具有以下特点：
 * 相邻位置的数字是不同的
 * A[0] < A[1] 并且 A[n - 2] > A[n - 1]
 * 假定P是峰值的位置则满足A[P] > A[P-1]且A[P] > A[P+1]，返回数组中任意一个峰值的位置。
 * <p/>
 * 注意事项
 * 数组可能包含多个峰值，只需找到其中的任何一个即可
 * <p/>
 * 样例
 * 给出数组[1, 2, 1, 3, 4, 5, 7, 6]返回1, 即数值 2 所在位置, 或者6, 即数值 7 所在位置.
 */
public class FindPeakElement {

    /**
     * @param A: An integers array.
     * @return: return any of peek positions.
     */
    public int findPeak(int[] A) {
        if (A == null || A.length < 3) {
            return -1;
        }

        int start = 0;
        int end = A.length - 1;

        /**
         * 一共对应4种情况:
         * 1. 极高点
         * 2. 上升
         * 3. 下降
         * 4. 极低点
         */
        while (start + 1 < end) {
            int mid = (end - start) / 2 + start;
            if (A[mid] > A[mid - 1] && A[mid] > A[mid + 1]) {
                return mid;
            } else if (A[mid] > A[mid - 1] && A[mid] < A[mid + 1]) {
                start = mid;
            } else if (A[mid] < A[mid - 1] && A[mid] > A[mid + 1]) {
                end = mid;
            } else {
                start = mid;
            }
        }
        return -1;
    }


}
