package io.github.johnshen1990.javacodelab.javabasic.lintcode.binarytreeDC;

import io.github.johnshen1990.javacodelab.javabasic.lintcode.TreeNode;

/**
 * Author: zhun.shen
 * Date: 2017-02-04 17:28
 * Description:
 * 给定一个二叉树,确定它是高度平衡的。
 * 对于这个问题,一棵高度平衡的二叉树的定义是：一棵二叉树中每个节点的两个子树的深度相差不会超过1。
 *
 * 样例
 * 给出二叉树 A={3,9,20,#,#,15,7}, B={3,#,20,15,7}

 * A)  3            B)    3
 *    / \                  \
 *   9  20                 20
 *     /  \                / \
 *   15   7              15  7
 * 二叉树A是高度平衡的二叉树，但是B不是
 */
public class BalancedBinaryTree {

    private class ResultType{
        public boolean isBalanced;
        public int depth;
        public ResultType(boolean isBalanced, int depth){
            this.isBalanced = isBalanced;
            this.depth = depth;
        }
    }

    /**
     * @param root: The root of binary tree.
     * @return: True if this Binary tree is Balanced, or false.
     */
    public boolean isBalanced(TreeNode root) {
        return helper(root).isBalanced;
    }

    private ResultType helper(TreeNode root) {
        if (root == null) {
            return new ResultType(true, 0);
        }
        ResultType leftSubtreeResultType = helper(root.left);
        ResultType rightSubtreeResultType = helper(root.right);
        boolean isBalanced = Math.abs(leftSubtreeResultType.depth - rightSubtreeResultType.depth) <= 1
                && leftSubtreeResultType.isBalanced
                && rightSubtreeResultType.isBalanced;
        int depth = Math.max(leftSubtreeResultType.depth, rightSubtreeResultType.depth) + 1;
        return new ResultType(isBalanced, depth);
    }
}
