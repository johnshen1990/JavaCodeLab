package io.github.johnshen1990.javacodelab.javabasic.lintcode.dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsII {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        if(nums == null || nums.length == 0) {
            return results;
        }
        Arrays.sort(nums);
        List<Integer> subset = new ArrayList<>();
        helper(nums, 0, subset, results);
        return results;
    }

    private void helper(int[] nums,
                        int startIndex,
                        List<Integer> subset,
                        List<List<Integer>> results) {
        results.add(new ArrayList<>(subset));
        for(int i = startIndex; i < nums.length; i++) {
            if(i != startIndex && nums[i - 1] == nums[i]) {
                continue;
            }
            subset.add(nums[i]);
            helper(nums, i + 1, subset, results);
            subset.remove(subset.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 2};
        List result = new SubsetsII().subsetsWithDup(nums);
        System.out.println(result);
    }
}
