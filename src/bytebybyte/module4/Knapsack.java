package bytebybyte.module4;


import com.sun.tools.javac.jvm.Items;

import java.util.LinkedList;
import java.util.List;

public class Knapsack {
    public static void main(String[] args) {

    }
    public static List<Item> knapsack(Items[] items, int totalWeight ){
        List<List<Item>> result = new LinkedList<List<Item>>();
        result.add(new LinkedList<Item>());
        knapsack(items,0,new LinkedList<Item>(),0, totalWeight,result );
        return result.get(0);
    }

    private static void knapsack(Items[] items, int i, LinkedList<Item> path, int currentWeight, int totalWeight,
                                 List<List<Item>>
            result) {

        if (currentWeight > totalWeight) {
            return;
        }


    }
}

class Item{
    int weight;

}