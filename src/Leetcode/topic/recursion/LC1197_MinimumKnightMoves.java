package Leetcode.topic.recursion;

import java.util.HashMap;

public class LC1197_MinimumKnightMoves {
    public static void main(String[] args) {
        System.out.println(new LC1197_MinimumKnightMoves().minKnightMoves(2,1));
        System.out.println(new LC1197_MinimumKnightMoves().minKnightMoves(5,5));
    }
    HashMap<String, Integer> map = new HashMap<String, Integer>();
    public int minKnightMoves(int x, int y) {
        x = Math.abs(x);
        y = Math.abs(y);
        if(x + y == 0) return 0;
        if(x + y == 2) return 2;
        String key = x + "#" + y;
        if(map.containsKey(key)) return map.get(key);
        int count = Math.min(minKnightMoves(x - 2, y - 1), minKnightMoves(x-1, y-2)) + 1;
        map.put(key, count);
        return count;
    }
}
