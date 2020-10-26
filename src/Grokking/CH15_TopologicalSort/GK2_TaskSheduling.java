package Grokking.CH15_TopologicalSort;

import java.util.*;

public class GK2_TaskSheduling {
    public static boolean isSchedulingPossible(int tasks, int[][] prerequisites) {
        /*
            0 0
            1 0
            2 1
            3 1
            4 2
            5 2

            0 [5, 4]
            1 [3, 4]
            2 [5]
            3 [2]
            4 []
            5 []

            0,1, 4, 3,2, 5

        */


        Map<Integer, Integer> depCount = new HashMap<>();
        Map<Integer, List<Integer>> dependenciesa = new HashMap<>();

        for (int i = 0; i < tasks; i++) {
            depCount.put(i,0);
            dependenciesa.put(i, new ArrayList<>());
        }


        for (int[] arr : prerequisites) {
            int parent = arr[0];
            int child = arr[1];

            depCount.put(child,depCount.get(child)+1);
            dependenciesa.get(parent).add(child);
        }
//        depCount.forEach((k,v) -> System.out.println(k+" "+v));
//        dependenciesa.forEach((k,v) -> System.out.println(k+" "+v));


        Queue<Integer> queue = new LinkedList<>();
        for (Map.Entry<Integer, Integer> entry :depCount.entrySet()){
            if(entry.getValue() ==0){
                queue.add(entry.getKey());
            }
        }

        List<Integer> sorted = new ArrayList<>();
        while(!queue.isEmpty()){
            int num = queue.poll();
            sorted.add(num);
            List<Integer> children = dependenciesa.get(num);
            for (Integer child : children) {
                depCount.put(child, depCount.get(child)-1);
                if(depCount.get(child) ==0 ){
                    queue.add(child);
                }
            }

        }

        //sorted.forEach(k-> System.out.println(k));

        return sorted.size()==tasks;
    }

    public static void main(String[] args) {

        boolean result = GK2_TaskSheduling.isSchedulingPossible(3,
                new int[][] {
                        new int[] { 0, 1 },
                        new int[] { 1, 2 }
                        });
        System.out.println("Tasks execution possible: " + result);

        result = GK2_TaskSheduling.isSchedulingPossible(3,
                new int[][] {
                    new int[] { 0, 1 },
                    new int[] { 1, 2 },
                    new int[] { 2, 0 }
                });
        System.out.println("Tasks execution possible: " + result);

        result = GK2_TaskSheduling.isSchedulingPossible(6,
                new int[][] {
                    new int[] { 2, 5 },
                    new int[] { 0, 5 },
                    new int[] { 0, 4 },
                    new int[] { 1, 4 },
                    new int[] { 3, 2 },
                    new int[] { 1, 3 }
                });
        System.out.println("Tasks execution possible: " + result);
    }
}
