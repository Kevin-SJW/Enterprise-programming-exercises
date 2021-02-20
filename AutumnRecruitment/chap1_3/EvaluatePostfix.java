package AutumnRecruitment.chap1_3;

import AutumnRecruitment.StdIn;

/**
 * @Classname EvaluatePostfix
 * @Description 标准输入转后序表达式
 * @Date 2019/9/29 19:22
 * @Created by 14241
 */
public class EvaluatePostfix {
    public static void main(String[] args) {
        Stack<Double> stack = new Stack<>();
        while (!StdIn.isEmpty()) {
            String s = StdIn.readString();
            double result;
            switch (s) {
                case "+":
                    result = stack.pop() + stack.pop();
                    stack.push(result);
                    break;
                case "-":
                    result = -stack.pop() + stack.pop();
                    stack.push(result);
                    break;
                case "*":
                    result = stack.pop() * stack.pop();
                    stack.push(result);
                    break;
                case "/":
                    result = 1 / stack.pop() * stack.pop();
                    stack.push(result);
                    break;
                default:
                    stack.push(Double.parseDouble(s));
            }
        }
        System.out.println(stack.pop());
    }
}
