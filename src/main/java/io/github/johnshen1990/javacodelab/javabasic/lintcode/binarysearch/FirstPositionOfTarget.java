package io.github.johnshen1990.javacodelab.javabasic.lintcode.binarysearch;

/**
 * Author: zhun.shen
 * Date: 2017-02-03 11:10
 * Description:
 * 给定一个排序的整数数组（升序）和一个要查找的整数target，
 * 用O(logn)的时间查找到target第一次出现的下标（从0开始），
 * 如果target不存在于数组中，返回-1。
 * 在数组 [1, 2, 3, 3, 4, 5, 10] 中二分查找3，返回2。
 */
public class FirstPositionOfTarget {
    /**
     * @param nums: The integer array.
     * @param target: Target to find.
     * @return: The first position of target. Position starts from 0.
     */
    public int binarySearch(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        }
        if (nums.length == 1) {
            if (nums[0] == target) {
                return nums[0];
            } else {
                return -1;
            }
        }

        int start = 0;
        int end = nums.length - 1;
        while (start + 1 < end) {
            int mid = (end - start) / 2 + start;
            if (nums[mid] == target) {
                end = mid;
            } else if (nums[mid] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }

        if (nums[start] == target) {
            return start;
        } else if (nums[end] == target) {
            return end;
        }

        return -1;
    }


}
