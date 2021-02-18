package ClassificationTraining.String;

import AutumnRecruitment.chap1_3.Stack;

/**
 * @Classname LongestValidParenthesis
 * @Description TODO
 * @Date 2020/8/1 13:11
 * @Created by Administrator
 */
public class LongestValidParenthesis {
    public static void main(String[] args) {
        String s = ")()())";
        System.out.println(longestValidParentheses(s));
    }

    public static int longestValidParentheses(String s) {
        int maxlen = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);

                } else {
                    maxlen = Math.max(maxlen, i - stack.peek());
                }
            }
        }
        return maxlen;
    }
}
