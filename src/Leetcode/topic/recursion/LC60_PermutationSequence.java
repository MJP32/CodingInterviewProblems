package Leetcode.topic.recursion;

import java.util.*;

public class LC60_PermutationSequence {
    public static void main(String[] args) {
        System.out.println(new LC60_PermutationSequence().getPermutation(3,3));
        System.out.println(new LC60_PermutationSequence().getPermutation(4,4));
    }

    public String getPermutation(int n, int k) {

        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = i+1;
        }

        return permute(k,nums);
    }


    public String permute(int k, int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        Set<Integer> items = new HashSet<>();
        for(Integer i : nums){
            items.add(i);
        }
        permutations(items, nums, new ArrayList<>(), results);

        String ans = "";
        for(Integer i: results.get(k)){
            ans+=i;
        }

        return ans;

    }
    public void permutations(Set<Integer> items, int[] num, ArrayList<Integer> path, List<List<Integer>>
            results){

        if(path.size() == num.length){
            results.add(new LinkedList<Integer>(path));
                return;
        }
        for(Integer i: items.toArray(new Integer[]{})){
            items.remove(i);
            path.add(i);
            permutations(items,num, path, results);
            items.add(i);
            path.remove(path.size()-1);
        }
    }
}
