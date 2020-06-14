package bytebybyte.module5;

import java.util.*;

public class PermutationsWIthDuplicates {
    public static int num =0;
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(1);
        list.add(2);
        list.add(3);

        List<List<Integer>> result = getPermutations(list);


        for (List<Integer> l1 : result) {
            for (Integer n : l1) {
                System.out.print(n + " ");
            }
            System.out.println();
        }
    }


    public static List<List<Integer>> getPermutations(List<Integer> items) {
        List<List<Integer>> result = new LinkedList<>();
        HashMap<Integer,Integer> itemCounts = new HashMap<>();
        for(int i : items){
            itemCounts.put(i, itemCounts.getOrDefault(i,0)+1);
        }
        getPermutations(itemCounts, new ArrayList<Integer>(), result);
        return result;
    }

    private static void getPermutations(HashMap<Integer, Integer> itemCounts, ArrayList<Integer> path,
                                        List<List<Integer>> result) {
        if (itemCounts.isEmpty()) {
            result.add(new ArrayList<Integer>(path));
            return;
        }

        for (Integer i : new HashSet<Integer>(itemCounts.keySet()){}) {
            int curr = itemCounts.get(i);
            if (curr ==1) {
                itemCounts.remove(i);
            }
            else{
                itemCounts.put(i,curr-i);

            }

            path.add(i);
            getPermutations(itemCounts, path, result);
            itemCounts.put(i, curr);
            path.remove(path.size() - 1);
        }
    }

}


