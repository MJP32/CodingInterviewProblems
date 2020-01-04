package Leetcode.zap.todo.finish;

import Leetcode.common.ListNode;

public class LC369_PlusOneLinkedList {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);

        node1.next = node2;
        node2.next = node3;
        node3.next = null;

        LC369_PlusOneLinkedList lc369 = new LC369_PlusOneLinkedList();

    }

    public ListNode plusOne(ListNode head) {

        ListNode dummy = head;

        while(head != null){


            head = head.next;
        }


        return head;
    }
}
