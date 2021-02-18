package ClassificationTraining.Stack;

import AutumnRecruitment.chap1_3.Stack;

/**
 * @Classname BasicCalculator
 * @Description TODO
 * @Date 2020/8/20 0:28
 * @Created by Administrator
 * Implement a basic calculator to evaluate a simple expression string.
 * <p>
 * The expression string may contain open ( and closing parentheses ),
 * the plus + or minus sign -, non-negative integers and empty spaces .
 */
public class BasicCalculator {
    public static void main(String[] args) {
        String s = "1 + 1";
        System.out.println(calculate(s));

    }

    public static int calculate(String s) {
        Stack<Integer> stk = new Stack<>();
        // sign为1，可以考虑第一个数字没有符号的情况
        int sign = 1;
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isDigit(ch)) {
                int curSum = s.charAt(i) - '0';
                // 由于之前用了++i<s.length(),导致错误，
                // 原因是导致此if结束，又进去for循环，加了两次i
                // 使得结果出错.使用在while循环里，
                //如果不符合要求，不会自增，也就不会跳过符号位
                while (i + 1 < s.length()
                        && Character.isDigit(s.charAt(i + 1)))
                    curSum = curSum * 10 + s.charAt(++i) - '0';
                // res等于符号位乘以本次结果和之前的res之和
                res += sign * curSum;
            } else if (ch == '+')
                sign = 1;
            else if (ch == '-')
                sign = -1;
                // 遇到左括号时将res及括号之前的运算符压栈
            else if (ch == '(') {
                // 因res存入栈中，需要将res置为0，取出的时候从栈取res计算
                stk.push(res);
                res = 0;// 注意
                // sign置为1，已把sign放入栈中，重置
                stk.push(sign);// 注意
                sign = 1;
            } else if (ch == ')') {
                res = stk.pop() * res + stk.pop();
                // sign = 1;
            }
        }
        return res;

    }

}

