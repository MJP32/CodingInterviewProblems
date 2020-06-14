package Leetcode.topic.linkedlist;

import Leetcode.common.ListNode;

public class LC92_ReverseLinkedList2 {
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

        LC92_ReverseLinkedList2 lc92 = new LC92_ReverseLinkedList2();
        ListNode head =  lc92.reverseBetween(node1, 2,4);

        while(head != null){
            System.out.println(head.val);
            head = head.next;
        }

    }
    public ListNode reverseBetween(ListNode head, int m, int n) {

        if(head == null || head.next == null){
            return head;
        }
        ListNode curr = head, prev=null;
        while(m> 1){
            prev = curr;
            curr = curr.next;

            m--;
            n--;
        }
        ListNode con = prev, tail = curr;
        ListNode third = null;

        while(n >0){
            third = curr.next;
            curr.next = prev;
            prev = curr;
            curr = third;
            n--;
        }

        if(con != null){
            con.next =prev;
        }
        else{
            head = prev;
        }

        tail.next = curr;





        return head;
    }

}
