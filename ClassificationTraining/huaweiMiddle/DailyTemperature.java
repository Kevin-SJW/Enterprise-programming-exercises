package ClassificationTraining.huaweiMiddle;

import java.util.*;

/**
 * @Classname DailyTemperature
 * @Description TODO
 * @Date 2020/8/30 14:48
 * @Created by Administrator
 * Given a list of daily temperatures T, return a list such that,
 * for each day in the input, tells you how many days you would have to wait
 * until a warmer temperature. If there is no future day for which this is possible,
 * put 0 instead.
 */
public class DailyTemperature {

    public static void main(String[] args) {
        int[] T = {73, 74, 75, 71, 69, 72, 76, 73};
        Arrays.stream(dailyTemperatures2(T)).forEach(t -> System.out.print(t + " "));
    }

    public static int[] dailyTemperatures(int[] T) {
        int n = T.length;
        int[] ans = new int[n];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty()) {
                int j = stack.peek();
                if (T[i] > T[j]) {
                    ans[j] = i - j;
                    stack.pop();
                } else {
                    break;
                }
            }
            stack.push(i);
        }
        return ans;
    }

    public static int[] dailyTemperatures2(int[] T) {
        Stack<Integer> stack = new Stack<>();
        int[] ans = new int[T.length];
        for (int i = 0; i < T.length; i++) {
            while (!stack.isEmpty()) {
                int j = stack.peek();
                if (T[i] > T[j]) {
                    ans[j] = i - j;
                    stack.pop();

                } else {
                    break;
                }
            }
            stack.push(i);
        }
        return ans;

    }
}
