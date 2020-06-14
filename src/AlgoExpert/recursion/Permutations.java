package AlgoExpert.recursion;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
    public static int i =0;
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        List<List<Integer>> result =  getPermutations(list);

        for (List<Integer> l1 : result) {
            for (Integer n : l1) {
                System.out.print(n + " ");
            }
            System.out.println();
        }
    }

    public static List<List<Integer>> getPermutations(List<Integer> array) {
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        getPermutations(array, new ArrayList<Integer>(), results);
        return results;
    }
    public static void getPermutations(
            List<Integer> array, List<Integer> currentPermutation, List<List<Integer>>results){
        System.out.print(i++ + ".  \t"   );
        currentPermutation.forEach(k-> System.out.print(k + " "));
        System.out.print("\t\t\t ->");
        array.forEach(k-> System.out.print(k + " "));
        System.out.println();

        if(array.size()==0 && currentPermutation.size()> 0){
            results.add(currentPermutation);
        }
        else{
            for(int i =0;i< array.size();i++){
                List<Integer> newArray = new ArrayList<Integer>(array);
                System.out.println("removing " + newArray.get(i));
                newArray.remove(i);
                List<Integer> newPermutation = new ArrayList<Integer>(currentPermutation);
                System.out.println("adding" + array.get(i));
                newPermutation.add(array.get(i));
                getPermutations(newArray, newPermutation, results);
            }
        }
    }
}
