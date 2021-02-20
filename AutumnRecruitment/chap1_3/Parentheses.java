package AutumnRecruitment.chap1_3;

import java.util.Scanner;
import java.util.Stack;

/**
 * @Classname Parentheses
 * @Description TODO
 * @Date 2019/9/29 13:49
 * @Created by 14241
 */
public class Parentheses {
    public static void main(String[] args){
        Stack<String> stack=new Stack<>();
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        String[] inputs=s.split("");
        for(String input:inputs){
            if(input.equals("{")||input.equals("[")||input.equals("(")){
                stack.push(input);
            }else if (!stack.isEmpty()) {
                if (input.equals("}")) {
                    if (!stack.pop().equals("{")) {
                        System.out.println(false);
                        return;
                    }
                } else if (input.equals("]")) {
                    if (!stack.pop().equals("[")) {
                        System.out.println(false);
                        return;
                    }
                } else if (input.equals(")")) {
                    if (!stack.pop().equals("(")) {
                        System.out.println(false);
                        return;
                    }
                }
            }
        }
        System.out.println(stack.isEmpty());


    }
}
