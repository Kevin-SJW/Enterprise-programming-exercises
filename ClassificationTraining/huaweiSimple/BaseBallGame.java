package ClassificationTraining.huaweiSimple;

import AutumnRecruitment.chap1_3.Stack;

/**
 * @Classname BaseBallGame
 * @Description TODO
 * @Date 2020/9/13 9:53
 * @Created by Administrator
 * You're now a baseball game point recorder.
 * Given a list of strings, each string can be one of the 4 following types:
 * Integer (one round's score): Directly represents the number of points you get in this round.
 * "+" (one round's score): Represents that the points you get in this round are the sum of the last two valid round's points.
 * "D" (one round's score): Represents that the points you get in this round are the doubled data of the last valid round's points.
 * "C" (an operation, which isn't a round's score): Represents the last valid round's points you get were invalid and should be removed.
 * Each round's operation is permanent and could have an impact on the round before and the round after.
 * You need to return the sum of the points you could get in all the rounds.
 */
public class BaseBallGame {
    public static void main(String[] args) {
        String[] ops = {"5", "2", "C", "D", "+"};
        System.out.println(calPoints(ops));
    }

    public static int calPoints(String[] ops) {
        Integer a, b;
        Stack<Integer> stack = new Stack<>();
        for (String op : ops) {
            switch (op) {
                case "+":
                    b = stack.pop();
                    a = stack.peek();
                    stack.push(b);
                    stack.push(a + b);
                    break;
                case "D":
                    a = stack.peek();
                    stack.push(a * 2);
                    break;
                case "C":
                    stack.pop();
                    break;
                default:
                    stack.push(Integer.parseInt(op));
                    break;
            }
        }
        int sum = 0;
        while(!stack.isEmpty()) {
            sum += stack.pop();
        }
        return sum;

    }


}

