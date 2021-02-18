package ClassificationTraining.huaweiMiddle;

import java.util.HashSet;
import java.util.Set;

/**
 * @Classname longestSubStringWithoutRepeatingCharacters
 * @Description TODO
 * @Date 2020/9/20 11:07
 * @Created by Administrator
 */
public class longestSubStringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(s));
    }

    public static int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int i = 0, j = 0;
        Set<Character> set = new HashSet<>();
        int res = 0;
        while (i < n && j < n) {
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
                res = Math.max(res, j - i);
            } else {

                set.remove(s.charAt(i++));
            }
        }
        return res;
    }

    public static int lengthOfLongestSubstring2(String s) {
        int n = s.length();
        int i = 0, j = 0;
        int res = 0;
        Set<Character> set = new HashSet<>();
        while (i < n && j < n) {
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
                res = Math.max(res, j - i);
            } else {
                set.remove(s.charAt(i++));
            }
        }
        return res;

    }
}
