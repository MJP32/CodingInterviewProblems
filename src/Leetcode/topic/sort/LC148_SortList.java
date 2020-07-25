package Leetcode.topic.sort;

import Leetcode.common.ListNode;

public class LC148_SortList {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(5);
        ListNode node3 = new ListNode(6);
        ListNode node4 = new ListNode(2);
        ListNode node5 = new ListNode(3);
        ListNode node6 = new ListNode(7);

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
        if(head == null || head.next == null){
            return head;
        }

        
        ListNode temp = head;
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null){
            temp = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        temp.next = null;
        ListNode leftSide = sortList(head);
        ListNode rightSide  = sortList(slow);
        return merge(leftSide, rightSide);

    }

    private ListNode merge(ListNode leftSide, ListNode rightSide) {
        ListNode dummy = new ListNode(0);
        ListNode currentNode = dummy;

        while(leftSide != null && rightSide != null){
            if(leftSide.val <= rightSide.val){
                currentNode.next = leftSide;
                leftSide= leftSide.next;
            }
            else {
                currentNode.next = rightSide;
                rightSide = rightSide.next;
            }
            currentNode = currentNode.next;
        }

        if(leftSide != null){
            currentNode.next = leftSide;
            //leftSide = leftSide.next;
        }

        if(rightSide != null){
            currentNode.next = rightSide;
            //rightSide = rightSide.next;
        }

        return dummy.next;
    }


}
