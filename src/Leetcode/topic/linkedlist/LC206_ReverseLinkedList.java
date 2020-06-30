package Leetcode.topic.linkedlist;

import Leetcode.common.ListNode;

import java.util.Stack;

public class LC206_ReverseLinkedList {
    public static void main(String[] args) {

        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);

        one.next =two;
        two.next =three;
        three.next = null;
        ListNode reversedListHead = new LC206_ReverseLinkedList().reverseList(one);

        while (reversedListHead != null) {
            System.out.println(reversedListHead.val);
            reversedListHead = reversedListHead.next;
        }
    }
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null){
            return  head;
        }
        ListNode prev = null;
        while(head != null){
            ListNode nextNode = head.next;
            head.next = prev;
            prev = head;
            head = nextNode;
        }
        return prev;

    }
    public ListNode reverseList2(ListNode head) {
        Stack<ListNode> stack = new Stack<>();


        while(head != null){
            stack.push(head);
            head = head.next;
        }

        ListNode dummy = new ListNode(-1);
        head = dummy;


        while(!stack.isEmpty()){
            ListNode current = stack.pop();
            head.next =new ListNode(current.val);
            head = head.next;
        }

        return dummy.next;

    }
}
