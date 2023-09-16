package com.example.leetcode.Problems.Done;

public class _92_M_ReverseLinkedList_II {

    public static void main(String[] args) {
//        ListNode fifth = new ListNode(5);
//        ListNode fourth = new ListNode(4, fifth);
//        ListNode third = new ListNode(3, fourth);
        ListNode second = new ListNode(2);
        ListNode first = new ListNode(1, second);
        System.out.println(reverseBetween(first, 1, 2));
    }

    //////////////////////////////// FIRST WAY /////////////////////////////////////////////////////////////////////////
    public static ListNode reverseBetween(ListNode head, int left, int right) {
        if (head.next == null || left == right)
            return head;

        ListNode beforeFirstToRevert;
        ListNode firstToReverse;
        ListNode lastToReverse;
        ListNode afterLastToReverse;
        if (left == 1) {
            beforeFirstToRevert = null;
            firstToReverse = findByNumber(head, 1);
        }else {
            beforeFirstToRevert = findByNumber(head, left - 1);
            firstToReverse = findByNumber(beforeFirstToRevert, 2);
        }
        lastToReverse = findByNumber(firstToReverse, right - left + 1);
        afterLastToReverse = findByNumber(lastToReverse, 2);

        if (right - left == 1){
            lastToReverse.next = firstToReverse;
        } else {
            reverseList(firstToReverse, firstToReverse.next, lastToReverse);
        }

        if (left == 1){
            head.next = afterLastToReverse;
            return lastToReverse;
        } else {
            beforeFirstToRevert.next = lastToReverse;
            firstToReverse.next = afterLastToReverse;
            return head;
        }
    }

    public static void reverseList(ListNode previous, ListNode node,  ListNode lastNode){
        ListNode finish = lastNode.next;
        do {
            ListNode next = node.next;
            node.next = previous;
            previous = node;
            node = next;
        } while (node != finish);
    }

    public static ListNode findByNumber(ListNode node, int number){
        for (int i = 1; i < number; i++){
            node = node.next;
        }
        return node;
    }





//    ////////////////////////////////// SECOND WAY ////////////////////////////////////////////////////////////////////
//    public static ListNode reverseBetween(ListNode head, int left, int right) {
//        if (head.next == null || left == right)
//            return head;
//
//        List<ListNode> list = fillList(head);
//
//        for (int i = left; i < right; i++){
//            ListNode current = list.get(i);
//            current.next = list.get(i - 1);
//
//        }
//
//         if (left == 1){
//             if (right == list.size()){
//                list.get(0).next = null;
//             } else {
//                list.get(0).next = list.get(right);
//             }
//             return list.get(right - 1);
//         } else {
//             list.get(left - 2).next = list.get(right - 1);
//             if (right == list.size())
//                list.get(left - 1).next = null;
//             else
//                 list.get(left - 1).next = list.get(right);
//             return head;
//         }
//    }
//
//
//    public static List<ListNode> fillList(ListNode head){
//        List<ListNode> list = new ArrayList<>();
//        while (head != null){
//            list.add(head);
//            head = head.next;
//        }
//        return list;
//    }







    ///////////////////////////// BASIC CLASS //////////////////////////////////////////////////////////////////////////
    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }
}
