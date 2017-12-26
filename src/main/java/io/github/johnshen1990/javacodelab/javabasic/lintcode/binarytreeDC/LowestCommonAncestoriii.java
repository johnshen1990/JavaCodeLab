package io.github.johnshen1990.javacodelab.javabasic.lintcode.binarytreeDC;

import io.github.johnshen1990.javacodelab.javabasic.lintcode.TreeNode;

/**
 * Author: zhun.shen
 * Date: 2017-02-11 15:41
 * Description:
 *
 * 给出下面这棵树：

 *     4
 *    / \
 *   3   7
 *      / \
 *     5   6
 * LCA(3, 5) = 4
 * LCA(5, 6) = 7
 * LCA(6, 7) = 7
 * LCA(5, 8) = null
 *
 * 给一棵二叉树和二叉树中的两个节点，找到这两个节点的最近公共祖先LCA。
 * 两个节点的最近公共祖先，是指两个节点的所有父亲节点中（包括这两个节点），离这两个节点最近的公共的节点。
 * 返回 null 如果两个节点在这棵树上不存在最近公共祖先的话。
 */
public class LowestCommonAncestoriii {
    /**
     * @param root The root of the binary tree.
     * @param A and B two nodes
     * @return: Return the LCA of the two nodes.
     */
    public TreeNode lowestCommonAncestor3(TreeNode root, TreeNode A, TreeNode B) {
        if(root == null) {
            return null;
        }
        TreeNode left = lowestCommonAncestor3(root.left, A, B);
        if(left != null) {
            return left;
        }
        TreeNode right = lowestCommonAncestor3(root.right, A, B);
        if(right != null) {
            return right;
        }
        if(find(root, A) && find(root, B)) {
            return root;
        }
        return null;

    }

    /**
     * 在二叉树中查找target是否存在
     * @param root
     * @param target
     * @return
     */
    public boolean find(TreeNode root, TreeNode target){
        if(root.val == target.val) {
            return true;
        }
        if(root.left != null && find(root.left, target)) {
            return true;
        }
        if(root.right != null && find(root.right, target)) {
            return true;
        }
        return false;
    }
}
