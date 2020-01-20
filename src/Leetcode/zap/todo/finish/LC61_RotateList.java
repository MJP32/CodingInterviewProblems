package Leetcode.zap.todo.finish;

import Leetcode.common.ListNode;

public class LC61_RotateList {
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

        LC61_RotateList lc61 = new LC61_RotateList();
        ListNode head = lc61.rotateRight(node1, 2);

        while(head != null){
            System.out.println(head.val);
            head = head.next;
        }

    }

    public ListNode rotateRight(ListNode head, int k) {

        if(head==null)
            return null;
        int size = 1; // since we are already at head node
        ListNode fast=head;
        ListNode slow = head;

        while(fast.next!=null){
            size++;
            fast = fast.next;
        }

        for(int i=size-k%size;i>1;i--) // i>1 because we need to put slow.next at the start.
            slow = slow.next;

        // No dummy variable.
        fast.next = head;
        head = slow.next;
        slow.next = null;

        return head;


    }
}
