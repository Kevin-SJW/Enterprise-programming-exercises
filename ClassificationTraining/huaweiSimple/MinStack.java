package ClassificationTraining.huaweiSimple;

import java.util.Stack;

/**
 * @Classname MinStack
 * @Description TODO
 * @Date 2020/8/30 14:31
 * @Created by Administrator
 */
public class MinStack {
    /**
     * initialize your data structure here.
     */
    private Stack<Integer> stack;
    private Stack<Integer> minStack;

    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();

    }

    public void push(int x) {
        stack.push(x);
        if (minStack.isEmpty() || minStack.peek() >= x) {
            minStack.push(x);
        }

    }

    public void pop() {
        if (stack.peek().equals(minStack.peek())) {
            minStack.pop();
        }
        if (!stack.isEmpty()) {
            stack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
