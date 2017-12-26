package io.github.johnshen1990.javacodelab.javabasic.lintcode.bfs;

import io.github.johnshen1990.javacodelab.javabasic.lintcode.TreeNode;

import java.util.*;

/**
 * Author: zhun.shen
 * Date: 2017-02-18 18:36
 * Description:
 *
 * 设计一个算法，并编写代码来序列化和反序列化二叉树。
 * 将树写入一个文件被称为“序列化”，读取文件后重建同样的二叉树被称为“反序列化”。
 * 如何反序列化或序列化二叉树是没有限制的，你只需要确保可以将二叉树序列化为一个字符串，
 * 并且可以将字符串反序列化为原来的树结构。
 *
 * 样例
 * 给出一个测试数据样例， 二叉树{3,9,20,#,#,15,7}，表示如下的树结构：
 *      3
 *     / \
 *    9  20
 *      /  \
 *     15  7
 * 我们的数据是进行BFS遍历得到的。当你测试结果wrong answer时，你可以作为输入调试你的代码。
 * 你可以采用其他的方法进行序列化和反序列化。
 *
 */
public class BinaryTreeSerialization {
    /**
     * This method will be invoked first, you should design your own algorithm
     * to serialize a binary tree which denote by a root node to a string which
     * can be easily deserialized by your own "deserialize" method later.
     */
    public String serialize(TreeNode root) {
        List<String> result = new ArrayList<>();
        if(root == null) {
            return helper(result);
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i<size; i++) {
                TreeNode node = queue.poll();
                if(node == null) {
                    result.add("#");
                } else {
                    result.add(Integer.toString(node.val));
                    queue.offer(node.left);
                    queue.offer(node.right);
                }
            }
        }
        return helper(result);

    }

    /**
     * This method will be invoked second, the argument data is what exactly
     * you serialized at method "serialize", that means the data is not given by
     * system, it's given by your own serialize method. So the format of data is
     * designed by yourself, and deserialize it here as you serialize it in
     * "serialize" method.
     */
    public TreeNode deserialize(String data) {
        TreeNode root = null;
        if(data.equals("{}")) {
            return root;
        }
        String[] strArray = data.substring(1, data.length()-1).split(",");
        for(String item : strArray) {
            if(item.equals("#")) {

            }
        }
        return null;
    }

    private String helper(List<String> list) {
        if(list.isEmpty()) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        sb.append(list.get(0));
        if(list.size() > 1) {
            for(int i = 1; i< list.size(); i++) {
                sb.append(",");
                sb.append(list.get(i));
            }
        }
        sb.append("}");
        return sb.toString();
    }


}
