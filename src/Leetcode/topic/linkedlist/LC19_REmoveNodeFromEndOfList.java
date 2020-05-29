package Leetcode.topic.linkedlist;

import Leetcode.common.ListNode;

public class LC19_REmoveNodeFromEndOfList {
    public static void main(String[] args) {
        ListNode l1_1 = new ListNode(1);
        ListNode l1_2 = new ListNode(2);
        ListNode l1_3 = new ListNode(3);
        ListNode l1_4 = new ListNode(4);
        ListNode l1_5 = new ListNode(5);
        l1_1.next = l1_2;
        l1_2.next = l1_3;
        l1_3.next = l1_4;
        l1_4.next = l1_5;
        l1_5.next = null;

        LC19_REmoveNodeFromEndOfList lc19 = new LC19_REmoveNodeFromEndOfList();
        ListNode head = lc19.removeNthFromEnd(l1_1, 2);

        while(head != null){
            System.out.println(head.val);
            head = head.next;
        }

    }


    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || head.next ==null) {
            return head;
        }
        ListNode slow = head;
        ListNode fast = head;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        while (fast.next != null) {
            slow= slow.next;
            fast = fast.next;
        }
        slow.next  = slow.next.next;
        return head;
    }


    public ListNode reverseList(ListNode head){
        if(head == null || head.next == null){
            return head;
        }

        ListNode prev = null;
        while(head != null){

            ListNode nextNode = head.next;

            head.next = prev;
            prev = head;


            head = nextNode;
        }

        return prev;

    }


}
