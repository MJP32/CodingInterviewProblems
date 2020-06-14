package Leetcode.topic.linkedlist;

import Leetcode.common.ListNode;

import java.util.Stack;

public class LC445_AddTwoNumbers2 {
    public static void main(String[] args) {
        ListNode l1_1 = new ListNode(2);
        ListNode l1_2 = new ListNode(4);
        ListNode l1_3 = new ListNode(3);
        l1_1.next = l1_2;
        l1_2.next = l1_3;

        ListNode l2_1 = new ListNode(5);
        ListNode l2_2 = new ListNode(6);
        ListNode l2_3 = new ListNode(4);
        l2_1.next = l2_2;
        l2_2.next = l2_3;

        ListNode result = new LC445_AddTwoNumbers2().addTwoNumbers(l1_1, l2_1);

        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        Stack<ListNode> stack1 = new Stack<>();
        Stack<ListNode> stack2 = new Stack<>();

        while(l1 != null){
            stack1.push(l1);
            l1 =l1.next;
        }

        while (l2!=null) {
            stack2.push(l2);
            l2=l2.next;
        }
        int sum =0;
        int carry =0;
        ListNode dummy = null;
        while(!stack1.isEmpty()||!stack2.isEmpty()){
           sum +=carry;
            if (!stack1.isEmpty()) {
                sum +=stack1.pop().val;
            }
            if (!stack2.isEmpty()) {
                sum +=stack2.pop().val;
            }

            carry = sum/10;
            ListNode newNode = new ListNode(sum%10);
            newNode.next=dummy;
            dummy=newNode;
            sum =0;

        }
        if(carry !=0){
            ListNode newNode = new ListNode(carry);
            newNode.next = dummy;
            dummy = newNode;
        }
        return dummy;

    }
}
