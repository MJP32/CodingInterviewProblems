package bytebybyte.module5;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
    public static int num =0;
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        ArrayList<ArrayList<Integer>> result = getPermutations(list);


        for (List<Integer> l1 : result) {
            for (Integer n : l1) {
                System.out.print(n + " ");
            }
            System.out.println();
        }
    }


    public static ArrayList<ArrayList<Integer>> getPermutations(ArrayList<Integer> array) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        getPermutations(array, new ArrayList<Integer>(), result);
        return result;
    }

    private static void getPermutations(ArrayList<Integer> items, ArrayList<Integer> path,
                                        ArrayList<ArrayList<Integer>> result) {
        if (items.isEmpty()) {
            result.add(new ArrayList<Integer>(path));
            return;
        }

        for (Integer i : items.toArray(new Integer[]{})) {
            items.remove(i);
            path.add(i);
            getPermutations(items, path, result);
            items.add(i);
            path.remove(path.size() - 1);
        }
    }

}


