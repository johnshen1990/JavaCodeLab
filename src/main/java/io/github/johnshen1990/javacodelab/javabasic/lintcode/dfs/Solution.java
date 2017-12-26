package io.github.johnshen1990.javacodelab.javabasic.lintcode.dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        int[] nums = new int[]{-3,1,2,-3,4};
        List<Integer> result = new Solution().subarraySum(nums);
        System.out.println(result);
    }

    public List<Integer> subarraySum(int[] nums) {
        List<Integer> result = new ArrayList<>();
        if(nums == null || nums.length == 0) {
            return result;
        }

        // calculate prefixSum array
        // prefixSum[n] 表示前n项和，即 nums[0] + nums [1] + ... + nums[n-1]
        // prefixSum[0] = 0;
        int[] prefixSum = new int[nums.length + 1];
        prefixSum[0] = 0;
        for(int i = 1; i < prefixSum.length; i++) {
            prefixSum[i] = prefixSum[i-1] + nums[i-1];
        }
        for(int i : prefixSum) {
            System.out.print(i + " ");
        }

        // Sum(i~j) = prefixSum[j+1] - prefixSum[i]
        int i = 0;
        int j = 0;
        for(i = 0; i < nums.length; i++) {
            for(j = i; j < nums.length; j++) {
                int a = prefixSum[j + 1];
                int b = prefixSum[i];
                if(prefixSum[j + 1] - prefixSum[i] == 0) {
                    result.add(i);
                    result.add(j);
                    return result;
                }
            }
        }
        
        return result;
    }
}
