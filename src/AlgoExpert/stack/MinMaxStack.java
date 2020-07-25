package AlgoExpert.stack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MinMaxStack {

    List<Map<String,Integer>> minMaxStack = new ArrayList<>();
    List<Integer> stack = new ArrayList<>();



    public int peek() {
        // Write your code here.
        return stack.get(stack.size()-1);
    }

    public int pop() {
        // Write your code here.
        minMaxStack.remove(minMaxStack.size()-1);


        return stack.remove(stack.size()-1);
    }

    public void push(Integer number) {
        // Write your code here.

        Map<String, Integer> newMinMax = new HashMap<>();
        newMinMax.put("min", number);
        newMinMax.put("max", number);
        if(minMaxStack.size()>0){
            Map<String,Integer> lastMinMax = new HashMap<>(minMaxStack.get(minMaxStack.size()-1));
            newMinMax.replace("min", Math.min(lastMinMax.get("min"), number));
            newMinMax.replace("max", Math.max(lastMinMax.get("max"), number));

        }
        minMaxStack.add(newMinMax);
        stack.add(number);
    }

    public int getMin() {
        // Write your code here.

        return minMaxStack.get(minMaxStack.size()-1).get("min");
    }

    public int getMax() {
        // Write your code here.
        return minMaxStack.get(minMaxStack.size()-1).get("max");
    }
}
class MinMaxTest{
    public static void main(String[] args) {
        MinMaxStack stack = new MinMaxStack();
        stack.push(5);
        stack.push(7);
        stack.push(2);

        System.out.println(stack.getMax());
        System.out.println(stack.getMin());
//        System.out.println(stack.pop());
//        System.out.println(stack.peek());

    }
}