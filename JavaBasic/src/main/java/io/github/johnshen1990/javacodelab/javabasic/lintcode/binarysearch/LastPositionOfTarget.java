package io.github.johnshen1990.javacodelab.javabasic.lintcode.binarysearch;
//import org.junit.Test;

import org.springframework.util.Assert;

/**
 * Author: zhun.shen
 * Date: 2017-01-21 18:15
 * Description:
 */
public class LastPositionOfTarget {

    /**
     * 给一个升序数组，找到target最后一次出现的位置，如果没出现过返回-1
     * @param nums 升序数组
     * @param target 要查找的元素
     * @return target最后一次出现的位置
     */
    public static int lastPosition(int[] nums, int target) {

        // 容错判断
        if (nums == null || nums.length == 0){
            return -1;
        }

        // 头指针指向第一个元素
        int start = 0;
        // 尾指针指向最后一个元素
        int end = nums.length - 1;

        // 循环移动头尾指针,直到头尾指针相邻或指向同一位置
        while (start + 1 < end) {
            int mid = (end - start) / 2 + start;
            if (nums[mid] == target) {
                start = mid;
            } else if (nums[mid] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }

        // 看尾指针的位置是否为要查找的元素
        if (nums[end] == target) {
            return end;
        }

        // 看头指针的位置是否为要查找的元素
        if (nums[start] == target) {
            return start;
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 2, 4, 5, 5};

        /**
         * 样例:
         * 给出 [1, 2, 2, 4, 5, 5].
         * target = 2, 返回 2.
         * target = 5, 返回 5.
         * target = 6, 返回 -1.
         */
        Assert.isTrue(lastPosition(nums, 2) == 2);
        Assert.isTrue(lastPosition(nums, 5) == 5);
        Assert.isTrue(lastPosition(nums, 6) == -1);
    }
}
