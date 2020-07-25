package Leetcode.topic.stg;

import java.util.HashMap;
import java.util.Map;

public class LC138_CopyListWithRandomPointer {
    // Visited dictionary to hold old node reference as "key" and new node reference as the "value"
    HashMap<Node, Node> visited = new HashMap<Node, Node>();

    public static void main(String[] args) {

    }

    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }

    /*
      Our clone map. We map the original node to its clone.
      This is the key to the problem, from here all else
      is simple linear time iteration.
    */
        Map<Node, Node> cloneMap = new HashMap<Node, Node>();

        // 1st pass: Give all nodes their clone in the mapping.
        Node curr = head;
        while (curr != null) {
            cloneMap.put(curr, new Node(curr.val));
            curr = curr.next;
        }

    /*
      2nd pass.
      Reset the curr pointer to the head of the original list
      Give all clones their next and random pointer assignments.
      Our cloneMap lets us reach an original node's clone in
      O(1) time.
    */
        curr = head;
        while (curr != null) {
      /*
        cloneMap.get(curr).next -> Set the next of curr's clone to...
        cloneMap.get(curr.next) -> The clone of curr's next.
      */
            cloneMap.get(curr).next = cloneMap.get(curr.next);

      /*
        cloneMap.get(curr).random -> Set the random of curr's clone to...
        cloneMap.get(curr.random) -> The clone node that curr.random is pointing to.
      */
            cloneMap.get(curr).random = cloneMap.get(curr.random);

            curr = curr.next;
        }

        // Return the clone node of the head. This is the caller's access to the newly copied list.
        return cloneMap.get(head);
    }
    // Definition for a Node.
    class Node {
        public int val;
        public Node next;
        public Node random;

        public Node(int val) {
            this.val = val;
        }

        public Node(int _val, Node _next, Node _random) {
            val = _val;
            next = _next;
            random = _random;
        }
    }

}


