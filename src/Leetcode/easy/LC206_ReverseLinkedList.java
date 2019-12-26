package Leetcode.easy;

import Leetcode.easy.ListNode;

import java.util.Stack;

public class LC206_ReverseLinkedList {
    public static void main(String[] args) {

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
