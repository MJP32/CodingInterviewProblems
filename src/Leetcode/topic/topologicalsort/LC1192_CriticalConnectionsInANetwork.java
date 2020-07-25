package Leetcode.topic.topologicalsort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC1192_CriticalConnectionsInANetwork {
    public static void main(String[] args) {


        List<List<Integer>> connections = new ArrayList<>();
        List<Integer> connection = new ArrayList<>();
        connections.add(Arrays.asList(0,1));
        connections.add(Arrays.asList(1,2));
        connections.add(Arrays.asList(2,0));
        connections.add(Arrays.asList(1,3));


        connections.forEach(k-> System.out.println(k));
        new LC1192_CriticalConnectionsInANetwork().criticalConnections(4, connections);

    }
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        /*
        0: 1
        1: 2,3
        2: 0
        3:



        0: 1
        1: 2
        2: 1
        3: 0  -> citical
          */

        int[] connectionCount = new int[connections.size()];
        for(List<Integer> connection : connections){
            connectionCount[connection.get(0)]++;
        }

        System.out.println(Arrays.toString(connectionCount));

        return connections;
    }

    class Pair{
        public int x;
        public int y;
        public Pair(int x, int y){
            this.x =x;
            this.y= y;
        }
    }
}
