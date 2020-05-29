package Leetcode.topic.linkedlist;

import Leetcode.common.ListNode;

public class LC148_SortList {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(2);
        ListNode node4 = new ListNode(3);
        ListNode node5 = new ListNode(3);
        ListNode node6 = new ListNode(6);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = null;


        LC148_SortList lc83 = new LC148_SortList();
        ListNode ls = lc83.sortList(node1);

        while(ls != null){
            System.out.println(ls.val);
            ls = ls.next;
        }
    }
    public ListNode sortList(ListNode head) {
return head;
    }
}
