package codinginterviews;

import java.util.Stack;

class CQueue {
    private Stack<Integer> stackA;
    private Stack<Integer> stackB;

    public CQueue() {
        stackA = new Stack<>();
        stackB = new Stack<>();
    }
    
    public void appendTail(int value) {
        stackA.push(value);
    }
    
    public int deleteHead() {
        while (!stackA.isEmpty()){
            stackB.push(stackA.pop());
        }
        if(stackB.isEmpty())
            return -1;
        int result = stackB.pop();
        while (!stackB.isEmpty()){
            stackA.push(stackB.pop());
        }

        return result;
    }
}