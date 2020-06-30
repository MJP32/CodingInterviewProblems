package Leetcode.topic.trees;

import Leetcode.common.Node;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LC429_NaryTreeLevelOrderTraversal {
    public static void main(String[] args) {
        Node one = new Node(1);
        Node three = new Node(3);
        Node two = new Node(2);
        Node four = new Node(4);
        Node five = new Node(5);
        Node six = new Node(6);

        //three.children = five;
        //three.children = six;
        List<Node> list = new ArrayList<>();
        list.add(three);
        list.add(two);
        list.add(four);

        one.children = list;

        //one.children.get(1).val = five;
        new LC429_NaryTreeLevelOrderTraversal().levelOrder(one).forEach(k-> System.out.println(k));
    }
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> all = new ArrayList<>();

        if(root == null){
            return all;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        List<Integer> level =null;
        while(!queue.isEmpty()){

            int size = queue.size();
            level = new ArrayList<>();
            for(int i =0; i < size; i++){
                Node node = queue.poll();


                level.add(node.val);

                for(Node child: node.children){
                    queue.add(child);
                }



            }
            all.add(level);

        }

        return all;
    }
}
