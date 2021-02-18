package ClassificationTraining.PatternSlidingWindow;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @Classname LengthOfLongestSubStringKDistinct
 * @Description TODO
 * @Date 2020/7/19 19:51
 * @Created by Administrator
 * Find the length of the longest substring T of a given string (consists of lowercase letters only) such that every character in T appears no less than k times.
 * <p>
 * Example 1:
 * <p>
 * Input:
 * s = "aaabb", k = 3
 * <p>
 * Output:
 * 3
 * <p>
 * The longest substring is "aaa", as 'a' is repeated 3 times.
 */
public class LengthOfLongestSubStringKRepeating {
    public static void main(String[] args) {
        String s = "aaabb";
        int k = 3;
        System.out.println(longestSubstring(s, k));
    }

    public static int longestSubstring(String s, int k) {
        if (s.length() < k) {
            return 0;
        }
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        Set<Character> set = map.keySet();
        for (char c : set) {
            if (map.get(c) < k) {
                String[] arr = s.split(String.valueOf(c));
                int res = longestSubstring(arr[0], k);
                for (int i = 1; i < arr.length; i++) {
                    int tmp = longestSubstring(arr[i], k);
                    if (res < tmp) {
                        res = tmp;
                    }
                }
                return res;
            }
        }
        return s.length();
    }
}
