package com.example.leetcode.Problems;

import java.util.HashSet;
import java.util.Set;

public class _141_LinkedListCycle {

    public static void main(String[] args) {
        ListNode fifth = new ListNode(5);
        ListNode fourth = new ListNode(4, fifth);
        ListNode third = new ListNode(3, fourth);
        ListNode second = new ListNode(2, third);
        ListNode first = new ListNode(1, second);
//        fifth.next = third;
        System.out.println(hasCycle(first));
    }

    public static boolean hasCycle(ListNode head) {
        if (head == null)
            return false;
        Set<ListNode> set = new HashSet<>();
        set.add(head);
        while (head.next != null){
            head = head.next;
            if (set.contains(head))
                return true;
            set.add(head);
        }
        return false;
    }





    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val,ListNode next) { this.val = val; this.next = next; }

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }

}
