package bytebybyte.module4;


import java.util.LinkedList;
import java.util.List;

public class CombinationOfSetLength {
    public static void main(String[] args) {

    }
    public static List<List<Integer>> combinationsOfLength(int[] n, int length){
        return combinationsOfLength(n,0,length,0);
    }

    private static List<List<Integer>> combinationsOfLength(int[] n, int i, int targetLength, int currentLength) {
        if (currentLength > targetLength) {
            return new LinkedList<List<Integer>>();
        }
        if(i==n.length && currentLength !=targetLength){
            return new LinkedList<List<Integer>>();
        }
        if (i == n.length) {
            //List<List<Integer>>
        }
        return null;
    }
}
