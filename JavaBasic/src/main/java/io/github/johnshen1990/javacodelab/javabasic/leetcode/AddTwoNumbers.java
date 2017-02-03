package io.github.johnshen1990.javacodelab.javabasic.leetcode;

/**
 * Author: zhun.shen
 * Date: 2016-11-12 19:13
 * Description:
 */

public class AddTwoNumbers {
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public static void main(String[] args) {
        ListNode l1 = new ListNode(5);
//        l1.next = new ListNode(4);
//        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
//        l2.next = new ListNode(6);
//        l2.next.next = new ListNode(4);
//        l2.next.next.next = new ListNode(7);

        ListNode result = addTwoNumbers(l1, l2);

        bianli(result);


    }
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);

        ListNode p = l1;
        ListNode q = l2;
        ListNode current = result;
        int carry = 0;
        while (p != null || q != null){
            int m = p==null?0:p.val;
            int n = q==null?0:q.val;
            int sum = m + n + carry;
            carry = sum/10;
            current.next = new ListNode(sum % 10);
            current = current.next;
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }
        if(carry>0){
            current.next = new ListNode(carry);
        }
        return result.next;
//        int r = 0;
//        while(true){
//            int[] t = fun(p.val, q.val);
//            result = add(result, new ListNode(t[0] + r));
//            r = t[1];
//
//            if(p.next == null && q.next == null && r == 0){
//                break;
//            }else{
//                if(p.next == null){
//                    p.next = new ListNode(0);
//                }
//                if(q.next == null){
//                    q.next = new ListNode(0);
//                }
//                p = p.next;
//                q = q.next;
//            }
//        }
//        return result;
    }

//    public static ListNode[] fun(int i, int j){
//        int sum = i+j;
//        if(sum > 9){
//
//            return new int[]{new ListNode(sum % 10), 1};
//        }else{
//            return new ListNode[]{new ListNode(sum), new ListNode(0)};
//        }
//    }

    public static void bianli(ListNode l1){
        ListNode p = l1;
        while(true){
            System.out.println(p.val);
            if(p.next == null){
                break;
            }else{
                p = p.next;
            }
        }
    }

    public static ListNode add(ListNode a, ListNode b){
        if(a == null){
            return b;
        }
        ListNode p = a;
        while (true){
            if(p.next == null){
                break;
            }else{
                p = p.next;
            }
        }
        p.next = b;
        return a;
    }
}
