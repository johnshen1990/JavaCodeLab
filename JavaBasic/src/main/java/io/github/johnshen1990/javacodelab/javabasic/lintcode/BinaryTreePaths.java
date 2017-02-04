package io.github.johnshen1990.javacodelab.javabasic.lintcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: zhun.shen
 * Date: 2017-02-04 13:13
 * Description: Given a binary tree, return all root-to-leaf paths.
 * Example:
 * Given the following binary tree:
 *      1
 *     / \
 *    2  3
 *     \
 *     5
 * All root-to-leaf paths are:
 * [
 *  "1->2->5",
 *  "1->3"
 * ]
 */
public class BinaryTreePaths {
    /**
     * @param root the root of the binary tree
     * @return all root-to-leaf paths
     * 思路:
     *  结果集 = 取左子树的路径集合与根节点拼接为新集合 + 取右子树的路径集合与跟节点拼接为新集合
     */
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        // 如果为叶子节点,则返回仅包含叶子节点元素的集合
        if (root.left == null && root.right == null) {
            result.add(root.val + "");
            return result;
        }

        List<String> leftSubtreePath = binaryTreePaths(root.left);
        result.addAll(addSubtreePath(root, leftSubtreePath));

        List<String> rightSubtreePath = binaryTreePaths(root.right);
        result.addAll(addSubtreePath(root, rightSubtreePath));
        return result;

    }

    /**
     * 将当前根节点和一个子树的路径集合,拼接成新的路径集合,为当前根节点的路径集合
     *
     * @param root
     * @param subtreePathList
     * @return
     */
    private List<String> addSubtreePath(TreeNode root, List<String> subtreePathList) {
        List<String> result = new ArrayList<>();
        for (String path : subtreePathList) {
            result.add(root.val + "->" + path);
        }
        return result;
    }
}
