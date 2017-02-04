package io.github.johnshen1990.javacodelab.javabasic.lintcode.binarytreeDC;

import io.github.johnshen1990.javacodelab.javabasic.lintcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: zhun.shen
 * Date: 2017-02-04 18:01
 * Description:
 * 给定一个二叉树，找出所有路径中各节点相加总和等于给定 目标值 的路径。
 * 一个有效的路径，指的是从根节点到叶节点的路径。
 *
 * 样例
 * 给定一个二叉树，和 目标值 = 5:
 *     1
 *    / \
 *   2   4
 *  / \
 * 2   3
 * 返回：
 * [
 *   [1, 2, 2],
 *   [1, 4]
 * ]
 */
public class BinaryTreePathSum {
    /**
     * @param root the root of binary tree
     * @param target an integer
     * @return all valid paths
     */
    public List<List<Integer>> binaryTreePathSum(TreeNode root, int target) {
        List<List<Integer>> result = new ArrayList<>();

        // 遍历全部集合,找出需要的元素
        for (List<Integer> path : getAllPath(root)) {
            int sum = 0;
            for (Integer i : path) {
                sum += i;
            }
            if (sum == target) {
                result.add(path);
            }
        }
        return result;
    }

    /**
     * 获取所有从根到叶子的路径集合
     * @param root
     * @return
     */
    private List<List<Integer>> getAllPath(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        // 特派处理叶子节点
        if (root.left == null && root.right == null) {
            List<Integer> temp = new ArrayList<>();
            temp.add(root.val);
            result.add(temp);
            return result;
        }
        result.addAll(addSubtreePath(getAllPath(root.left), root));
        result.addAll(addSubtreePath(getAllPath(root.right), root));

        return result;
    }

    /**
     * 将根节点和其子树的路径拼接,得到该树路径的集合
     * @param subtreePathList
     * @param root
     * @return
     */
    private List<List<Integer>> addSubtreePath(List<List<Integer>> subtreePathList, TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        for (List<Integer> subtreePath : subtreePathList) {
            List<Integer> path = new ArrayList<>();
            path.add(root.val);
            path.addAll(subtreePath);
            result.add(path);
        }
        return result;
    }
}
