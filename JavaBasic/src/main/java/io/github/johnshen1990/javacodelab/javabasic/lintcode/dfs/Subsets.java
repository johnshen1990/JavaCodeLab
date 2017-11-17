package io.github.johnshen1990.javacodelab.javabasic.lintcode.dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        // 容错
        List<List<Integer>> result = new ArrayList<>();
        if(nums == null) {
            return result;
        }
        if(nums.length == 0) {
            result.add(new ArrayList<Integer>());
            return result;
        }
        // 排序原数组
        Arrays.sort(nums);
        // DFS
        helper(nums, 0, new ArrayList<Integer>(), result);

        return result;
    }

    // 递归的定义: 从nums数组的startIndex开始，找出所有以subset开头的集合，并加入到result中
    private void helper(int[] nums,
                        int startIndex,
                        ArrayList<Integer> subset,
                        List<List<Integer>> result) {
        // 递归的拆解: 深拷贝
        result.add(new ArrayList<>(subset));
        for(int i = startIndex; i < nums.length; i++) {
            // [1] --> [1, 2]
            subset.add(nums[i]);
            // 寻找所有以 [1,2] 开头的集合，并扔到 results(这个地方是i+1，而非startIndex+1)
            helper(nums, i + 1, subset, result);
            // [1, 2] --> [1] 回溯
            subset.remove(subset.size() - 1);
        }
        // 递归的出口: return
    }


    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3};
        List result = new Subsets().subsets(nums);
        System.out.println(result);
    }
}
