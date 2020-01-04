package Leetcode.zap.todo.submit;

import Leetcode.common.ListNode;

public class LC83_RemoveDuplicatesInSortedList {
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


        LC83_RemoveDuplicatesInSortedList lc83 = new LC83_RemoveDuplicatesInSortedList();
        ListNode ls = lc83.deleteDuplicates(node1);

        while(ls != null){
            System.out.println(ls.val);
            ls = ls.next;
        }
    }
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null) return null;
        ListNode curr=head;
            while(curr !=null && curr.next != null){

                if(curr.val == curr.next.val){
                    curr.next = curr.next.next;
                }
                else{

                    curr=curr.next;
                }
            }
        return head;
    }
    public ListNode deleteDuplicatesRecursive(ListNode head) {
        if(head==null||head.next==null) return head;

        if(head.val!=head.next.val){
            head.next=deleteDuplicatesRecursive(head.next);
            return head;
        }
        else{
            while(head.next!=null&&head.val==head.next.val)
                head=head.next;

            return   deleteDuplicatesRecursive(head.next);
        }

    }
}
