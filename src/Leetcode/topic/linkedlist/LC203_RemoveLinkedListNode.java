package Leetcode.topic.linkedlist;

import Leetcode.common.ListNode;

public class LC203_RemoveLinkedListNode {
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

        LC203_RemoveLinkedListNode lc206 = new LC203_RemoveLinkedListNode();
        ListNode head = lc206.removeElements(l1_1, 2);


        while(head != null){
            System.out.println(head.val);
            head = head.next;
        }

    }

    public ListNode removeElements(ListNode head, int val) {
        while(head != null && head.val == val)
             head = head.next;

        ListNode curr = head;


        while(curr != null && curr.next != null){

            if(curr.next.val == val){
                curr.next = curr.next.next;
            }
            else{
                curr = curr.next;
            }


        }

        return head;
    }
}
