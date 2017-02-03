package io.github.johnshen1990.javacodelab.javabasic.leetcode;

import java.util.HashSet;

public class DeleteDup {
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static void bianli(ListNode first){
        for(ListNode i = first; i!= null; i = i.next){
            System.out.println(i.val);
        }
    }

    public static void deleteDup1(ListNode first){
        HashSet<Integer> set = new HashSet<>();
        ListNode pre = null;
        for(ListNode i = first; i != null; i = i.next){
            if(set.contains(i.val)){
                pre.next = i.next;
            }else{
                set.add(i.val);
                pre=i;
            }
        }
    }

    public static void deleteDup2(ListNode first){
        for(ListNode i = first; i != null; i = i.next){
            int value = i.val;
            ListNode pre = i;
            for(ListNode j = i.next; j != null; j = j.next){
                if(j.val == value){
                    pre.next = j.next;
                }else{
                    pre = pre.next;
                }
            }
        }
    }

    public static void main(String[] args) {
        ListNode first = new ListNode(1);
        ListNode second = new ListNode(2);
        ListNode third = new ListNode(1);
        first.next = second;
        second.next = third;

        bianli(first);
        deleteDup2(first);
        bianli(first);
    }
}
