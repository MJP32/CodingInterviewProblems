package CapitalOne;

import java.util.Stack;

public class MinStack {


    Stack<Integer> dataStack;
    Stack<Integer> minStack;

    /** initialize your data structure here. */
    public MinStack() {
        dataStack = new Stack();
        minStack = new Stack();
    }

    public void push(int x) {

        dataStack.push(x);
        if (minStack.isEmpty()||x <= getMin()) {
            minStack.push(x);
        }

    }

    public void pop() {

        int x = dataStack.pop();
        if (x == getMin()) {
            minStack.pop();
        }
    }

    public int top() {
        return dataStack.peek();
    }

    public int getMin() {
        return minStack.peek();
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