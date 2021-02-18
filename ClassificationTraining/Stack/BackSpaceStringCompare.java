package ClassificationTraining.Stack;

import java.util.Stack;

/**
 * @Classname BackSpaceStringCompare
 * @Description TODO
 * @Date 2020/8/19 0:02
 * @Created by Administrator
 * Given two strings S and T, return if they are equal when both are typed into empty text editors. # means a backspace character.
 * <p>
 * Note that after backspacing an empty text, the text will continue empty.
 * Input: S = "ab#c", T = "ad#c"
 * Output: true
 * Explanation: Both S and T become "ac".
 */
public class BackSpaceStringCompare {
    public static void main(String[] args) {
        String S = "ab#c", T = "ad#c";
        System.out.println(backspaceCompare(S, T));

    }

    public static boolean backspaceCompare(String S, String T) {
        return build(S).equals(build(T));
    }

    public static String build(String S) {
        Stack<Character> ans = new Stack();
        for (char c : S.toCharArray()) {
            if (c != '#')
                ans.push(c);
            else if (!ans.empty())
                ans.pop();
        }
        return String.valueOf(ans);
    }
}
