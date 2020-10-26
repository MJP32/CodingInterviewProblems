package AlgoExpert.assessment;


public class ReverseAlternatingNodes {
    public static void main(String[] args) {
        LinkedList node1 = new LinkedList(1);
        LinkedList node2 = new LinkedList(2);
        LinkedList node3 = new LinkedList(3);
        LinkedList node4 = new LinkedList(4);
        LinkedList node5 = new LinkedList(5);
        LinkedList node6 = new LinkedList(6);
        LinkedList node7 = new LinkedList(7);
        LinkedList node8 = new LinkedList(8);
        LinkedList node9 = new LinkedList(9);
        LinkedList node10 = new LinkedList(10);
        LinkedList node11 = new LinkedList(11);
        LinkedList node12 = new LinkedList(12);
        LinkedList node13 = new LinkedList(13);
        LinkedList node14 = new LinkedList(14);
        //LinkedList node14 = new LinkedList(14);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        node7.next = node8;
        node8.next = node9;
        node9.next = node10;
        node10.next = node11;
        node11.next = node12;
        node12.next = node13;
        node13.next = node14;
        node14.next = null;

        ReverseAlternatingNodes ran = new ReverseAlternatingNodes();
        LinkedList head = ran.reverseKGroup(node1, 3);

        while (head != null) {
            System.out.print(head.value + " ");
            head = head.next;
        }

    }

    public LinkedList reverseKGroup(LinkedList head, int k) {

        LinkedList root = new LinkedList(0);
        LinkedList curr = head;
        LinkedList prev = root;

        while (curr != null) {
            int listIndex = 0;
            LinkedList tail = curr;
            while (curr != null && listIndex < k) {
                curr = curr.next;
                listIndex++;
            }

            prev.next = reverse(tail, k);
            prev = tail;

            prev.next = curr;
            while (curr != null && listIndex > 0) {
                curr = curr.next;
                prev = prev.next;
                listIndex--;
            }
        }

        return root.next;
    }

    public LinkedList reverse(LinkedList head, int m) {
        LinkedList prev = null;
        LinkedList curr = head;
        LinkedList next = null;
        while (curr != null && m > 0) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            m--;
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
