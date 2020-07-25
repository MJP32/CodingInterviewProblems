package Interviews;

public class InvertedBisection {
    public static void main(String[] args) {
        LinkedList node1 = new LinkedList(0);
        LinkedList node2 = new LinkedList(1);
        LinkedList node3 = new LinkedList(2);
        LinkedList node4 = new LinkedList(3);
        LinkedList node5 = new LinkedList(4);
        LinkedList node6 = new LinkedList(5);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = null;

        LinkedList invertedList = invertedBisection(node1);
        while (invertedList != null) {
            System.out.print(invertedList.value + " ");
            invertedList = invertedList.next;
        }

    }
    public static LinkedList invertedBisection(LinkedList head) {
        // get length of list
        int len = getLinkedListLength(head);

       System.out.println(len);

       LinkedList firstHalfTail = getMiddleNode(head, len);

        System.out.println(firstHalfTail.value);

        LinkedList middlenode = null;
        LinkedList seconHalfHead = null;

        if(len % 2 ==0){
            seconHalfHead = firstHalfTail.next;
        }
        else{
            middlenode = firstHalfTail.next;
            seconHalfHead = middlenode.next;
        }

        firstHalfTail.next = null;
        reverse(head);
        LinkedList reversedSeconHalfHead = reverse(seconHalfHead);

        if (middlenode == null) {
            head.next = reversedSeconHalfHead;
        }
        else{
            head.next = middlenode;
            middlenode.next = reversedSeconHalfHead;
        }


        return firstHalfTail;
    }

    private static LinkedList getMiddleNode(LinkedList head, int len) {
        int currPos =1;
        LinkedList curr = head;
        while(currPos < len/2){
            currPos++;
            curr = curr.next;
        }

        return curr;
    }

    public static int getLinkedListLength(LinkedList head){
        int len =0;
        while(head != null){
            len++;
            head = head.next;
        }

        return len;
    }

    public static LinkedList reverse(LinkedList head){
        LinkedList prev = null;
        LinkedList curr = head;
        LinkedList next = null;
        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;

    }

    static class LinkedList {
        int value;
        LinkedList next = null;

        public LinkedList(int value) {
            this.value = value;
        }
    }
}
