package AlgoExpert.assessment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RepeatedMatrixValues {
    public static void main(String[] args) {

        ArrayList<ArrayList<Integer> > aList =
                new ArrayList<ArrayList<Integer> >();

        // Create n lists one by one and append to the
        // master list (ArrayList of ArrayList)
        ArrayList<Integer> a1 = new ArrayList<Integer>();
        a1.add(1);
        a1.add(3);
        a1.add(7);
        a1.add(4);
        a1.add(5);
        aList.add(a1);

        ArrayList<Integer> a2 = new ArrayList<Integer>();
        a2.add(2);
        a2.add(5);
        a2.add(9);
        a2.add(3);
        a2.add(3);
        aList.add(a2);

        ArrayList<Integer> a3 = new ArrayList<Integer>();
        a3.add(1);
        a3.add(8);
        a3.add(5);
        a3.add(3);
        a3.add(5);
        aList.add(a3);

        ArrayList<Integer> a4 = new ArrayList<Integer>();
        a4.add(3);
        a4.add(8);
        a4.add(3);
        a4.add(5);
        a4.add(6);
        aList.add(a4);

        ArrayList<Integer> a5 = new ArrayList<Integer>();
        a5.add(1);
        a5.add(0);
        a5.add(3);
        a5.add(0);
        a5.add(5);
        aList.add(a5);

        repeatedMatrixValues(aList);

    }
    public static List<Integer> repeatedMatrixValues(ArrayList<ArrayList<Integer>> matrix) {

        Map<Integer, Integer> valueCOunts = initializeCountOfPotentialValues(matrix);

        valueCOunts.forEach((k, v) -> System.out.println(k+" "+v));

        for(int  i =0; i < matrix.size();i++){
            for (int j = 0; j < matrix.get(0).size(); j++) {
                int value = matrix.get(i).get(j);

            }

        }


        return new ArrayList<Integer>();
    }

    private static Map<Integer, Integer> initializeCountOfPotentialValues(ArrayList<ArrayList<Integer>> matrix) {

        Map<Integer, Integer> valueCounts = new HashMap<>();

        ArrayList<Integer> smallerSize = matrix.get(0);


        if(matrix.size() < matrix.get(0).size()){
            smallerSize = new ArrayList<Integer>();
            for (ArrayList<Integer> arr :matrix) {
                smallerSize.add(arr.get(0));
            }

        }
        for(Integer value : smallerSize){
            valueCounts.put(value,0);
        }
        return valueCounts;
    }
}
