package Hackerrank;

import java.util.ArrayList;
import java.util.List;

public class MaximumStreaks {
    public static void main(String[] args) {
        List<String> toss = new ArrayList<>();
        toss.add("3");
        toss.add("Heads");
        toss.add("Heads");
        toss.add("Heads");

        List<String> toss2 = new ArrayList<>();
        toss2.add("7");
        toss2.add("Heads");
        toss2.add("Tails");
        toss2.add("Tails");
        toss2.add("Tails");
        toss2.add("Heads");
        toss2.add("Heads");
        toss2.add("Tails");

        getMaxStreaks(toss).forEach(k-> System.out.println(k));
    }
    public static List<Integer> getMaxStreaks(List<String> toss) {
        // Return an array of two integers containing the maximum streak of heads and tails respectively
        List<Integer> result = new ArrayList<>();
        int maxHeads =0;
        int maxTails =0;
        int heads =0;
        int tails =0;
        //int size = Integer.valueOf(toss.get(0));
        for(int i =1; i < toss.size(); i++){
            if((toss.get(i)).equals("Heads")){
                heads++;
                tails =0;
            }
            else{
                tails++;
                heads=0;
            }

            maxHeads = Math.max(heads, maxHeads);
            maxTails = Math.max(tails, maxTails);
        }

        result.add(maxHeads);
        result.add(maxTails);
        return result;

    }

}
