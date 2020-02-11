package KeepOnCoding;



import java.util.*;

public class Knapsack {
    public static void main(String[] args) {
        Map<String, Double> menu = new HashMap<>();
        menu.put("veggie saandwich", 6.5);
        menu.put("extra veggies", 2.20);
        menu.put("chickween sandwich", 7.85);
        menu.put("extra chicken", 3.20);
        menu.put("cheese", 1.25);
        menu.put("chips", 1.40);
        menu.put("nachos", 3.45);
        menu.put("soda", 2.05);
        menu.put("pizza", 4.85);


       List<Double> receipts = Arrays.asList(4.85,11.05,13.75,17.75,18.25,19.40,28.25,40.30,75.00);
        //List<Double> receipts = Arrays.asList(2.05, 4.85);

        for (double d : receipts){
            List<String> result = new ArrayList<>();
            helper(result, menu, d);
            System.out.println(d +" "+ result.size() + " items," + result);

        }



    }

    private static boolean helper(List<String> result, Map<String, Double> menu, double reciept) {

        if(reciept < 0){
            return false;
        }
        if(reciept ==0){
            return true;

        }
        for (Map.Entry<String,Double> entry :menu.entrySet()){
            result.add(entry.getKey());
            if (helper(result,menu,reciept-entry.getValue())) {
                return true;

            }
            result.remove(result.size()-1);
        }


        return false;
    }
}
