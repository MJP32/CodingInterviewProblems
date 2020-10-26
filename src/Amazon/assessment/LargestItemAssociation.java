package Amazon.assessment;

import java.util.*;

public class LargestItemAssociation {
    private int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public static void main(String[] args) {
        LargestItemAssociation s = new LargestItemAssociation();
        /**
         * Example 1
         */
        List<LargestItemAssociation.PairString> input = Arrays.asList(
                new LargestItemAssociation.PairString[]{
                        new PairString("item1", "item2"),
                        new PairString("item3", "item4"),
                        new PairString("item4", "item5")
                }
        );
        /**
         * Testing equal sized arraylist. 1->2->3->7 4->5->6->7
         */
        List<LargestItemAssociation.PairString> input2 = Arrays.asList(
                new LargestItemAssociation.PairString[]{
                        new PairString("item1", "item2"),
                        new PairString("item2", "item3"),
                        new PairString("item4", "item5"),
                        new PairString("item6", "item7"),
                        new PairString("item5", "item6"),
                        new PairString("item3", "item7")
                }
        );
        List<String> lst = s.largestItemAssociation(input);
        for (String sa : lst) System.out.print(" " + sa);
        System.out.println();
        List<String> lst2 = s.largestItemAssociation(input2);
        for (String sa : lst2) System.out.print(" " + sa);
        System.out.println();
        /**
         * Testing duplicates: 1->2->3->7 , 5->6
         */
        List<LargestItemAssociation.PairString> input3 = Arrays.asList(
                new LargestItemAssociation.PairString[]{
                        new PairString("item1", "item2"),
                        new PairString("item1", "item3"),
                        new PairString("item2", "item7"),
                        new PairString("item3", "item7"),
                        new PairString("item5", "item6"),
                        new PairString("item3", "item7")
                }
        );

        List<String> lst3 = s.largestItemAssociation(input3);
        for (String sa : lst3) System.out.print(" " + sa);
    }

    public static List<String> largestItemAssociation(List<PairString> itemAssociation) {
// write your code here
        List<List<String>> merged = new ArrayList<>();
        Map<String, List<String>> graph = new HashMap();
        // building graph.
        for(PairString pair : itemAssociation) {
            if(!graph.containsKey(pair.first)) {
                graph.put(pair.first, new ArrayList<>());
            }
            graph.get(pair.first).add(pair.second);
            if(!graph.containsKey(pair.second)) {
                graph.put(pair.second, new ArrayList<>());
            }
            graph.get(pair.second).add(pair.first);
        }
        Set<String> visited = new HashSet<>();
        for(String key : graph.keySet()) {
            List<String> list = new ArrayList<>();
            dfs(key, list, graph, visited);
            if(!list.isEmpty()) {
                Collections.sort(list);
                merged.add(list);
            }
        }
        // sort the merged results by each list size, if sizes are equal, sort them lexicographical.
        Collections.sort(merged, new Comparator<List<String>>() {
            @Override
            public int compare(List<String> l1, List<String> l2) {
                if(l1.size() == l2.size()) {
                    for(int i=0; i<l1.size(); i++) {
                        if(l1.get(i).equals(l2.get(i))) continue;
                        return l1.get(i).compareTo(l2.get(i));
                    }
                }
                return l2.size() - l1.size();
            }
        });
        return merged.get(0);
    }

    private static void dfs(String cur, List<String> list, Map<String, List<String>> graph, Set<String> visited) {
        if(visited.contains(cur))
            return;
        visited.add(cur);
        list.add(cur);
        for(String neighbor : graph.get(cur)) {
            dfs(neighbor, list, graph, visited);
        }
    }
    public static class PairString {
        String first;
        String second;

        public PairString(String first, String second) {
            this.first = first;
            this.second = second;
        }
    }


}
