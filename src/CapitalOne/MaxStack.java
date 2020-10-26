package CapitalOne;

import java.util.Stack;

public class MaxStack {

    Stack<Integer> dataStack, maxStack;

    /** initialize your data structure here. */
    public MaxStack() {
        maxStack = new Stack<>();
        dataStack = new Stack<>();
    }

    public void push(int x) {
        dataStack.push(x);
        if (maxStack.isEmpty()|| maxStack.peek()<=x) {
            maxStack.push(x);
        }

    }

    public int pop() {
        int result = dataStack.pop();
        if (result == maxStack.peek()) {
            maxStack.pop();
        }
        return result;
    }

    public int top() {
        return dataStack.peek();
    }

    public int peekMax() {
        return maxStack.peek();
    }

    public int popMax() {
        Stack<Integer> tmp = new Stack<>();
        int result = maxStack.pop();
        while(result != dataStack.peek()){
            tmp.push(dataStack.pop());
        }
        dataStack.pop();
        while(!tmp.isEmpty()){
            push(tmp.pop());
        }
        return result;
    }

}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */