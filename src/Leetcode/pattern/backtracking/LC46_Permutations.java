package Leetcode.pattern.backtracking;

import java.util.ArrayList;
import java.util.List;

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
public class LC46_Permutations {
    public static void main(String[] args) {
        LC46_Permutations lc46 = new LC46_Permutations();
        lc46.permute(new int[]{1, 1,2,3}).forEach(k-> System.out.println(k));

    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        if (nums.length == 0) {
            return results;
        }

        collectPermutations(nums, 0, new ArrayList<>(), results);
        return results;
    }

    private void collectPermutations(int[] nums, int start, List<Integer> current,
                                     List<List<Integer>>  results) {

        if (current.size() == nums.length) {
            results.add(current);
            return;
        }

        for (int i = 0; i <= current.size(); i++) {
            List<Integer> newPermutation = new ArrayList<>(current);
            newPermutation.add(i, nums[start]);
            collectPermutations(nums, start + 1, newPermutation, results);
        }
    }


}
