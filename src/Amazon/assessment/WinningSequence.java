package Amazon.assessment;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WinningSequence {
    public static void main(String[] args) {
        System.out.println(winningSequence(3, 9, 10));
        System.out.println(winningSequence(4, 8, 10));
        System.out.println(winningSequence(5, 7, 10)); // 7
        System.out.println(winningSequence(6, 6, 10)); // 6
        System.out.println(winningSequence(7, 5, 10)); // 5
        System.out.println(winningSequence(5, 7, 10)); // [9, 10, 9, 8, 7]
        System.out.println(winningSequence(6, 6, 10));
        System.out.println(winningSequence(5, 8, 10)); // [8, 9, 10, 9, 8]
        System.out.println(winningSequence(6, 8, 10)); // [-1]
        System.out.println(winningSequence(6, 7, 10));
    }
    public static List<Integer> winningSequence(int num, int lowerEnd, int upperEnd) {
        if (upperEnd - lowerEnd < num / 2) return Collections.singletonList(-1);
        List<Integer> winningSequence = new ArrayList<>(num);

        int peakIndex = 1;
        while (peakIndex < num && num - 1 - peakIndex > upperEnd - lowerEnd) {
            peakIndex++;
        }

        int val = upperEnd - peakIndex;

        for (int i = 0; i < num; i++) {
            winningSequence.add(val);
            if (i < peakIndex) {
                val++;
            } else {
                val--;
            }
        }

        return winningSequence;
    }


}
