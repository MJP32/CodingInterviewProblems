package Amazon.assessment;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ShoppingPatterns {
    public static void main(String[] args) {
        System.out.println(solve(6, new int[][] {{1, 2}, {2,4}, {2,5}, {3,5}, {4,5}, {5,6}}));
    }

    private static int solve(int numOfProducts, int[][] edges) {

        Map<Integer,Set<Integer>> map = new HashMap<>();
        for(int i=1;i<=numOfProducts;i++){
            map.put(i,(new HashSet<Integer>()));
        }

        for(int i=0; i<edges.length; i++){
            map.get(edges[i][0]).add(edges[i][1]);
            map.get(edges[i][1]).add(edges[i][0]);
        }

        int count =  Integer.MAX_VALUE;
        for(int i=1; i<=numOfProducts; i++){
            for(int j=i+1; j<=numOfProducts; j++){
                for(int k=j+1; k<=numOfProducts; k++){
                    // There has to be some other way to check if its a trio??
                    if(map.get(i).contains(j) && map.get(j).contains(k) && map.get(k).contains(i)){
                        int val = (map.get(i).size() + map.get(j).size() + map.get(k).size()) - 6;
                        count =  Math.min(count, val);
                    }
                }
            }
        }
        return count;
    }
}
