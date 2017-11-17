package io.github.johnshen1990.javacodelab.javabasic.lintcode.dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        int[] candidates = new int[]{10,1,6,7,2,1,5};
        int target = 8;

        List<List<Integer>> result = new Solution().combinationSum2(candidates, target);
        System.out.println(result);
    }

    /**
     * @param num: Given the candidate numbers
     * @param target: Given the target number
     * @return: All the combinations that sum to target
     */
    public List<List<Integer>> combinationSum2(int[] candidates,
                                               int target) {
        List<List<Integer>> results = new ArrayList<>();
        if (candidates == null || candidates.length == 0) {
            return results;
        }

        Arrays.sort(candidates);
        List<Integer> combination = new ArrayList<Integer>();
        helper(candidates, 0, combination, target, results);

        return results;
    }

    /**
     * 在candidates中，从startIndex开始循环，
     * 如果元素小于target则加入conbination，target减去这个元素后 递归；
     * 如果元素等于target则加入combination，然后return combination
     * 如果元素大于target则退出循环
     * @param candidates
     * @param startIndex
     * @param combination
     * @param target
     * @param results
     */
    private void helper(int[] candidates,
                        int startIndex,
                        List<Integer> combination,
                        int target,
                        List<List<Integer>> results) {
        if (target == 0) {
            results.add(new ArrayList<Integer>(combination));
            return;
        }

        for (int i = startIndex; i < candidates.length; i++) {
            if (i != startIndex && candidates[i] == candidates[i - 1]) {
                continue;
            }
            if (target < candidates[i]) {
                break;
            }
            // add element of current index into the combination
            combination.add(candidates[i]);
            helper(candidates, i + 1, combination, target - candidates[i], results);
            // remove the last element in combination
            combination.remove(combination.size() - 1);
        }
    }
}
