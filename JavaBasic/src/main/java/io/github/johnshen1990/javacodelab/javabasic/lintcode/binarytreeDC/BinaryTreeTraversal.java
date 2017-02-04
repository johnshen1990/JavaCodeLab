package io.github.johnshen1990.javacodelab.javabasic.lintcode.binarytreeDC;

import io.github.johnshen1990.javacodelab.javabasic.lintcode.TreeNode;

import java.util.ArrayList;

/**
 * Author: zhun.shen
 * Date: 2017-02-04 12:04
 * Description:给出一棵二叉树，返回其节点值的前序遍历。
 * 样例
 * 给出一棵二叉树 {1,#,2,3},
 *     1
 *      \
 *      2
 *     /
 *    3
 * 返回 [1,2,3].
 */
public class BinaryTreeTraversal {
    /**
     * @param root: The root of binary tree.
     * @return: Preorder in ArrayList which contains node values.
     */
    public ArrayList<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        ArrayList<Integer> leftPreorderTraversal = preorderTraversal(root.left);
        ArrayList<Integer> rightPreorderTraversal = preorderTraversal(root.right);
        result.add(root.val);
        result.addAll(leftPreorderTraversal);
        result.addAll(rightPreorderTraversal);
        return result;
    }

    /**
     * @param root: The root of binary tree.
     * @return: Inorder in ArrayList which contains node values.
     */
    public ArrayList<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        ArrayList<Integer> leftInorderTraversal = inorderTraversal(root.left);
        ArrayList<Integer> rightInorderTraversal = inorderTraversal(root.right);
        result.addAll(leftInorderTraversal);
        result.add(root.val);
        result.addAll(rightInorderTraversal);
        return result;
    }

    /**
     * @param root: The root of binary tree.
     * @return: Postorder in ArrayList which contains node values.
     */
    public ArrayList<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        ArrayList<Integer> leftPostorderTraversal = postorderTraversal(root.left);
        ArrayList<Integer> rightPostorderTraversal = postorderTraversal(root.right);
        result.addAll(leftPostorderTraversal);
        result.addAll(rightPostorderTraversal);
        result.add(root.val);
        return result;
    }
}
