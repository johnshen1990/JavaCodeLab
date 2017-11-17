package io.github.johnshen1990.javacodelab.javabasic.lintcode.dfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PermutationsII {

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,2};
        System.out.println(new PermutationsII().permuteUnique(nums));
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if(nums == null || nums.length == 0) {
            result.add(new ArrayList<Integer>());
            return result;
        }

        helper(nums, new ArrayList<Integer>(), result);
        return result;
    }

    public void helper(int[] candidates, List<Integer> temp, List<List<Integer>> result) {
        if(candidates.length == temp.size()) {
            result.add(new ArrayList<>(temp));
            return;
        }

        Map<Integer, Integer> count = new HashMap<>();
        for(int i = 0; i < candidates.length; i++) {
            if(count.containsKey(candidates[i])) {
                count.put(candidates[i], count.get(candidates[i]) + 1);
            } else {
                count.put(candidates[i], 1);
            }
        }

        for(int i = 0; i < candidates.length; i++) {
            if(count.get(candidates[i]) == 0) {
                continue;
            }
            temp.add(candidates[i]);
            count.put(candidates[i], count.get(candidates[i]) - 1);
            helper(candidates, temp, result);
            temp.remove(temp.size() - 1);
        }

    }


}
