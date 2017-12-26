package io.github.johnshen1990.javacodelab.javabasic.lintcode.binarytreeDC;

import io.github.johnshen1990.javacodelab.javabasic.lintcode.TreeNode;

/**
 * Author: zhun.shen
 * Date: 2017-02-04 11:45
 * Description:
 *
 * Given a binary tree, find the subtree with maximum average. Return the root of the subtree.
 * 注意事项
 * LintCode will print the subtree which root is your return node.
 * It's guaranteed that there is only one subtree with maximum average.
 *
 * 样例
 * Given a binary tree:
 *            1
 *          /  \
 *        -5   11
 *       /  \  / \
 *      1   2 4  -2
 * return the node 11.
 */
public class SubtreeWithMaximumAverage {

    private class ResultType{
        public int sum;
        public int size;

        public ResultType(int sum, int size) {
            this.sum = sum;
            this.size = size;
        }
    }

    private TreeNode treeNode = null;
    private double maxAvg = Double.MIN_VALUE;

    /**
     * @param root the root of binary tree
     * @return the root of the maximum average of subtree
     */
    public TreeNode findSubtree2(TreeNode root) {
        helper(root);
        return treeNode;
    }

    /**
     *
     * @param root
     * @return
     * 这里的helper方法需要返回每个子树的两个信息:总和、节点数。因此用一个内部类ResultType来保存。
     */
    private ResultType helper(TreeNode root) {
        if (root == null) {
            return new ResultType(0, 0);
        }

        ResultType leftSubtreeResultType = helper(root.left);
        ResultType rightSubtreeResultType = helper(root.right);
        int sum = leftSubtreeResultType.sum + rightSubtreeResultType.sum + root.val;
        int size = leftSubtreeResultType.size + rightSubtreeResultType.size + 1;
        double avg = (double) sum / size;
        if (avg > maxAvg) {
            treeNode = root;
            maxAvg = avg;
        }
        return new ResultType(sum, size);
    }
}
