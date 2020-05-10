package Grokking.CH15_TopologicalSort;

import java.util.HashSet;
import java.util.Stack;

public class Topo {
    public static void main(String[] args) {
        int[][] grid = new int [][]{{1, 3},
        {1, 2},
        {3, 4},
        {5, 6},
        {6, 3},
        {3, 8},
        {8, 11}};


        sort(grid);


        System.out.println("Hi");

    }

    private static void sort(int[][] grid) {

        HashSet<Integer> visited = new HashSet<>();
        Stack<Integer> stack = new Stack<>();






    }
}
