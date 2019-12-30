package Leetcode.zap.todo.review;

import java.util.ArrayList;
import java.util.List;

public class LC78_Subsets {
    public static void main(String[] args) {
        LC78_Subsets lc78 = new LC78_Subsets();

        lc78.subsets(new int[]{1,2,3}).forEach(k-> System.out.println(k));
    }

    public List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> results = new ArrayList<>();
        generateSubsets(0,nums, new ArrayList<>(), results);
        return results;

    }

    private void generateSubsets(int index, int[] nums, List<Integer> current, List<List<Integer>> results) {

        results.add(new ArrayList<>(current));
        for (int i = index; i < nums.length; i++) {
            current.add(nums[i]);

            generateSubsets(i+1,nums, current,results);
            current.remove(current.size()-1);

        }
    }
}
