package FB;


public class ReverseOperations {
    public static void main(String[] args) {
        Node one = new Node(1);
        Node two = new Node(2);
        Node eight = new Node(8);
        Node ten = new Node(10);
        Node nine = new Node(9);
        Node twelve = new Node(12);
        Node sixteen = new Node(16);
        one.next = two;
        two.next = eight;
        eight.next = ten;
        ten.next = nine;
        nine.next = twelve;
        twelve.next = sixteen;
        sixteen.next = null;
        Node list = new ReverseOperations().reverse(one);

        //Node list = new ReverseOperations().reverseBetween(one, 2, 4);
        while (list != null) {
            System.out.println(list.data);
            list = list.next;
        }
    }
    static Node reverse(Node head)
    {
        return reverse(head, null);
    }

    // Recursive function to reverse the consecutive 
// even Nodes of the linked list 
    static Node reverse(Node head, Node prev)
    {

        // Base case 
        if (head == null)
            return null;

        Node temp;
        Node curr;
        curr = head;

        // Reversing Nodes until curr Node's value 
        // turn odd or Linked list is fully traversed 
        while (curr != null && curr.data % 2 == 0)
        {
            temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }

        // If elements were reversed then head 
        // pointer needs to be changed 
        if (curr != head)
        {
            head.next = curr;

            // Recur for the remaining linked list 
            curr = reverse(curr, null);
            return prev;
        }

        // Simply iterate over the odd value Nodes 
        else
        {
            head.next = reverse(head.next, head);
            return head;
        }
    }


    static class Node {
        int data;
        Node next;

        Node(int x) {
            data = x;
            next = null;
        }
    }
}
