package Leetcode.zap.todo.submit;

import java.util.ArrayList;
import java.util.List;

public class LC118_PascalsTriangle {
    public static void main(String[] args) {
        LC118_PascalsTriangle lc118 = new LC118_PascalsTriangle();
        lc118.generate(5).forEach(k-> System.out.println(k));

    }
    public List<List<Integer>> generate(int numRows) {

        List<List<Integer>> triangle = new ArrayList<>();

        if(numRows==0){
            return triangle;
        }

        List<Integer> first = new ArrayList<>();
        first.add(1);
        triangle.add(first);

        for (int i = 1; i < numRows; i++) {

            List<Integer> prevRow = triangle.get(i-1);
            List<Integer> curr = new ArrayList<>();


            curr.add(1);


            for (int j = 1; j < i; j++) {
                curr.add(prevRow.get(j-1)+prevRow.get(j));
            }

            curr.add(1);
            triangle.add(curr);
        }

        return triangle;
    }
}
