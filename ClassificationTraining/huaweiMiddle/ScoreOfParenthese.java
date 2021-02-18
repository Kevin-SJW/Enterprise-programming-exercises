package ClassificationTraining.huaweiMiddle;

import AutumnRecruitment.chap1_3.Stack;

/**
 * 遍历字符串S中每个字符
 * 1.若当前字符为（，直接入栈
 * 2.若当前字符为）
 * 2.1若前一个字符为（，加“2的n-1次方”分（n为栈的深度）。然后弹出一个字符。
 * 2.2若前一个字符为），直接弹出一个字符。
 * () 得 1 分。
 * AB 得 A + B 分，其中 A 和 B 是平衡括号字符串。
 * (A) 得 2 * A 分，其中 A 是平衡括号字符串。
 */
public class ScoreOfParenthese {
    public static void main(String[] args) {
        String s = "(())";
        System.out.println(scoreOfParentheses(s));
    }

    public static int scoreOfParentheses(String s) {
        int res = 0;
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(c);
            } else {
                if (s.charAt(i) == ')') {
                    if (s.charAt(i - 1) == '(') {
                        res += Math.pow(2, stack.size() - 1);
                        stack.pop();
                    } else {

                        stack.pop();
                    }
                }
            }
        }
        return res;
    }

    public static int scoreOfParentheses2(String s) {
        int res = 0;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(c);
            } else {
                if (s.charAt(i) == ')') {
                    if (s.charAt(i - 1) == '(') {
                        res += Math.pow(2, stack.size() - 1);
                        stack.pop();
                    } else {
                        stack.pop();
                    }
                }
            }
        }
        return res;
    }
}
