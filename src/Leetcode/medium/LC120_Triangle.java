package Leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class LC120_Triangle {
    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        List<Integer> list3 = new ArrayList<>();
        //List<Integer> list4 = new ArrayList<>();

        list1.add(-1);
        list2.add(2);
        list2.add(3);
        list3.add(1);
        list3.add(-1);
        list3.add(-1);
        //list4.add(4);
        //list4.add(1);
        //list4.add(8);
        //list4.add(3);

        List<List<Integer>> triangle = new ArrayList<>();

        triangle.add(list1);
        triangle.add(list2);
        triangle.add(list3);
        //triangle.add(list4);


        System.out.println(new LC120_Triangle().minimumTotal(triangle));
    }

    public int minimumTotal(List<List<Integer>> triangle) {

//        System.out.println(Arrays.toString(triangle.toArray()));

        /*int idx = 0;
        int sum = 0;
        for (int i = 0; i < triangle.size(); i++) {

            if(i==0){
                sum += triangle.get(i).get(i);
            }
            else if(triangle.get(i).get(idx) < triangle.get(i).get(idx + 1)){
                sum += triangle.get(i).get(idx);
            }

            else{
                sum += triangle.get(i).get(idx+1);
                idx++;
            }

            //System.out.println(sum);

        }

        return sum;*/


        int[] A = new int[triangle.size()+1];
        for(int i=triangle.size()-1;i>=0;i--){
            for(int j=0;j<triangle.get(i).size();j++){
                A[j] = Math.min(A[j],A[j+1])+triangle.get(i).get(j);
            }
        }
        return A[0];
    }

}
