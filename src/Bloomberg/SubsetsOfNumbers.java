package Bloomberg;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsOfNumbers {
    public static void main(String[] args) {

        System.out.println(subsets(Arrays.asList(1, 2, 3)));
    }

    public static List<List<Integer>> subsets(List<Integer> nums) {
        List<List<Integer>> result = new ArrayList<>();
        getSubsets(nums, new ArrayList<>(), result);
        return result;
    }

    public static void getSubsets(List<Integer> nums, List<Integer> curr, List<List<Integer>> result) {
        if (nums.size() == 0) {
            result.add(curr);
            return;
        }

        for (int i = 0; i < nums.size(); i++) {
            List<Integer> newArray = new ArrayList<>(nums);
            newArray.remove(i);
            List<Integer> newPermutation = new ArrayList<>(curr);
            newPermutation.add(nums.get(i));
            getSubsets(newArray, newPermutation, result);

        }


    }
}
