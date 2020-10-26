package Leetcode.pattern.backtracking;

import java.util.LinkedList;
import java.util.List;

public class LC77_Combinations {
    public static void main(String[] args) {

        new LC77_Combinations().combine(4,2).forEach(k-> System.out.println(k));
    }
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> results = new LinkedList();
        combine(1,n,k, new LinkedList<>(), results);
        return results;
    }

    private void combine(int start, int end, int k, LinkedList<Integer> path, List<List<Integer>> results) {

        if(path.size() ==k){
            results.add(new LinkedList<>(path));
        }

        for (int i = start; i < end+1; i++) {
            path.add(i);
            combine(i+1, end, k, path, results);
            path.removeLast();

        }
    }
}
