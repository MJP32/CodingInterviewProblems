package Leetcode.topic.linkedlist;

import Leetcode.common.ListNode;

public class LC2_AddTwoNumbers {


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

        ListNode result = addTwoNumbers(l1_1, l2_1);

        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode resultHead = new ListNode(-1);
        ListNode result = resultHead;

        int sum = 0;
        int digit = 0;
        int carry = 0;
        while (l1 != null || l2 != null || carry != 0) {
            result.next = new ListNode(0);
            result = result.next;

            sum = 0;
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }

            sum = sum + carry;
            digit = sum % 10;
            carry = sum / 10;

            result.val = digit;


        }

        return resultHead.next;
    }
}


