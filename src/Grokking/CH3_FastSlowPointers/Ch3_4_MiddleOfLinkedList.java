package Grokking.CH3_FastSlowPointers;



class Ch3_4_MiddleOfLinkedList {

    public static ListNode findMiddle(ListNode head) {


        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next!= null) {


            slow = slow.next;
            fast = fast.next.next;
        }


        return slow;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        System.out.println("Middle Node: " + Ch3_4_MiddleOfLinkedList.findMiddle(head).value);

        head.next.next.next.next.next = new ListNode(6);
        System.out.println("Middle Node: " + Ch3_4_MiddleOfLinkedList.findMiddle(head).value);

        head.next.next.next.next.next.next = new ListNode(7);
        System.out.println("Middle Node: " + Ch3_4_MiddleOfLinkedList.findMiddle(head).value);
    }
}