package Leetcode.topic.recursion;

import java.util.*;

/*
https://leetcode.com/problems/permutations/discuss/18436/Java-Clean-Code-Two-recursive-solutions



nums = 1,2,3

start = 0, permutation = []
i = 0, newPermutation = [1]
	start = 1, permutation = [1]
	i = 0, newPermutation = [2, 1]
		start = 2, permutation = [2, 1]
		i = 0, newPermutation = [3, 2, 1]
		i = 1, newPermutation = [2, 3, 1]
		i = 2, newPermutation = [2, 1, 3]
	i = 1, newPermutation = [1, 2]
		start = 2, permutation = [1, 2]
		i = 0, newPermutation = [3, 1, 2]
		i = 1, newPermutation = [1, 3, 2]
		i = 2, newPermutation = [1, 2, 3]






 */
public class LC46_Permutations2 {
    public static void main(String[] args) {
        LC46_Permutations2 lc46 = new LC46_Permutations2();
        lc46.permute(new int[]{1,2,3}).forEach(k-> System.out.println(k));


    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        Set<Integer> items = new HashSet<>();
        for(Integer i : nums){
            items.add(i);
        }

        permutations(items, nums, new ArrayList<>(), results);
        return results;

    }
    public void permutations(Set<Integer> items, int[] num, ArrayList<Integer> path, List<List<Integer>> results){

        if(path.size() == num.length){
            results.add(new LinkedList<Integer>(path));
            return;
        }
        for(Integer i: items.toArray(new Integer[]{})){
            items.remove(i);
            path.add(i);
            permutations(items,num, path, results);
            items.add(i);
            path.remove(path.size()-1);
        }

    }

}
