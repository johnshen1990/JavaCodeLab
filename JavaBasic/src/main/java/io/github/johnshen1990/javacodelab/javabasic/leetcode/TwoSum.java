package io.github.johnshen1990.javacodelab.javabasic.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Author: zhun.shen
 * Date: 2016-11-12 18:29
 * Description:
 */
public class TwoSum {
    public static void main(String[] args) {
        int[] nums = new int[]{0,0,3,4};
        int target = 0;
        int[] result = twoSum2(nums, target);
        for(int i : result){
            System.out.print(i);
        }
    }

    public static int[] twoSum(int[] nums, int target) {
        for(int i=0; i<nums.length-1; i++){
            for(int j=i+1; j < nums.length; j++){
                if(nums[i]+nums[j]==target)
                    return new int[]{i,j};
            }
        }
        return null;
    }

    public static int[] twoSum2(int[] nums, int target){
        Map<Integer, Integer> stash = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            int need = target - nums[i];
            if(stash.containsKey(need)){
                return new int[]{stash.get(need), i};
            }
            stash.put(nums[i], i);
        }
        return null;
    }

}
