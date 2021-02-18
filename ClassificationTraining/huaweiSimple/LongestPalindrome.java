package ClassificationTraining.huaweiSimple;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个包含大写字母和小写字母的字符串，找到通过这些字母构造成的最长的回文串。
 * 在构造过程中，请注意区分大小写。比如 "Aa" 不能当做一个回文字符串。
 * 假设字符串的长度不会超过 1010。
 */
public class LongestPalindrome {
    public static void main(String[] args) {
        String s = "abccccdd";
        System.out.println(longestPalindrome2(s));

    }

    public static int longestPalindrome(String s) {
        int res = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        for (Character key : map.keySet()) {
            if (map.get(key) % 2 == 0) {
                res += map.get(key);
            } else {
                res += map.get(key) - 1;
            }
        }
        return res < s.length() ? res + 1 : res;

    }

    public static int longestPalindrome2(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        int res = 0;
        for (Character key : map.keySet()) {
            if (map.get(key) % 2 == 0) {
                res += map.get(key);
            } else {
                res += map.get(key) - 1;
            }
        }
        return res < s.length() ? res + 1 : res;

    }

}
