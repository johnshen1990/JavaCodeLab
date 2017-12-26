package io.github.johnshen1990.javacodelab.javabasic.lintcode.dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: zhun.shen
 * Date: 2017-08-17 15:18
 * Description:
 */
public class Permutations {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();

        if(nums == null || nums.length == 0) {
            results.add(new ArrayList<Integer>());
            return results;
        }

        List<Integer> list = new ArrayList<>();
        helper(nums, list, results);
        return results;
    }

    // 找出nums[]中的startIndex开始的全排列，加入到results中
    private void helper(int[] nums, List<Integer> list, List<List<Integer>> results) {
        // nums[]和list等长时表示凑够了一种排列
        if(list.size() == nums.length) {
            results.add(new ArrayList<>(list));
            return;
        }

        // 每次都遍历整个nums[]
        for(int i = 0; i < nums.length; i++) {
            // 已经在list中的元素要跳过
            if(list.contains(nums[i])) {
                continue;
            }
            list.add(nums[i]);
            helper(nums, list, results);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Permutations().permute(new int[]{0, 1}));
    }
}
