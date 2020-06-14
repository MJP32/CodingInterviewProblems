package Leetcode.topic.linkedlist;

import Leetcode.common.ListNode;

public class LC21_MergeTwoSortedLists {
    public static void main(String[] args) {
        /*Merge two sorted linked lists and return it as a new sorted list. The new list should be made by splicing together the nodes of the first two lists.

        Example:

        Input: 1->2->4, 1->3->4
        Output: 1->1->2->3->4->4

        */

        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(4);

        node1.next = node2;
        node2.next = node3;
        node3.next = null;

        ListNode node4 = new ListNode(1);
        ListNode node5 = new ListNode(3);
        ListNode node6 = new ListNode(4);

        node4.next = node5;
        node5.next = node6;
        node6.next = null;

        ListNode mergedList =new LC21_MergeTwoSortedLists().mergeTwoLists(node1,node4);
        while(mergedList != null){
            System.out.print(mergedList.val);
            mergedList = mergedList.next;
        }
    }
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode mergedListHead = new ListNode(-1);
        ListNode mergedList = mergedListHead;

        while(l1 != null && l2 !=null){
            if(l1.val <= l2.val){
                mergedList.next = l1;
                l1 = l1.next;

            }
            else{
                mergedList.next = l2;
                l2 = l2.next;
            }
            mergedList =mergedList.next;
        }

        //add remaining from list that is not null
        mergedList.next = l1 ==null? l2:l1;


        return mergedListHead.next;
    }
}
