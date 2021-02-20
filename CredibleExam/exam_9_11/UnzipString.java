package CredibleExam.exam_9_11;

import java.util.Stack;

/**
 * @Classname UnzipString
 * @Description TODO
 * @Date 2020/10/15 0:05
 * @Created by Administrator
 * abcccdbcccde
 */
public class UnzipString {
    public static void main(String[] args) {
        String str = "a(b(c)<3>d)<2>e";
        System.out.println(unzipString(str));

    }

    public static String unzipString(String records) {
        Stack<StringBuilder> stack = new Stack<>();
        int curRepeatingTimes = 0;
        stack.push(new StringBuilder());
        for (char c : records.toCharArray()) {
            if (Character.isAlphabetic(c)) {
                stack.peek().append(c);
            } else if (c == '(') {
                stack.push(new StringBuilder());
            } else if (Character.isDigit(c)) {
                curRepeatingTimes = curRepeatingTimes + c - '0';
            } else if (c == '>') {
                StringBuilder pop = stack.pop();
                for (int i = 0; i < curRepeatingTimes; i++) {
                    stack.peek().append(pop);
                }

            } else {
                curRepeatingTimes = 0;
            }
        }
        return stack.peek().toString();

    }
}
