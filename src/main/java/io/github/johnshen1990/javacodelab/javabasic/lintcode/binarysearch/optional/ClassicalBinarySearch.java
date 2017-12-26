package io.github.johnshen1990.javacodelab.javabasic.lintcode.binarysearch.optional;

/**
 * Author: zhun.shen
 * Date: 2017-03-19 22:44
 * Description:
 */
public class ClassicalBinarySearch {

    public static void main(String[] args) {

    }

    public int findPosition(int[] nums, int target) {
        if(nums == null || nums.length == 0) {
            return -1;
        }
        if(nums.length == 1 && nums[0] == target){
            return 0;
        }
        int start = 0;
        int end = nums.length - 1;
        while (start + 1 < end) {
            int middle = start + (end - start) / 2;
            if(nums[middle] > target) {
                end = middle;
            } else if(nums[middle] < target){
                start = middle;
            } else {
                return middle;
            }
        }
        if(nums[start] == target) {
            return start;
        }
        if(nums[end] == target) {
            return end;
        }
        return -1;
    }
}
