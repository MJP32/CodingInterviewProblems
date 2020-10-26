package Grokking.CH15_TopologicalSort;

import java.util.*;

class GK1_TopologicalSort {
    public static List<Integer> sort(int vertices, int[][] edges) {
        List<Integer> sortedOrder = new ArrayList<>();

        /*
            0 2   ->  0 1   -> 0 0
            1 1             -> 1 0
            2 1   ->  2 0
            3 0

            0 []
            1 []
            2 [0 1]
            3 [0 2]


            q =
            ans = 3 2 0 1
        */

        int[] depCount = new int[vertices];
        Map<Integer, List<Integer>> dependencies = new HashMap<>();

        for (int[] arr: edges) {

            if(!dependencies.containsKey(arr[0])){
                dependencies.put(arr[0], new ArrayList<>());
            }
            dependencies.get(arr[0]).add(arr[1]);
            depCount[arr[1]]++;
        }

//        System.out.println(Arrays.toString(depCount));
        //dependencies.forEach((k, v)-> System.out.println(k+ " "+v));

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < depCount.length; i++) {
            if (depCount[i] == 0 ){
                queue.add(i);
            }
        }

        while (!queue.isEmpty()) {
            int job = queue.poll();

            sortedOrder.add(job);

            List<Integer> children = dependencies.get(job);

            if(children == null)
                continue;
            for (Integer child : children) {
                depCount[child]--;

                if(depCount[child] ==0){
                    queue.add(child);
                }
            }

        }


        return sortedOrder.size()==vertices?sortedOrder:null;
    }

    public static void main(String[] args) {
        List<Integer> result = GK1_TopologicalSort.sort(4,
                new int[][] {
                        new int[] { 3, 2 },
                        new int[] { 3, 0 },
                        new int[] { 2, 0 },
                        new int[] { 2, 1 }
                });
        System.out.println(result);
/*
        result = GK1_TopologicalSort.sort(5, new int[][] { new int[] { 4, 2 }, new int[] { 4, 3 }, new int[] { 2, 0 },
                new int[] { 2, 1 }, new int[] { 3, 1 } });
        System.out.println(result);

        result = GK1_TopologicalSort.sort(7, new int[][] { new int[] { 6, 4 }, new int[] { 6, 2 }, new int[] { 5, 3 },
                new int[] { 5, 4 }, new int[] { 3, 0 }, new int[] { 3, 1 }, new int[] { 3, 2 }, new int[] { 4, 1 } });
        System.out.println(result);*/
    }
}