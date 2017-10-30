package io.github.johnshen1990.javacodelab.javabasic.lintcode.dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: zhun.shen
 * Date: 2017-08-17 15:18
 * Description:
 */
public class Permutations {

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,4};
        System.out.println(new Permutations().permute(nums));
    }

    /**
     * @param nums: A list of integers.
     * @return: A list of permutations.
     */
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if(nums == null || nums.length == 0) {
            result.add(new ArrayList<Integer>());
            return result;
        }
        helper(nums, new ArrayList<Integer>(), result);
        return result;
    }

    /**
     * 递归方法
     * @param candidates 待遍历的元素列表
     * @param temp 用于临时存储一种可能的状态
     * @param result 待返回的结果
     */
    public void helper(int[] candidates, List<Integer> temp, List<List<Integer>> result){
        // 递归的退出条件（当临时列表的大小达到candidate的大小）
        if(temp.size() == candidates.length) {
            // deep copy
            result.add(new ArrayList<>(temp));
            return;
        }
        for(int i = 0; i < candidates.length; i++) {
            // skip elements which have been in temp
            if(temp.contains(candidates[i])) {
                continue;
            }
            // add a candidate into temp
            temp.add(candidates[i]);
            // recursive call
            helper(candidates, temp, result);
            // 回溯（remove the last element）
            temp.remove(temp.size() - 1);
        }
    }
}
