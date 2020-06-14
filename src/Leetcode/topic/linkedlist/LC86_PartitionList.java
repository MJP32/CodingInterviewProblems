package Leetcode.topic.linkedlist;

import Leetcode.common.ListNode;

public class LC86_PartitionList {
    public static void main(String[] args) {

        /*Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.

        You should preserve the original relative order of the nodes in each of the two partitions.

        Example:

        Input: head = 1->4->3->2->5->2, x = 3
        Output: 1->2->2->4->3->5


        */
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(4);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(2);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(2);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = null;


        LC86_PartitionList lc86 = new LC86_PartitionList();
        ListNode ls = lc86.partition(node1, 3);

        while(ls != null){
            System.out.print(ls.val + " ");
            ls = ls.next;
        }
    }
    public ListNode partition(ListNode head, int x) {

        ListNode beforeHead = new ListNode(0);
        ListNode afterHead = new ListNode(0);
        ListNode before = beforeHead;
        ListNode after = afterHead;

        while(head != null){

            if(head.val < x){
                before.next=head;
                before=before.next;
            }
            else{
                after.next =head;
                after = after.next;
            }

            head= head.next;
        }


        after.next = null;
        before.next = afterHead.next;
        return beforeHead.next;

    }
}
