package Leetcode.easy;

import java.util.ArrayList;
import java.util.List;

public class LC119_PascalTriangle2 {
    public static void main(String[] args) {
        LC119_PascalTriangle2 lc119 = new LC119_PascalTriangle2();
        lc119.getRow(5).forEach(k-> System.out.println(k));
    }
    public List<Integer> getRow(int rowIndex) {

        List<Integer> curr = new ArrayList<>();
        curr.add(1);
        for(int i =1;i<= rowIndex;i++){
            for(int j =i-1;j>= 1 ;j--){
                curr.set(j, curr.get(j-1) +curr.get(j));
            }
            curr.add(1);
        }
        return curr;
    }
}
