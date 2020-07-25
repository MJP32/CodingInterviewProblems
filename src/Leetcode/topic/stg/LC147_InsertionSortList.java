package Leetcode.topic.stg;

import Leetcode.common.ListNode;

public class LC147_InsertionSortList {
    ListNode sorted;
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


        LC147_InsertionSortList lc147 = new LC147_InsertionSortList();
        ListNode ls = lc147.insertionSortList(node1);

        while(ls != null){
            System.out.println(ls.val);
            ls = ls.next;
        }
    }
    // function to sort a singly linked list using insertion sort
    ListNode insertionSortList(ListNode head)
    {
        // Initialize sorted linked list
        sorted = null;
        ListNode current = head;
        // Traverse the given linked list and insert every
        // node to sorted
        while (current != null)
        {
            // Store next for next iteration
            ListNode next = current.next;
            // insert current in sorted linked list
            sortedInsert(current);
            // Update current
            current = next;
        }
        // Update head_ref to point to sorted linked list
        head = sorted;
        return head;
    }

    /*
     * function to insert a new_node in a list. Note that
     * this function expects a pointer to head_ref as this
     * can modify the head of the input linked list
     * (similar to push())
     */
    void sortedInsert(ListNode newnode)
    {
        /* Special case for the head end */
        if (sorted == null || sorted.val >= newnode.val)
        {
            newnode.next = sorted;
            sorted = newnode;
        }
        else
        {
            ListNode current = sorted;
            /* Locate the node before the point of insertion */
            while (current.next != null && current.next.val < newnode.val)
            {
                current = current.next;
            }
            newnode.next = current.next;
            current.next = newnode;
        }
    }





}
