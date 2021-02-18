package ClassificationTraining.huaweiSimple;

import AutumnRecruitment.chap1_3.Stack;

/**
 * @Classname MinStack2
 * @Description TODO
 * @Date 2020/9/23 0:17
 * @Created by Administrator
 */
public class MinStack2 {
    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());


    }

    Stack<Integer> stack;
    Stack<Integer> mStack;

    public MinStack2() {
        stack = new Stack<>();
        mStack = new Stack<>();

    }

    public void push(int x) {
        stack.push(x);
        if (mStack.isEmpty() || mStack.peek() >= x) {
            mStack.push(x);
        }

    }

    public void pop() {
        if (stack.peek().equals(mStack.peek())) {
            mStack.pop();
        }
        if(!stack.isEmpty()){
            stack.pop();
        }
    }

    public int top() {

        return stack.peek();

    }

    public int getMin() {
        return mStack.peek();
    }
}
