package Leetcode.zap.todo.finish;

import Leetcode.common.ListNode;

import java.util.List;

public class LC24_SwapNodePairs {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = null;

       LC24_SwapNodePairs lc24 = new LC24_SwapNodePairs();
       ListNode head = lc24.swapPairs(node1);


       while(head != null){

           System.out.println(head.val);
           head = head.next;
       }
    }

    public ListNode swapPairs(ListNode head) {

        ListNode temp = new ListNode(0);
        temp.next = head;
        ListNode current = temp;

        while(current.next != null && current.next.next != null){

            ListNode first = current.next;
            ListNode second = current.next.next;

            current.next =second;
            first.next = second.next;
            second.next =first;
            current = current.next.next;
        }

         return temp.next;

    }

}
