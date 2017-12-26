package io.github.johnshen1990.javacodelab.javabasic.lintcode.bfs;

import io.github.johnshen1990.javacodelab.javabasic.lintcode.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Author: zhun.shen
 * Date: 2017-02-18 16:24
 * Description:
 *
 * 给出一棵二叉树，返回其节点值的层次遍历（逐层从左往右访问）
 *
 * 给一棵二叉树 {3,9,20,#,#,15,7} ：
 *      3
 *     / \
 *    9  20
 *      /  \
 *     15   7
 * 返回他的分层遍历结果：
 * [
 *   [3],
 *   [9,20],
 *   [15,7]
 * ]
 *
 */
public class BinaryTreeLevelOrderTravelsal {
    /**
     * @param root: The root of binary tree.
     * @return: Level order a list of lists of integer
     */
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        // 空树返回空集
        if (root == null) {
            return result;
        }

        // 用一个队列来保存每一层的所有节点
        Queue<TreeNode> queue = new LinkedList<>();
        // 先将根节点加入队列
        queue.offer(root);

        // 队列中有待处理的节点, 每一次循环代表一层
        while (!queue.isEmpty()) {
            ArrayList<Integer> level = new ArrayList<>();
            // 将这一层的节点个数缓存起来
            int size = queue.size();
            // 遍历这一层的节点
            for (int i = 0; i < size; i++) {
                // 出列一个节点(由于队列的FIFO特性,与入列的顺序相同,从左到右)
                TreeNode node = queue.poll();
                // 将出列节点的值加入当前层的结果列表
                level.add(node.val);
                // 如果当前节点有左子树,将左子树根根节点加入队列,以便触发下一层的循环
                if (node.left != null) {
                    queue.add(node.left);
                }
                // 如果当前节点有右子树,将左子树根根节点加入队列,以便触发下一层的循环
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            // 将这一层的结果列表加入到总的结果列表
            result.add(level);
        }

        return result;
    }
}
