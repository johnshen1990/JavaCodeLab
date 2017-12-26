package io.github.johnshen1990.javacodelab.javabasic.lintcode.bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Author: zhun.shen
 * Date: 2017-07-22 20:32
 * Description:
 */
public class BinaryTreeSerialization2 {

    public class TreeNode {
        public int val;
        public TreeNode left, right;
        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }

    public static void main(String[] args) {
        String data = "{1,2,3,#,#,4,5}";
        TreeNode root = new BinaryTreeSerialization2().deserialize(data);
        String data1 = new BinaryTreeSerialization2().serialize(root);
        System.out.println(data1);


    }
    public TreeNode deserialize(String data) {
        data = data.replace("{", "");
        data = data.replace("}", "");
        if("".equals(data.trim())) {
            return null;
        }
        Queue<String> queue = new LinkedList<>();
        Queue<String> queue2 = new LinkedList<>();
        String[] dataArray = data.split(",");
        for(int i = 1; i< dataArray.length; i++) {
            queue.offer(dataArray[i]);
        }
        TreeNode root = new TreeNode(Integer.parseInt(dataArray[0]));

        while(!queue.isEmpty()) {
            String leftString = queue.poll();
            String rightString = queue.poll();
            if(leftString != null) {
                if("#".equals(leftString)) {
                    root.left = null;
                } else {
                    root.left = new TreeNode(Integer.parseInt(leftString));
                }
            }
            if(rightString != null) {
                if("#".equals(rightString)) {
                    root.right = null;
                } else {
                    root.right = new TreeNode(Integer.parseInt(rightString));
                }
            }
        }
        return root;
    }

    public String serialize(TreeNode root) {

        Queue<TreeNode> queue = new LinkedList<>();
        List<String> list = new ArrayList<>();
        if(root != null) {
            queue.offer(root);
        }
        while(!queue.isEmpty()) {
            TreeNode polledNode = queue.poll();
            if(polledNode == null) {
                list.add("#");
            } else {
                list.add(String.valueOf(polledNode.val));
                queue.offer(polledNode.left);
                queue.offer(polledNode.right);
            }
        }

        int size = list.size();
        for(int i = size - 1; i < size; i--) {
            String node = list.get(i);
            if("#".equals(node)) {
                list.remove(i);
            } else {
                break;
            }
        }

        StringBuilder sb = new StringBuilder("{");
        for(int i = 0; i < list.size(); i++) {
            String node = list.get(i);
            if(i == 0) {
                sb.append(node);
            } else {
                sb.append(",").append(node);
            }
        }
        sb.append("}");



        return sb.toString();
    }

}
