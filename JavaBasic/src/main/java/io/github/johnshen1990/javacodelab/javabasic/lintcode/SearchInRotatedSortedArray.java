package io.github.johnshen1990.javacodelab.javabasic.lintcode;

/**
 * Author: zhun.shen
 * Date: 2017-02-03 15:07
 * Description:
 * 假设有一个排序的按未知的旋转轴旋转的数组(比如，0 1 2 4 5 6 7 可能成为4 5 6 7 0 1 2)。
 * 给定一个目标值进行搜索，如果在数组中找到目标值返回数组中的索引位置，否则返回-1。
 * 你可以假设数组中不存在重复的元素。
 *
 * 样例
 * 给出[4, 5, 1, 2, 3]和target=1，返回 2
 * 给出[4, 5, 1, 2, 3]和target=0，返回 -1
 */
public class SearchInRotatedSortedArray {
    /**
     *@param A : an integer rotated sorted array
     *@param target :  an integer to be searched
     *return : an integer
     */
    public int search(int[] A, int target) {

        if (A == null || A.length == 0) {
            return -1;
        }

        if (A.length == 1) {
            if (A[0] == target) return 0;
        }

        int start = 0;
        int end = A.length - 1;

        /**
         * 未旋转的情况
         */
        if (A[0] < A[A.length - 1]) {
            return binarySearch(A, start, end, target);
        }

        int point = -1;
        while (start + 1 < end) {
            int mid = (end - start) / 2 + start;
            if (A[mid] > A[mid + 1]) {
                point = mid + 1;
                break;
            } else {
                if (A[mid] > A[0]) {
                    start = mid;
                } else {
                    end = mid;
                }
            }
        }
        if (point != -1) {
            if (target == A[0]) {
                return 0;
            }
            if (target > A[0]) {
                return binarySearch(A, 0, point - 1, target);
            }
            if (target < A[0]) {
                return binarySearch(A, point, A.length - 1, target);
            }
        }
        return -1;
    }

    private int binarySearch(int[] nums, int from, int to, int target) {
        int start = from;
        int end = to;
        while (start + 1 < end) {
            int mid = (end - start) / 2 + start;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (nums[start] == target) {
            return start;
        }
        if (nums[end] == target) {
            return end;
        }
        return -1;
    }
}
