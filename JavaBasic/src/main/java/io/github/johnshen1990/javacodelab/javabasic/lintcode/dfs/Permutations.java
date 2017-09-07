package io.github.johnshen1990.javacodelab.javabasic.lintcode.dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: zhun.shen
 * Date: 2017-08-17 15:18
 * Description:
 */
public class Permutations {
    private int depth = 0;

    public static void main(String[] args) {
        Permutations instance = new Permutations();
        int[] nums = new int[] {1, 2, 4};
        List<List<Integer>> result = instance.permute(nums);
        System.out.println(result.toString());
        System.out.println(instance.depth);
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if(nums == null || nums.length == 0) {
            result.add(new ArrayList<Integer>());
            return result;
        }

        List<Integer> list = new ArrayList<>();
        helper(result, list, nums);
        return result;
    }

    public List<List<Integer>> permute2(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if(nums == null || nums.length == 0) {
            result.add(new ArrayList<Integer>());
            return result;
        }

        List<Integer> list = new ArrayList<>();
        helper(result, list, nums);
        return result;
    }

    /**
     * 如果list的长度和nums一致，则可将其加入到result中；
     * 将nums中不在list中的元素加入到list中
     *
     * @param result 最后需要返回的结果集
     * @param list 需要加入到result中的一个排列, 需要加入其深拷贝的副本
     * @param nums
     */
    private void helper(List<List<Integer>> result, List<Integer> list, int[] nums) {
        depth++;
        if(list.size() == nums.length) {
            result.add(new ArrayList<>(list));
            return; // 出口
        }

        for (int num : nums) {
            if (list.contains(num)) { // 将list中已包含的元素过滤掉
                continue;
            }
            list.add(num); // 将list中未包含的元素加入到list
            helper(result, list, nums);  // 递归调用
            list.remove(list.size() - 1); // 回溯
        }

    }
}
