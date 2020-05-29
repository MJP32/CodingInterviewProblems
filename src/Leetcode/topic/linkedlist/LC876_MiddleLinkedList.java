package Leetcode.topic.linkedlist;

import Leetcode.common.ListNode;

public class LC876_MiddleLinkedList {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);

        node1.next = node2;
        node2.next = node3;
        node3.next = null;

        LC876_MiddleLinkedList lc876 = new LC876_MiddleLinkedList();
        System.out.println(lc876.middleNode(node1).val);
    }
    public ListNode middleNode(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while(fast != null && fast.next != null ){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
