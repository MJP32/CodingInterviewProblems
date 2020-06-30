package AlgoExpert.linkedlist;

public class RemoveKthNodeFromEnd {
    public static void main(String[] args) {
        LinkedList l1= new LinkedList(1);
        LinkedList l2= new LinkedList(2);
        LinkedList l3= new LinkedList(3);
        LinkedList l4= new LinkedList(4);
        LinkedList l5= new LinkedList(5);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = null;

        removeKthNodeFromEnd(l1, 4);

        while (l1 != null) {
            System.out.println(l1.value);
            l1= l1.next;
        }


    }
    public static void removeKthNodeFromEnd(LinkedList head, int k) {
        // Write your code here.
        LinkedList copy = head;
        while (k > 0) {
            copy = copy.next;
            k--;
        }

        while(copy != null){
            head = head.next;
            copy = copy.next;



        }





    }

    static class LinkedList {
        int value;
        LinkedList next = null;

        public LinkedList(int value) {
            this.value = value;
        }
    }
}
