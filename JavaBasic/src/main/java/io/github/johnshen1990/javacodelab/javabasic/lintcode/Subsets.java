package io.github.johnshen1990.javacodelab.javabasic.lintcode;

import com.sun.xml.internal.xsom.impl.scd.Iterators;

import java.util.ArrayList;

/**
 * Author: zhun.shen
 * Date: 2017-01-16 21:34
 * Description:
 */
public class Subsets {
    public static void main(String[] args) {
        int[] nums = {2, 1, 3};


    }

    public ArrayList<ArrayList<Integer>> subsets(int[] nums) {
        ArrayList<ArrayList<Integer>> results = new ArrayList<>();
        if(nums.length == 0) {
            return results;
        }

        for(int i = 0; i < nums.length; i++){}
        return null;
    }

    /**
     * 递归返回以list开头的所有集合
     * @return
     */
    private ArrayList<ArrayList<Integer>> dfs(ArrayList<ArrayList<Integer>> results,
                                              int[] nums,
                                              int pointer,
                                              ArrayList<Integer> list) {

        results.add(new ArrayList<>(list));

        list.add(nums[pointer]);
        dfs(results, nums, pointer + 1, list);
        list.remove(list.size() - 1);

        return  results;

    }

}
