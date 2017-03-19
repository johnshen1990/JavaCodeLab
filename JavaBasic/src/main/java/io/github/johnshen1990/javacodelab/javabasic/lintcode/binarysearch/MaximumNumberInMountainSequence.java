package io.github.johnshen1990.javacodelab.javabasic.lintcode.binarysearch;

/**
 * Author: zhun.shen
 * Date: 2017-03-19 22:06
 * Description:
 */
public class MaximumNumberInMountainSequence {

    public static void main(String[] args) {
        int[] demo1 = new int[]{1,2,4,8,6,3};
        System.out.println(new MaximumNumberInMountainSequence().mountainSequence(demo1));

        int[] demo2 = new int[]{10, 9,8,7};
        System.out.println(new MaximumNumberInMountainSequence().mountainSequence(demo2));
    }


    public int mountainSequence(int[] nums) {
        if(nums == null || nums.length == 0) {
            return -1;
        }
        if(nums.length == 1) {
            return nums[0];
        }
        int start = 0;
        int end = nums.length - 1;
        while (start + 1 < end) {
            int middle = start + (end - start) / 2;
            if(nums[middle] >= nums[middle-1] && nums[middle] >= nums[middle+1]) {
                end = middle;
            } else if(nums[middle] >= nums[middle-1] && nums[middle] < nums[middle+1]) {
                start = middle;
            } else {
                end = middle;
            }
        }
        if(nums[start] >= nums[end]) {
            return nums[start];
        }
        return nums[end];
    }

}
