package Leetcode.topic.linkedlist;

import Leetcode.common.ListNode;

public class LC328_OdddEvenLinkedList {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        ListNode node7 = new ListNode(7);
        ListNode node8 = new ListNode(8);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        node7.next = node8;
        node8.next = null;

        LC328_OdddEvenLinkedList lc328 = new LC328_OdddEvenLinkedList();
        ListNode head = lc328.oddEvenList(node1);

        while(head != null){
            System.out.println(head.val);
            head = head.next;
        }

    }

    public ListNode oddEvenList(ListNode head) {


        if(head == null) return null;


        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = even;

        while(even != null && even.next !=null){
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;






        }

        odd.next = evenHead;



        return head;

    }
}
