package codinginterviews;

import java.util.Stack;

/**
 * @author WRK
 * @date 2021-02-02 11:20
 */
public class StackPushAndPop {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        for(int num : pushed) {
            stack.push(num); // num 入栈
            while(!stack.isEmpty() && stack.peek() == popped[i]) { // 循环判断与出栈
                stack.pop();
                i++;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        StackPushAndPop stackPushAndPop = new StackPushAndPop();
        System.out.println(stackPushAndPop.validateStackSequences(new int[]{1, 2, 3, 4, 5}, new int[]{4, 5, 3, 2, 1}));
    }
}
