package AlgoExpert.graph;

import java.util.*;

public class TopologicalSort {
    public static List<Integer> topologicalSort(List<Integer> jobs, List<Integer[]> deps) {
        Map<Integer, Integer> depCount = new HashMap<>();
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i : jobs){
            depCount.put(i, 0 );
        }


        for(Integer[] dep : deps){
            map.putIfAbsent(dep[0], new ArrayList<>());


            map.get(dep[0]).add(dep[1]);
            depCount.put(dep[1], depCount.getOrDefault(dep[1], 0) +1);

        }

        map.forEach((k,v)-> System.out.println(k+" " + v));
        depCount.forEach((k,v)-> System.out.println(k+" " + v));

        Queue<Integer> queue = new LinkedList<>();

        for(Map.Entry<Integer, Integer> entry: depCount.entrySet()){
            if(entry.getValue()==0){
                queue.add(entry.getKey());
            }
        }
        for(Integer i : queue){
            System.out.println(i);
        }

        return new ArrayList<Integer>();
    }
}
