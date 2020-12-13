package AlgoExpert.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class DiskStacking {
    public static void main(String[] args) {
        List<Integer[]> disks = new ArrayList<>();
        disks.add(new Integer[]{2, 1, 2});
        disks.add(new Integer[]{3, 2, 3});
        disks.add(new Integer[]{2, 2, 8});
        disks.add(new Integer[]{2, 3, 4});
        disks.add(new Integer[]{1, 3, 1});
        disks.add(new Integer[]{4, 4, 5});


        diskStacking(disks).forEach(k -> System.out.println(Arrays.toString(k)));

    }

    public static List<Integer[]> diskStacking(List<Integer[]> disks) {


        disks.sort(Comparator.comparing(disk -> disk[2]));

//        disks.forEach(k -> System.out.println(Arrays.toString(k)));

        int[] heights = new int[disks.size()];

        for (int i = 0; i < disks.size(); i++) {
            heights[i] = disks.get(i)[2];
        }

//        System.out.println(Arrays.toString(heights));

        int[] sequences = new int[disks.size()];

        for (int i = 0; i < disks.size(); i++) {
            sequences[i] = Integer.MIN_VALUE;
        }
        int minHeightIdx = 0;
        for (int i = 0; i < disks.size(); i++) {
            Integer[] currentDisk = disks.get(i);
            for (int j = 0; j < i; j++) {
                Integer[] otherDisk = disks.get(j);
                if (areValidDimensions(currentDisk, otherDisk)) {
                    if (heights[i]<= currentDisk[2]) {
                        heights[i] = currentDisk[2] + heights[j];
                        sequences[i]=j;
                    }
                }
            }
            if(heights[i] >= heights[minHeightIdx]){
                minHeightIdx =i;
            }
        }
        System.out.println(Arrays.toString(heights));
        System.out.println(Arrays.toString(sequences));
        System.out.println(minHeightIdx);

//        return buildSequence(disks, sequences, minHeightIdx);
        return disks;
    }

    private static List<Integer[]> buildSequence(List<Integer[]> disks, int[] sequences, int currentIdx) {

        return null;
    }

    private static boolean areValidDimensions(Integer[] currentDisk, Integer[] otherDisk) {

        return otherDisk[0] < currentDisk[0] && otherDisk[1] < currentDisk[1] && otherDisk[2] < currentDisk[2];
    }
}
