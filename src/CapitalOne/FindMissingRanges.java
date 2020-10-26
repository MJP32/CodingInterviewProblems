package CapitalOne;

import java.util.ArrayList;
import java.util.List;

public class FindMissingRanges {
    public static void main(String[] args) {
        new FindMissingRanges().findMissingRanges(new int[]{0, 1, 3, 50, 75}, 0, 99).forEach(k -> System.out.println(k));
    }

    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> result = new ArrayList<>();

        int start = lower;
        for (int num : nums) {
            if (start == num) {
                start = num + 1;
            } else {
                int end = num - 1;

                if (start == end) {
                    result.add(start + "");
                } else {
                    result.add(start + "->" + end);
                }
                start = num + 1;
            }
        }
        if (start == upper) {

            result.add(start + "");
        }
        else {
            result.add(start + "->" + upper);
        }

        return result;

    }
}
