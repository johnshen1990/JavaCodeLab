package io.github.johnshen1990.javacodelab.javabasic.lintcode.binarytreeDC;

import io.github.johnshen1990.javacodelab.javabasic.lintcode.TreeNode;

/**
 * Author: zhun.shen
 * Date: 2017-02-04 15:37
 * Description:
 * Given a binary tree, find the subtree with minimum sum. Return the root of the subtree.
 * Notice
 * LintCode will print the subtree which root is your return node.
 * It's guaranteed that there is only one subtree with minimum sum and the given binary tree is not an empty tree.
 *
 * Example:
 * Given a binary tree:
 *        1
 *     /    \
 *   -5     2
 *   / \   / \
 *  0  2 -4  -5
 *
 * return the node 1.
 */
public class MinimumSubtree {
    /**
     * 全局变量,保存sum最小的子树,和这个子树的sum
     */
    private TreeNode subtree = null;
    private int sum = Integer.MAX_VALUE;

    /**
     * @param root the root of binary tree
     * @return the root of the minimum subtree
     */
    public TreeNode findSubtree(TreeNode root) {
        getSum(root);
        return subtree;
    }

    /**
     * 遍历树, 求出每个子树的sum,并将sum更小的子树保存到全局变量。
     * @param root
     * @return
     */
    private int getSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftSubtreeSum = getSum(root.left);
        int rightSubtreeSum = getSum(root.right);
        int totalSum = root.val + leftSubtreeSum + rightSubtreeSum;
        if (totalSum < sum) {
            sum = totalSum;
            subtree = root;
        }
        return totalSum;
    }
}
