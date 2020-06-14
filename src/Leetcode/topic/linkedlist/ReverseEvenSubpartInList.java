package Leetcode.topic.linkedlist;

import Leetcode.common.ListNode;

public class ReverseEvenSubpartInList {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(18);
        ListNode node2 = new ListNode(24);
        ListNode node3 = new ListNode(2);
        ListNode node4 = new ListNode(3);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(7);
        ListNode node7 = new ListNode(9);
        ListNode node8 = new ListNode(6);
        ListNode node9 = new ListNode(12);
        //ListNode node7 = new ListNode(17);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        node7.next = node8;
        node8.next = node9;
        node9.next = null;
        //node7.next = null;



        ListNode reverse = new ReverseEvenSubpartInList().reverse(node1);
        while(reverse != null){
            System.out.print(reverse.val + " ");
            reverse= reverse.next;
        }
    }


    ListNode reverse(ListNode head) {
        ListNode temp = new ListNode(0);
        temp.next = head;
        ListNode current = temp;

        while(current != null && current.next!= null  ){

            ListNode first = current.next;
            ListNode second = current.next.next;

            if(first.val%2==0 && second.val%2==0){
                current.next = second;
                first.next =second.next;
                second.next = first;
                current = current.next.next;
            }


            current = current.next;
        }
        return temp.next;
    }
}
