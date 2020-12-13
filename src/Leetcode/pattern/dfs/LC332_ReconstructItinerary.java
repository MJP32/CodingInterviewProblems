package Leetcode.pattern.dfs;

import java.util.*;

public class LC332_ReconstructItinerary {
    public static void main(String[] args) {
        List<List<String>> tickets = new ArrayList<>();
        tickets.add(Arrays.asList("MUC", "LHR"));
        tickets.add(Arrays.asList("JFK", "MUC"));
        tickets.add(Arrays.asList("SFO", "SJC"));
        tickets.add(Arrays.asList("LHR", "SFO"));


        new LC332_ReconstructItinerary().findItinerary(tickets).forEach(k-> System.out.println(k));
    }
    public List<String> findItinerary(List<List<String>> tickets) {
        List<String> result = new ArrayList<>();
        Map<String, PriorityQueue<String>> graph = new HashMap<>();
        buildGraph(tickets, graph);
        graph.forEach((k,v)-> System.out.println(k+": "+v));

        Stack<String> st = new Stack<>();
        dfs(graph, st, "JFK");

        while(!st.isEmpty()){
            result.add(st.pop());
        }

        return result;
    }

    private void dfs(Map<String, PriorityQueue<String>> graph, Stack<String> st, String from) {
        PriorityQueue<String> arrive = graph.get(from);

        while(arrive != null && !arrive.isEmpty()){
            String to = arrive.poll();
            dfs(graph, st, to);

        }
        st.push(from);
    }

    private void buildGraph(List<List<String>> tickets, Map<String, PriorityQueue<String>> graph) {
        for(List<String> airport:tickets){
            String from = airport.get(0);
            String to = airport.get(1);
            graph.putIfAbsent(from, new PriorityQueue<>());
            graph.get(from).add(to);
        }
    }
}
