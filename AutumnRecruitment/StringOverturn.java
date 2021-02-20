package AutumnRecruitment;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

/**
 * @Classname Main3
 * @Description TODO
 * @Date 2019/9/4 20:37
 * @Created by 14241
 *
 * ((ur)oi)
 *
 * iour
 */
public class StringOverturn {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        String input = read.nextLine();
        System.out.println(solution(input));
    }
    // ((ur)oi)
    private static String solution(String input) {
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c != ')') {
                stack.push(c);
            } else {
                List<Character> list = new ArrayList<Character>();
                char s = stack.pop();
                while (s != '(') {
                    list.add(s);
                    s = stack.pop();
                }

                for (int j = 0; j < list.size(); j++) {
                    stack.push(list.get(j));
                }
            }
        }
        StringBuffer sb = new StringBuffer();
        while (!stack.isEmpty()) {
            sb.insert(0, stack.pop());
        }
        String result = sb.toString();
        if (result.contains("(") || result.contains(")")) {
            return "";
        }
        return result;
    }
}
