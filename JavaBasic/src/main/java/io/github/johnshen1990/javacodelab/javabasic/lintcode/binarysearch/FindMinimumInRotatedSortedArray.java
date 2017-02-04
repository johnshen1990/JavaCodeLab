package io.github.johnshen1990.javacodelab.javabasic.lintcode.binarysearch;

/**
 * Author: zhun.shen
 * Date: 2017-02-03 12:35
 * Description:
 * 假设一个旋转排序的数组其起始位置是未知的（比如0 1 2 4 5 6 7 可能变成是4 5 6 7 0 1 2）。
 * 你需要找到其中最小的元素。
 * 你可以假设数组中不存在重复的元素。
 *
 * 给出[4,5,6,7,0,1,2]  返回 0
 */
public class FindMinimumInRotatedSortedArray {
    /**
     * @param nums: a rotated sorted array
     * @return: the minimum number in the array
     */
    public int findMin(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int start = 0;
        int end = nums.length - 1;

        // 如果头小于尾,说明数组是完全升序排列的,头元素就是最小元素
        if (nums[start] < nums[end]) {
            return nums[start];
        }

        while (start + 1 < end) {
            int mid = (end - start) / 2 + start;
            if (nums[mid] > nums[start]) {
                start = mid;
            } else {
                end = mid;
            }
        }
        // 最终头尾指针会分别指向拐点的前后元素,并且拐点后的元素就是最小元素
        return nums[end];
    }
}
