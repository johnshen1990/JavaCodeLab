package io.github.johnshen1990.javacodelab.javabasic.lintcode.binarytreeDC;

import io.github.johnshen1990.javacodelab.javabasic.lintcode.TreeNode;

/**
 * Author: zhun.shen
 * Date: 2017-02-04 12:28
 * Description:
 * 给定一个二叉树，找出其最大深度。
 * 二叉树的深度为根节点到最远叶子节点的距离。
 *
 * 样例
 * 给出一棵如下的二叉树:
 *      1
 *     / \
 *    2  3
 *      / \
 *     4  5
 * 这个二叉树的最大深度为3.
 */
public class MaximumDepthOfBinaryTree {
    /**
     * @param root: The root of binary tree.
     * @return: An integer.
     * 思路: 当前树的最大深度 = max(左子树的最大深度, 右子树的最大深度) + 1
     */
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftTreeMaxDepth = maxDepth(root.left);
        int rightTreeMaxDepth = maxDepth(root.right);
        return Math.max(leftTreeMaxDepth, rightTreeMaxDepth) + 1;
    }
}
