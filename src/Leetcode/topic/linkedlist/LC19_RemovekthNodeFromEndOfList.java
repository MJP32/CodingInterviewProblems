package Leetcode.topic.linkedlist;

import Leetcode.common.ListNode;

public class LC19_RemovekthNodeFromEndOfList {
    public static void main(String[] args) {

        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = null;

        LC19_RemovekthNodeFromEndOfList lc19 = new LC19_RemovekthNodeFromEndOfList();
        ListNode head = lc19.removeNthFromEnd(node1, 2);

        while(head !=  null) {
            System.out.println(head.val);
            head = head.next;
        }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode dummy = new ListNode(-1);
        ListNode slow = dummy;
        ListNode fast = dummy;

        dummy.next = head;

        for(int i =1; i <=n+1;i++){
            fast = fast.next;
        }
        while(fast != null){
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }
}
