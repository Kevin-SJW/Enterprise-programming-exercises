package LeetCodeSimple;

import AutumnRecruitment.chap1_3.Stack;

import java.util.HashMap;

/**
 * @Classname ValidParenthese
 * @Description TODO
 * @Date 2020/6/25 17:35
 * @Created by Administrator
 */
public class ValidParenthese {
    public static void main(String[] args) {
        String s = "()[]{}";
        System.out.println(isValid(s));
    }

    public static boolean isValid(String s) {
        HashMap<Character, Character> map = new HashMap<>();
        map.put(']', '[');
        map.put(')', '(');
        map.put('}', '{');
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                if (stack.isEmpty() || stack.pop() != map.get(c)) {
                    return false;
                }
            } else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }
}
