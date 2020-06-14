package bytebybyte.module3;

import java.util.LinkedList;
import java.util.List;

public class StairStep {
    public static void main(String[] args) {
        System.out.println(stairStep(4));
    }
    public static List<List<Integer>> stairStep(int n){
        return stairStep(n, 0);
    }
    public static List<List<Integer>> stairStep(int n, int currentStep){
        if (currentStep == n) {
            List<List<Integer>> result = new LinkedList<>();
            result.add(new LinkedList<>());
            return result;
        }
        if(currentStep > n){
            return new LinkedList<List<Integer>>();
        }
        List<List<Integer>> result = new LinkedList<List<Integer>>();
        result.addAll(stairStep(n, currentStep +1));
        result.addAll(stairStep(n, currentStep +2));
        result.addAll(stairStep(n, currentStep +3));

        for (List<Integer> l: result) {
            l.add(0,currentStep);
        }
        return result;
    }
}
