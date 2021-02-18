package ClassificationTraining.huaweiMiddle;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Classname MaxVowels
 * @Description TODO
 * @Date 2020/10/5 16:15
 * @Created by Administrator
 * 给你字符串 s 和整数 k 。
 * <p>
 * 请返回字符串 s 中长度为 k 的单个子字符串中可能包含的最大元音字母数。
 * <p>
 * 英文中的 元音字母 为（a, e, i, o, u）。
 * <p>
 * 输入：s = "abciiidef", k = 3
 * 输出：3
 * 解释：子字符串 "iii" 包含 3 个元音字母。
 */
public class MaxVowels {

    public static void main(String[] args) {
        String s = "abciiidef";
        String s2 = "leetcode";
        int k = 3;
        System.out.println(maxVowels(s, k));

    }

    public static int maxVowels(String s, int k) {
        List<Character> vowelList = new ArrayList<>();
        vowelList.add('a');
        vowelList.add('e');
        vowelList.add('i');
        vowelList.add('o');
        vowelList.add('u');
        List<String> subList = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j < s.length(); j++) {
                String str = s.substring(i, j);
                if (str.length() == k) {
                    subList.add(str);
                }
            }
        }

        int max = 0;
        for (int i = 0; i < subList.size(); i++) {
            int count = 0;
            for (int j = 1; j <= k; j++) {
                if (vowelList.contains(subList.get(i).charAt(j - 1))) {
                    count++;
                }
                max = Math.max(max, count);
            }

        }
        return max;
    }

    public static int maxVowels2(String s, int k) {
        Set<Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        int n = s.length();
        int count = 0;
        for (int i = 0; i < k; i++) {
            if (set.contains(s.charAt(i))) {
                count++;
            }
        }
        int max = count;
        for (int i = k; i < n; i++) {
            if (set.contains(s.charAt(i)) && !set.contains(s.charAt(i - k))) {
                count++;
                max = Math.max(count, max);
            } else if (!set.contains(s.charAt(i)) && set.contains(s.charAt(i - k))) {
                count--;
            }
        }
        return max;
    }
}
