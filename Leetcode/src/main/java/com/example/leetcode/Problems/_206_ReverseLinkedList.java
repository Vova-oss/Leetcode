package com.example.leetcode.Problems;

public class _206_ReverseLinkedList {

    public static void main(String[] args) {
//        ListNode fifth = new ListNode(5);
//        ListNode fourth = new ListNode(4, fifth);
//        ListNode third = new ListNode(3, fourth);
//        ListNode second = new ListNode(2, third);
        ListNode first = new ListNode(1);
        System.out.println(reverseList(first));
    }


    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }

    public static ListNode reverseList(ListNode head) {
        if (head == null)
            return null;

        ListNode last = getLast(head);
        while (head.next != null) {
            switchedLinksOfLastAndPreLast(head);
        }

        return last;
    }

    public static ListNode getLast(ListNode head){
        while (head.next != null)
            head = head.next;

        return head;
    }

    public static void switchedLinksOfLastAndPreLast(ListNode head){
        ListNode preLast = head;
        while (head.next != null) {
            preLast = head;
            head = head.next;
        }

        preLast.next = null;
        head.next = preLast;
    }

}
