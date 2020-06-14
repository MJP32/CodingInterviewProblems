package bytebybyte.module2;

import java.util.Stack;

public class InsertAtBottomOfStack {
    public static void main(String[] args) {
Stack<Integer> stack = new Stack<>();
stack.push(1);
stack.push(2);
stack.push(3);
stack.push(4);

    insertAtBottomIter(stack, 5);
    insertAtBottomRecursive(stack, 5);
    while(!stack.isEmpty()){
        System.out.println(stack.pop());
    }

    }

    public static void insertAtBottomIter(Stack<Integer> s, int i ){
        Stack<Integer> temp = new Stack<>();
        while (!s.isEmpty()) {
            temp.push(s.pop());
        }
        s.push(i);
        while(!temp.isEmpty()){
            s.push(temp.pop());

        }
    }

    public static void insertAtBottomRecursive(Stack<Integer> s, int i ){

        if(s.isEmpty()){
            s.push(i);
            return;
        }
        int top = s.pop();
        insertAtBottomRecursive(s,i);
        s.push(top);
    }


}
