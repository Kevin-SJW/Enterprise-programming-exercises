package ClassificationTraining.Stack;

import java.util.Arrays;
import java.util.Stack;

/**
 * @Classname AsteroidCollision
 * @Description TODO
 * @Date 2020/8/19 0:21
 * @Created by Administrator
 * We are given an array asteroids of integers representing asteroids in a row.
 * <p>
 * For each asteroid, the absolute value represents its size, and the sign represents its direction (positive meaning right, negative meaning left). Each asteroid moves at the same speed.
 * <p>
 * Find out the state of the asteroids after all collisions. If two asteroids meet, the smaller one will explode. If both are the same size, both will explode. Two asteroids moving in the same direction will never meet.
 */
public class AsteroidCollision {
    public static void main(String[] args) {
        int[] asteroids = {5, 10, -5};
        Arrays.stream(asteroidCollision(asteroids)).forEach(t -> System.out.println(t + " "));
    }

    public static int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for (int ast : asteroids) {//对sateroids遍历取值
            collision:
            {
                while (!stack.isEmpty() && ast < 0 && 0 < stack.peek()) {
                    //当栈不为空，栈顶大于0，当前遍历值小于0 才会发生爆炸
                    if (stack.peek() < -ast) { //栈顶值小于遍历值绝对值
                        stack.pop(); //栈顶值拉出
                        continue; //再进行判断 和当前栈顶再比一次
                    } else if (stack.peek() == -ast) {//绝对值相等
                        stack.pop();//栈顶值拉出
                    }
                    break collision;  //栈顶值大于遍历值绝对值 跳出collsion 然后进行下一个ast遍历
                }
                stack.push(ast);
            }
        }

        int[] ans = new int[stack.size()];
        //栈的值赋给ans
        for (int t = ans.length - 1; t >= 0; --t) {
            ans[t] = stack.pop();
        }
        return ans;


    }
}
