package ClassificationTraining.Array;

import AutumnRecruitment.chap1_3.Stack;

/**
 * @Classname ValidateStackSequence
 * @Description TODO
 * @Date 2020/9/26 11:08
 * @Created by Administrator
 * 输入：pushed = [1,2,3,4,5], popped = [4,5,3,2,1]
 * 输出：true
 * 解释：我们可以按以下顺序执行：
 * push(1), push(2), push(3), push(4), pop() -> 4,
 * push(5), pop() -> 5, pop() -> 3, pop() -> 2, pop() -> 1
 */
public class ValidateStackSequence {
    public static void main(String[] args) {
        int[] pushed = {1, 2, 3, 4, 5};
        int[] poped = {4, 5, 3, 2, 1};
        System.out.println(validateStackSequences2(pushed, poped));

    }

    public static boolean validateStackSequences(int[] pushed, int[] popped) {
        if (pushed.length != popped.length) {
            return false;
        }
        int index = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < pushed.length; i++) {
            stack.push(pushed[i]);
            while (!stack.isEmpty() && stack.peek() == popped[index]) {
                stack.pop();
                index++;
            }
        }
        return stack.isEmpty();
    }

    public static boolean validateStackSequences2(int[] pushed, int[] poped) {
        if (pushed.length != poped.length) {
            return false;
        }
        int index = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < pushed.length; i++) {
            stack.push(pushed[i]);
            while (!stack.isEmpty() && stack.peek() == poped[index]) {
                stack.pop();
                index++;
            }
        }
        return stack.isEmpty();
    }
}
