package AutumnRecruitment;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

/**
 * @Author: sjw
 * @Date: 2019/8/17 20:47
 * @Description:
 *
 * HG[3|B[2|CA]]F
 */
public class Decompress {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String mess = in.nextLine();
        String result = method(mess);
        System.out.println(result);
    }

    private static String method(String mess) {
        StringBuffer sb = new StringBuffer();
        Stack<String> stack = new Stack<String>();
        char[] chars = mess.toCharArray();

        for (char c : chars) {
            stack.push(String.valueOf(c));
            if (c == ']') {
                stack.pop();
                StringBuffer temp1 = new StringBuffer();
                while (!stack.peek().equals("|")) {
                    temp1.insert(0, stack.pop());
                }
                stack.pop();
                StringBuffer temp2 = new StringBuffer();
                while (!stack.peek().equals("[")) {
                    temp2.insert(0, stack.pop());
                }
                stack.pop();
                for (int i = 0; i < Integer.valueOf(temp2.toString()); i++)
                {stack.push(temp1.toString());}
            }
        }
        while (!stack.isEmpty()) {
            sb.insert(0, stack.pop());
        }
        return sb.toString();
    }
}
