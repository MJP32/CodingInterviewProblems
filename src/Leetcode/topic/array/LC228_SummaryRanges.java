package Leetcode.topic.array;

import java.util.ArrayList;
import java.util.List;

public class LC228_SummaryRanges {
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
        int n = nums.length;
        if (nums == null || n == 0)
            return result;

        for (int i = 0; i < n; i++) {
            int start = nums[i];
            while (i + 1 < n && nums[i] + 1 == nums[i + 1]) {
                i++;
            }

            if (nums[i] != start) {
                result.add(String.format("%d->%d", start, nums[i]));
            } else {
                result.add(String.valueOf(start));
            }
        }

        return result;
    }
}
