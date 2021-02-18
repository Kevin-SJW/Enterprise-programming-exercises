package ClassificationTraining.huaweiMiddle;

import java.util.Stack;

/**
 * 给出一个字符串 s（仅含有小写英文字母和括号）。
 * 请你按照从括号内到外的顺序，逐层反转每对匹配括号中的字符串，并返回最终的结果。
 * 注意，您的结果中 不应 包含任何括号。
 * 输入：s = "(u(love)i)"
 * 输出："iloveu"
 * 遇到右括号之前都入栈。遇到了右括号，出栈，直到遇到左括号。
 * 将出栈的数据重新入栈，继续判断。最后出栈所有数据，反转就是结果
 */
public class ReverseSubstringInParenthese {
    public static void main(String[] args) {
        String s = "(u(love)i)";
        System.out.println(reverseParentheses(s));
    }
    public static String reverseParentheses(String s) {
        Stack<Character> stack = new Stack<>();
        StringBuilder sb;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != ')') {
                stack.push(chars[i]);
            } else {
                sb = new StringBuilder();
                while (!stack.isEmpty() && stack.peek() != '(') {
                    sb.append(stack.pop());
                }
                if (!stack.isEmpty() && stack.peek() == '(') {
                    stack.pop();
                }
                char[] array = sb.toString().toCharArray();
                for (int j = 0; j < array.length; j++) {
                    stack.push(array[j]);
                }
            }
        }
        sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }

    //输入：s = "(u(love)i)"
    // * 输出："iloveu"
    public static String reverseParentheses2(String s) {
        Stack<Character> stack = new Stack<>();
        StringBuilder sb;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c != ')') {
                stack.push(c);
            } else {
                sb = new StringBuilder();
                while (!stack.isEmpty() && stack.peek() != '(') {
                    sb.append(stack.peek());
                    stack.pop();
                }
                if (!stack.isEmpty() && stack.peek() == '(') {
                    stack.pop();
                }
                char[] arr = sb.toString().toCharArray();
                for (int j = 0; j < arr.length; j++) {
                    stack.push(arr[j]);
                }
            }
        }
        sb = new StringBuilder();
        while(!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }

}

