package Leetcode.topic.stg.submit;

import java.util.ArrayList;
import java.util.List;

public class LC254_FactorCombinations {
    public static void main(String[] args) {
        new LC254_FactorCombinations().getFactors(32).forEach(k-> System.out.println(k));
    }

    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> results = new ArrayList<>();
        getFactorsHelper(n,2, new ArrayList<>(), results);
        return results;
    }

    private void getFactorsHelper(int n, int index, List<Integer> path, List<List<Integer>> results) {
        List<Integer> temp = new ArrayList<>(path);
        if(temp.size() >0){
            temp.add(n);
            results.add(temp);
        }

        for (int i = index; i *i <=n ; i++) {
            if (n % i ==0) {
                path.add(i);
                getFactorsHelper(n/i, i,path, results);
                path.remove(path.size()-1);
            }
        }

    }
}
