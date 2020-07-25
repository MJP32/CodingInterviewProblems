package Leetcode.topic.stg;

import Leetcode.common.Node;

import java.util.ArrayList;
import java.util.List;

public class LC590_NaryPostOrderTraversal {
    public static void main(String[] args) {





    }
    public List<Integer> postorder(Node root) {

        List<Integer> result = new ArrayList<>();

        if(root == null)
            return result;

        postorder(root, result);



        result.forEach(k-> System.out.println(k));
        return result;

    }

    private void postorder(Node root, List<Integer> result) {
        if(root.children != null){
            for(Node child: root.children){
                postorder(child, result);
            }
        }
        result.add(root.val);
    }
}
