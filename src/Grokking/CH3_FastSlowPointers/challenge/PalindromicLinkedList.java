package Grokking.CH3_FastSlowPointers.challenge;

import Grokking.CH3_FastSlowPointers.ListNode;

class PalindromicLinkedList {

    public static boolean isPalindrome(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {




            slow = slow.next;
            fast = fast.next.next;
        }



        ListNode reversedSecondHalf = reverse(slow);

        ListNode tempHead = head;

        while(reversedSecondHalf != null||tempHead!=null){

            if (tempHead.value != reversedSecondHalf.value) {
                return false;
            }
            tempHead = tempHead.next;
            reversedSecondHalf = reversedSecondHalf.next;
        }



        return true;
    }

    private static ListNode reverse(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }


        ListNode prev = null;
        while (head != null) {
            ListNode nextNode = head.next;
            head.next = prev;
            prev =head;
            head=nextNode;

        }
        return prev;

    }

    public static void main(String[] args) {
        ListNode head = new ListNode(2);
        head.next = new ListNode(4);
        head.next.next = new ListNode(6);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(2);
        System.out.println("Is palindrome: " + PalindromicLinkedList.isPalindrome(head));

        head.next.next.next.next.next = new ListNode(2);
        System.out.println("Is palindrome: " + PalindromicLinkedList.isPalindrome(head));
    }
}