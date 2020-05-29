package AlgoExpert.easy;

public class DoublyLinkedList {
    public Node head;
    public Node tail;
    public static void main(String[] args) {
        Node l1_1 = new Node(1);
        Node l1_2 = new Node(2);
        Node l1_3 = new Node(3);
        Node l1_4 = new Node(4);
        Node l1_5 = new Node(5);
        l1_1.next = l1_2;
        l1_2.next = l1_3;
        l1_3.next = l1_4;
        l1_4.next = l1_5;
        l1_5.next = null;

        l1_1.prev = null;
        l1_2.prev = l1_1;
        l1_3.prev = l1_2;
        l1_4.prev = l1_3;
        l1_5.prev = l1_4;

        DoublyLinkedList dll = new DoublyLinkedList();
        dll.head = l1_1;
        dll.tail = l1_5;


        System.out.println(dll.containsNodeWithValue(3));
        System.out.println(dll.containsNodeWithValue(9));

        dll.insertBefore(new Node(3),new Node(8));
        //dll.remove(new Node(3));
        dll.print();


    }
    public void setHead(Node node) {
        if(head == null){
            head = node;
            tail = node;
            return;
        }
        insertBefore(head, node);


        
    }

    public void setTail(Node node) {
        
    }

    public void insertBefore(Node node, Node nodeToInsert) {
        if(nodeToInsert == head && nodeToInsert == tail)
         return;

        remove(nodeToInsert);

        nodeToInsert.prev = node.prev;
        nodeToInsert.next = node;
        if (node.prev == null) {
            head = nodeToInsert;
        }
        else{
            node.prev.next = nodeToInsert;
        }
        node.prev = nodeToInsert;
    }

    public void insertAfter(Node node, Node nodeToInsert) {
        
    }

    public void insertAtPosition(int position, Node nodeToInsert) {
        
    }

    public void removeNodesWithValue(int value) {
        
    }

    public void remove(Node node) {
        if(node == head){
            head = head.next;
        }
        if(node == tail){
            tail = tail.prev;
        }
        removeBindings( node);

    }

    public boolean containsNodeWithValue(int value) {
        Node node = head;
        while(node != null) {
            if (node.value == value) {
                return true;
            }
            node = node.next;
        }
        return false;
    }
    public void removeBindings(Node node){
        if(node.prev != null ){
            node.prev.next = node.next;
        }
        if (node.next != null) {
            node.next.prev = node.prev;
        }
        node.prev = null;
        node.next =null;
    }


    public void print() {

        while(head != null){
            System.out.println(head.value);
            head = head.next;
        }

    }
}



// Do not edit the class below.
 class Node {
    public int value;
    public Node prev;
    public Node next;

    public Node(int value) {
        this.value = value;
    }
}


