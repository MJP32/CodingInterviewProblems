package AlgoExpert.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Knapsack {
    public static void main(String[] args) {

        int[][] items = new int[][]{{1,2},{4,3},{5,6},{6,7}};
        System.out.println(knapsackProblem(items, 10));
    }
    public static List<List<Integer>> knapsackProblem(int[][] items, int capacity) {
        List<List<Integer>> results = new ArrayList<>();
        int[][] knap = new int[items.length+1][capacity+1];

        for (int i = 1; i < items.length+1; i++) {

            int currentValue = items[i-1][0];
            int currentweight = items[i-1][1];
            for (int j = 0; j < capacity +1; j++) {
                if(currentweight > j){
                    knap[i][j] =  knap[i-1][j];
                }
                else{
                    knap[i][j] = Math.max(knap[i-1][j], knap[i-1][j-currentweight]+currentValue);
                }

            }

        }
        for(int[] arr :knap){

            System.out.println(Arrays.toString(arr));
        }
//return results;
        return getItems(knap, items, capacity);
    }

    public static List<List<Integer>> getItems(int[][] knap, int[][] items, int capacity){

        List<List<Integer>> sequence = new ArrayList<>();
        List<Integer> totalWeight = new ArrayList<>();
        totalWeight.add(capacity);
        sequence.add(totalWeight);
        sequence.add(new ArrayList<>());

        int i = knap.length-1;
        int c = knap[0].length-1;
        while(i> 0){
            if (knap[i][c] == knap[i-1][c]) {
                i--;
            }
            else{
                sequence.get(1).add( i-1);
                c -=items[i-1][1];
                i--;
            }
            if(c==0)
                break;

        }
        return sequence;


    }
}
