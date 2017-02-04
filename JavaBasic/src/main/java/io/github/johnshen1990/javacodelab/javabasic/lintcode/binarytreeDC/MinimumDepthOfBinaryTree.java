package io.github.johnshen1990.javacodelab.javabasic.lintcode.binarytreeDC;

import io.github.johnshen1990.javacodelab.javabasic.lintcode.TreeNode;

/**
 * Author: zhun.shen
 * Date: 2017-02-04 12:28
 * Description:
 * 给定一个二叉树，找出其最小深度。
 * 二叉树的深度为根节点到最远叶子节点的距离。
 *
 * 样例
 * 给出一棵如下的二叉树:
 *      1
 *     / \
 *    2  3
 *      / \
 *     4  5
 * 这个二叉树的最大深度为2.
 */
public class MinimumDepthOfBinaryTree {
    /**
     * @param root: The root of binary tree.
     * @return: An integer.
     * 思路: 当前树的最小深度 = min(左子树的最小深度, 右子树的最小深度) + 1
     */
    public int minDepth(TreeNode root) {
        // 对空的根节点直接返回深度0
        if (root == null) {
            return 0;
        }
        // 对非空的根节点使用getMin方法递归最小深度
        return getMin(root);
    }

    /**
     * @param root
     * @return
     */
    private int getMin(TreeNode root) {
        // 如果子树为空,则返回整型的最大值,使其不可能在递归调用Math.min()后被最终返回。
        if(root == null){
            return Integer.MAX_VALUE;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        int leftTreeMinDepth = getMin(root.left);
        int rightTreeMinDepth = getMin(root.right);
        return Math.min(leftTreeMinDepth, rightTreeMinDepth) + 1;
    }
}
