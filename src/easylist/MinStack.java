package easylist;


import java.util.Stack;

public class MinStack {
    Stack<Integer> data;
    Stack<Integer> minStack;
    /** initialize your data structure here. */
    public MinStack() {
        data = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int x) {
        data.push(x);
        if(minStack.isEmpty())
            minStack.push(x);
        else if(x < minStack.peek())
            minStack.push(x);

    }

    public void pop() {
        int temp = data.pop();
        if(temp == minStack.peek())
            minStack.pop();
    }

    public int top() {
        return data.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
