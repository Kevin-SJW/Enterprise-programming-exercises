package AutumnRecruitment.chap1_3;

import java.util.Scanner;

/**
 * @Classname InfixToPostfix
 * @Description 中序转后序
 * @Date 2019/9/29 19:08
 * @Created by 14241
 */
public class InfixToPostfix {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<String>();
        Scanner sc=new Scanner(System.in);
        String str=sc.next();
        while (!str.isEmpty()) {
            String s = sc.nextLine();
            switch (s) {
                case "+":
                case "-":
                case "*":
                case "/":
                    stack.push(s);
                    break;
                case "(":
                    break;
                case ")":
                    System.out.print(stack.pop() + " ");
                    break;
                default:
                    System.out.print(s + " ");
            }
        }
        System.out.println();
    }
}
