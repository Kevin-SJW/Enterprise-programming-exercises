package ClassificationTraining.String;

import java.util.HashSet;
import java.util.Set;

/**
 * @Classname LengthOfLongestSubstring
 * @Description TODO
 * @Date 2020/7/19 19:01
 * @Created by Administrator
 * Given a string, find the length of the longest substring without repeating characters.
 * <p>
 * Example 1:
 * <p>
 * Input: "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 * Example 2:
 * <p>
 * Input: "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * Example 3:
 * <p>
 * Input: "pwwkew"
 * Output: 3
 */
public class LengthOfLongestSubstring {
    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(s));

    }

    public static int lengthOfLongestSubstring(String s) {

        Set<Character> set = new HashSet<>();
        int ans = 0, i = 0, j = 0;
        int len = s.length();
        while (i < len && j < len) {
            if (!set.contains(s.charAt(j))) {
                // try to extend the range [i, j]
                set.add(s.charAt(j++));
                ans=Math.max(ans,j-i);
            } else {
                set.remove(s.charAt(i++));

            }
        }
        return ans;
    }
}
