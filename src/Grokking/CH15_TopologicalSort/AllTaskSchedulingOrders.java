package Grokking.CH15_TopologicalSort;

import java.util.*;

public class AllTaskSchedulingOrders {

    public static void printOrders(int tasks, int[][] prerequisites) {
        /*
            2 5
            0 5
            0 4
            1 4
            3 2
            1 3

            0 0
            1 0
            2 1
            3 1
            4 2
            5 2

            0 [5,4]
            1 [3,4]
            2 [5]
            3 [2]
            4 []
            5 []


        */

        HashMap<Integer,Integer> depCount = new HashMap<>();
        HashMap<Integer,List<Integer>> dependencies = new HashMap<>();

        for (int i = 0; i < tasks; i++) {
            depCount.put(i, 0);
            dependencies.put(i, new ArrayList<>());

        }

        for (int i = 0; i < tasks; i++) {
            int parent = prerequisites[i][0];
            int child = prerequisites[i][1];
            System.out.println(parent + " -> " + child );

            dependencies.get(parent).add(child);
            depCount.put(child, depCount.get(child) +1);
        }
        Queue<Integer> queue = new LinkedList<>();

        for(Map.Entry<Integer,Integer> entry : depCount.entrySet()){
            if (entry.getValue() == 0) {
                queue.add(entry.getKey());
            }
        }
        List<Integer> sortedOrder = new ArrayList<>();
        queue.forEach(k-> System.out.println(k));
        printAllTopologies(dependencies, depCount, queue, sortedOrder  );
    }

    private static void printAllTopologies(HashMap<Integer, List<Integer>> dependencies, HashMap<Integer, Integer> depCount, Queue<Integer> queue, List<Integer> sortedOrder) {
        if (!queue.isEmpty()){
            for (Integer vertex : queue){
                sortedOrder.add(vertex);
                Queue<Integer> sourcesForNextCall = cloneQueue(queue);
                sourcesForNextCall.remove(vertex);
                List<Integer> children = dependencies.get(vertex);
                for (int child : children){
                    depCount.put(child, depCount.get(child)-1);
                    if (depCount.get(child) ==0) {
                        sourcesForNextCall.add(child);
                    }
                }
                printAllTopologies(dependencies, depCount, sourcesForNextCall, sortedOrder);
                sortedOrder.remove(vertex);
                for (int child : children) {
                    depCount.put(child, depCount.get(child)+1);
                }
            }
        }
        if(sortedOrder.size() == depCount.size()){
            System.out.println(sortedOrder);
        }

    }

    public static Queue<Integer> cloneQueue(Queue<Integer> queue){
        Queue<Integer> clone = new LinkedList<>();
        for(Integer num : queue){
            clone.add(num);
        }
        return clone;
    }
    public static void main(String[] args) {
//        AllTaskSchedulingOrders.printOrders(3, new int[][]{new int[]{0, 1}, new int[]{1, 2}});
//        System.out.println();
//
//        AllTaskSchedulingOrders.printOrders(4,
//                new int[][]{new int[]{3, 2}, new int[]{3, 0}, new int[]{2, 0}, new int[]{2, 1}});
//        System.out.println();

        AllTaskSchedulingOrders.printOrders(6, new int[][]{new int[]{2, 5}, new int[]{0, 5}, new int[]{0, 4},
                new int[]{1, 4}, new int[]{3, 2}, new int[]{1, 3}});
        System.out.println();
    }
}