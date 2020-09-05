package Leetcode.topic.dfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LC279_PerfectSquares {
    static int min =Integer.MAX_VALUE;
    public static void main(String[] args) {
        System.out.println(new LC279_PerfectSquares().numSquares(12));
        System.out.println(new LC279_PerfectSquares().numSquares(13));

        System.out.println("min = "+ min);
    }
    public int numSquares(int n) {

        List<Integer> squares = new ArrayList<>();
        for (int i = 2; i < n; i++) {
            int squared = i *i;
            if (squared < n){
                squares.add(i);
            }
        }

        List<List<Integer>> results = new ArrayList<>();
        int[] squaresArr = new int[squares.size()];
        for(int i =0; i <  squares.size();i++){
            squaresArr[i] = squares.get(i);
        }
        numSquares( squaresArr,n,0,new LinkedList<Integer>(), results);
        results.forEach(k-> System.out.println(k));

        return 123;
    }

    private void numSquares(int[] arr, int target, int i, List<Integer> path, List<List<Integer>> results) {
        if(target < 0){
            return ;
        }
        if (target==0) {
            results.add(new LinkedList<Integer>(path));
            min = Math.min(min, path.size());
            return ;
        }
        if(i == arr.length)
            return ;
        path.add(arr[i]);
        numSquares(arr, target-arr[i], i, path, results);
        path.remove(path.size()-1);
        numSquares(arr, target,i+1, path, results);

    }
}
