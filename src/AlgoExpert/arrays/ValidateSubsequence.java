package AlgoExpert.arrays;

import java.util.Arrays;
import java.util.List;

public class ValidateSubsequence {
    public static void main(String[] args) {



        System.out.println(isValidSubsequence(Arrays.asList(new Integer[]{5, 1, 22, 25, 6, -1, 8, 10}),  Arrays.asList(new Integer[]{1, 6, -1, 10})));


    }
    public static boolean isValidSubsequence(List<Integer> array, List<Integer> sequence) {
        int arrIdx = 0;
        int seqIdx = 0;
        while (arrIdx < array.size() && seqIdx < sequence.size()) {
            if (sequence.get(seqIdx) == array.get(arrIdx)) {
                seqIdx++;
            }
            arrIdx++;
        }
        return seqIdx == sequence.size();
    }

}
