package KeepOnCoding;



import java.util.*;

public class Knapsack2 {

    static class MenuItem{
        String title;
        Double value;
        public MenuItem(String t, Double v) {
            this.title = t;
            this.value =v;
        }
    }


    public static void main(String[] args) {
        //Map<String, Double> menu = new HashMap<>();

        List<MenuItem> menu = new LinkedList<>();

        menu.add(new MenuItem("chickween sandwich", 7.85));
        menu.add(new MenuItem("veggie saandwich", 6.5));
        menu.add(new MenuItem("extra chicken", 3.20));
        menu.add(new MenuItem("nachos", 3.45));
        menu.add(new MenuItem("extra veggies", 2.20));
        menu.add(new MenuItem("soda", 2.05));
        menu.add(new MenuItem("chips", 1.40));
        menu.add(new MenuItem("cheese", 1.25));
        // menu.add(new GiftItem("pizza", 4.85));


       List<Double> receipts = Arrays.asList(4.85,11.05,13.75,17.75,18.25,19.40,28.25,40.30,75.00);
        //List<Double> receipts = Arrays.asList(2.05, 4.85);

        for (double d : receipts){
            List<String> result = new ArrayList<>();
            helper(result, menu, d);
            System.out.println(d +" "+ result.size() + " items," + result);

        }



    }

    private static boolean helper(List<String> result, List<MenuItem> menu, double reciept) {

        if(reciept < 0){
            return false;
        }
        if(reciept ==0){
            return true;

        }
        for (MenuItem menuItem: menu){
            result.add(menuItem.title);
            //double diff = Math.round(reciept*100 -men)
            double diff = Math.round(reciept*100 -menuItem.value* 100)/100.0;
            if (helper(result,menu,diff)) {
                return true;

            }
            result.remove(result.size()-1);
        }


        return false;
    }
}
