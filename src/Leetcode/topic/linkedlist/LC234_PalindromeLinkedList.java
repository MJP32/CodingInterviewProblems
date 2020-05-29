package Leetcode.topic.linkedlist;

import Leetcode.common.ListNode;

public class LC234_PalindromeLinkedList {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(2);
        ListNode node4 = new ListNode(1);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = null;

        LC234_PalindromeLinkedList lc234 =new LC234_PalindromeLinkedList();
        System.out.println(lc234.isPalindrome(node1));
    }

    public boolean isPalindrome(ListNode head){

        ListNode slow =head;
        ListNode fast =head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        slow = reversed(slow);
        fast = head;

        while(slow != null){

            if(slow.val != fast.val){
                return false;
            }
            slow = slow.next;
            fast = fast.next;
        }
        return true;
    }

    private ListNode reversed(ListNode head) {

        ListNode prev = null;
        while(head != null){
            ListNode nextNode = head.next;
            head.next =prev;
            prev =head;
            head = nextNode;
        }
        return prev;
    }
}
