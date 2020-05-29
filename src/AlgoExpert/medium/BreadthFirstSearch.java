package AlgoExpert.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstSearch {


    public static void main(String[] args) {
        //Node node = new Node();
        //node.breadthFirstSearch();
    }
    static class Node{
        String name;
        ArrayList<Node> children = new ArrayList<Node>();

        public Node(String name) {
            this.name = name;
        }

        public ArrayList<String> breadthFirstSearch(ArrayList<String> array) {
            ArrayList<String> result = new ArrayList<>();

            Queue<Node> queue = new LinkedList<>();
            queue.add(this);
            while (!queue.isEmpty()) {
                Node current = queue.poll();


            }

            return result;
        }


        public Node addChild(String name) {
            Node child = new Node(name);
            children.add(child);
            return this;
        }
    }
}
