package io.github.johnshen1990.javacodelab.javabasic.lintcode.binarytreeDC;

import io.github.johnshen1990.javacodelab.javabasic.lintcode.TreeNode;

/**
 * Author: zhun.shen
 * Date: 2017-02-11 14:19
 * Description:
 *
 * 给定一个二叉树，判断它是否是合法的二叉查找树(BST)
 * 一棵BST定义为：
 * 节点的左子树中的值要严格小于该节点的值。
 * 节点的右子树中的值要严格大于该节点的值。
 * 左右子树也必须是二叉查找树。
 * 一个节点的树也是二叉查找树。
 * 样例
 * 一个例子：
 *    2
 *   / \
 *  1   4
 *     / \
 *    3   5
 * 上述这棵二叉树序列化为 {2,1,4,#,#,3,5}.
 */
public class ValidateBinarySearchTree {
    private class ResultType {
        public boolean isValidBST;
        public int minValue;
        public int maxValue;

        public ResultType(boolean isValidBST) {
            this.isValidBST = isValidBST;
        }

        public ResultType(boolean isValidBST, int minValue, int maxValue) {
            this.isValidBST = isValidBST;
            this.minValue = minValue;
            this.maxValue = maxValue;
        }
    }

    /**
     * @param root: The root of binary tree.
     * @return: True if the binary tree is BST, or false
     */
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        return helper(root).isValidBST;

    }

    public ResultType helper(TreeNode root) {
        if (root == null) {
            return null;
        }
        if (root.left == null && root.right == null) {
            return new ResultType(true, root.val, root.val);
        }
        ResultType leftResultType = helper(root.left);
        ResultType rightResultType = helper(root.right);

        if (leftResultType == null && rightResultType != null) {
            if (rightResultType.isValidBST && root.val < rightResultType.minValue) {
                return new ResultType(true, root.val, rightResultType.maxValue);
            }
            return new ResultType(false);
        }
        if (leftResultType != null && rightResultType == null) {
            if (leftResultType.isValidBST && root.val > leftResultType.maxValue) {
                return new ResultType(true, leftResultType.minValue, root.val);
            }
            return new ResultType(false);
        }

        if (leftResultType.isValidBST && rightResultType.isValidBST
                && root.val > leftResultType.maxValue
                && root.val < rightResultType.minValue) {
            return new ResultType(true, leftResultType.minValue, rightResultType.maxValue);
        }
        return new ResultType(false);
    }
}
