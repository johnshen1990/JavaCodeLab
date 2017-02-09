package io.github.johnshen1990.javacodelab.javabasic.lintcode.binarytreeDC;

import io.github.johnshen1990.javacodelab.javabasic.lintcode.TreeNode;

/**
 * Author: zhun.shen
 * Date: 2017-02-04 18:47
 * Description:
 *
 * 将一棵二叉树按照前序遍历拆解成为一个假链表。所谓的假链表是说，用二叉树的 right 指针，来表示链表中的 next 指针。
 * 注意事项
 * 不要忘记将左儿子标记为 null，否则你可能会得到空间溢出或是时间溢出。
 *
 * 样例
 *                 1
 *                  \
 *        1          2
 *       / \          \
 *      2   5    =>    3
 *     / \   \          \
 *    3   4   6          4
 *                        \
 *                         5
 *                          \
 *                           6
 */
public class FlattenBinaryTreeToLinkedList {
    /**
     * @param root: a TreeNode, the root of the binary tree
     * @return: nothing
     */
    public void flatten(TreeNode root) {
        flatAndReturnLastNode(root);
    }

    /**
     * 将树flat后,返回末尾的节点
     * @param root
     * @return
     */
    public TreeNode flatAndReturnLastNode(TreeNode root){
        if (root == null) {
            return null;
        }

        // 叶子节点返回本身
        if (root.left == null && root.right == null) {
            return root;
        }

        // flat左子树,返回末尾节点
        TreeNode lastNodeOnLeft = flatAndReturnLastNode(root.left);

        // flat右子树,返回末尾节点
        TreeNode lastNodeOnRight = flatAndReturnLastNode(root.right);

        // 左子树为空,返回右子树的末尾节点
        if (lastNodeOnLeft == null) {
            // lastNodeOnLeft和lastNodeOnRight不可能同时为空,因为root属于叶子节点的情况,已经在前面处理了
            return lastNodeOnRight;
        }

        // 右子树拼到左子树末尾节点的右边
        lastNodeOnLeft.right = root.right;

        // 左子树替换右子树
        root.right = root.left;

        // 左子树置空
        root.left = null;

        if (lastNodeOnRight != null) {
            return lastNodeOnRight;
        }
        return lastNodeOnLeft;
    }
}
