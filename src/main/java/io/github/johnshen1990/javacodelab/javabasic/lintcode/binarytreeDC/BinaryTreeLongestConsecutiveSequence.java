package io.github.johnshen1990.javacodelab.javabasic.lintcode.binarytreeDC;

import io.github.johnshen1990.javacodelab.javabasic.lintcode.TreeNode;

/**
 * Author: zhun.shen
 * Date: 2017-02-04 17:08
 * Description:
 * Given a binary tree, find the length of the longest consecutive sequence path.
 * The path refers to any sequence of nodes from some starting node to any node
 * in the tree along the parent-child connections.
 * The longest consecutive path need to be from parent to child (cannot be the reverse).
 * <p/>
 * 样例
 * For example,
 * <p/>
 *      1
 *       \
 *        3
 *       / \
 *      2   4
 *           \
 *            5
 * Longest consecutive sequence path is 3-4-5, so return 3.
 *      2
 *       \
 *        3
 *       /
 *      2
 *     /
 *    1
 * Longest consecutive sequence path is 2-3,not3-2-1, so return 2.
 */
public class BinaryTreeLongestConsecutiveSequence {
    private int longest = 0;

    /**
     * @param root the root of binary tree
     * @return the length of the longest consecutive sequence path
     */
    public int longestConsecutive(TreeNode root) {
        helper(root);
        return longest;
    }

    private int helper(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int subtreeLongest = 1;
        int left = helper(root.left);
        int right = helper(root.right);

        if (root.left != null && root.val + 1 == root.left.val) {
            subtreeLongest = Math.max(left + 1, subtreeLongest);
        }

        if (root.right != null && root.val + 1 == root.right.val) {
            subtreeLongest = Math.max(right + 1, subtreeLongest);
        }

        if (subtreeLongest > longest) {
            longest = subtreeLongest;
        }
        return subtreeLongest;
    }
}