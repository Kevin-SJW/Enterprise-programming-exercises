package ClassificationTraining.huaweiSimple;

import java.util.HashMap;
import java.util.Map;

/**
 * @Classname CanPermutePalindrome
 * @Description TODO
 * @Date 2020/11/1 17:29
 * @Created by Administrator
 * 给定一个字符串，判断该字符串中是否可以通过重新排列组合，形成一个回文字符串。
 *
 * 统计字符串 S 每个字符的重复次数，如果有超过 1 个（不包括1个）字符的重复次数为奇数，则返回 false；否则为 true。
 */
public class CanPermutePalindrome {
    public static void main(String[] args) {
        String s = "code";
        System.out.println(canPermutePalindrome(s));

    }

    public static boolean canPermutePalindrome(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int oddCount = 0;
        for (Character key : map.keySet()) {
            if (map.get(key) % 2 != 0) {
                oddCount++;
            }
        }
        return oddCount < 2;
    }
}
