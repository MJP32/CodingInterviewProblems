package Leetcode.topic.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class LC40_CombinationSum2 {
    public static void main(String[] args) {

        /*
        Given a set of candidate numbers (candidates) (without duplicates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.

        The same repeated number may be chosen from candidates unlimited number of times.

        Note:

        All numbers (including target) will be positive integers.
        The solution set must not contain duplicate combinations.
        Example 1:

        Input: candidates = [2,3,6,7], target = 7,
        A solution set is:
        [
          [7],
          [2,2,3]
        ]
        Example 2:

        Input: candidates = [2,3,5], target = 8,
        A solution set is:
        [
          [2,2,2,2],
          [2,3,3],
          [3,5]
        ]



        */


        new LC40_CombinationSum2().combinationSum2(new int[]{10,1,2,7,6,1,5, 7}, 8).forEach(k -> System.out.println(k));
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> results = new ArrayList<>();
        Arrays.sort(candidates);
        combinationSumHelper(candidates, target, 0, new LinkedList<Integer>(),  results);
        return results;
    }

    public void combinationSumHelper(int[] candidates, int target, int index , LinkedList<Integer> path,
                                     List<List<Integer>> results){
        if(target < 0){
            return;
        }
        if(target ==0){
            results.add(new LinkedList<>(path));
            return;
        }

//        if(i==candidates.length){
//            return;
//        }

        for(int i=index; i<candidates.length; i++) {
            if (i == index || candidates[i] != candidates[i - 1]) {
                path.add(candidates[i]);
                combinationSumHelper(candidates, target - candidates[i], i + 1, path, results);
                path.remove(path.size() - 1);
                //combinationSumHelper(candidates, target, i + 1, path, results);
            }
        }
    }
}
