package ClassificationTraining.huaweiMiddle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Classname CheckInclusion
 * @Description TODO
 * @Date 2020/11/27 0:23
 * @Created by Administrator
 * 给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的排列。
 * 换句话说，第一个字符串的排列之一是第二个字符串的子串。
 */
public class CheckInclusion {
    public static void main(String[] args) {
        String s1 = "ab", s2 = "eidbaooo";
        System.out.println(checkInclusion3(s1, s2));

    }

    public static boolean checkInclusion2(String s1, String s2) {
        if (s1.length() > s2.length())
            return false;
        int[] needs = new int[26];
        int[] res = new int[26];
        int len1 = s1.length();
        int len2 = s2.length();
        for (int i = 0; i < len1; i++) {
            needs[s1.charAt(i) - 'a']++;
            res[s2.charAt(i) - 'a']++;
        }
        for (int i = 0; i < len2 - len1; i++) {
            if (Arrays.equals(res, needs))
                return true;
            res[s2.charAt(i + len1) - 'a']++;
            res[s2.charAt(i) - 'a']--;
        }
        return Arrays.equals(res, needs);
    }

    public static boolean checkInclusion3(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }
        int[] s1Map = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            s1Map[s1.charAt(i) - 'a']++;
        }
        for (int i = 0; i < s2.length() - s1.length(); i++) {
            int[] s2Map = new int[26];
            for (int j = 0; j < s1.length(); j++) {
                s2Map[s2.charAt(i + j) - 'a']++;
            }
            if (matched(s1Map, s2Map)) {
                return true;
            }
        }
        return false;
    }

    public static boolean matched(int[] s1Map, int[] s2Map) {
        for (int i = 0; i < 26; i++) {
            if (s1Map[i] != s2Map[i]) {
                return false;
            }
        }
        return true;
    }


    public static boolean checkInclusion(String s1, String s2) {
        List<String> list = getSubString(s2);
        String[] str = permutation(s1);
        for (String s : str) {
            if (list.contains(s)) {
                return true;
            }
        }
        return false;

    }

    public static List<String> getSubString(String s) {
        List<String> res = new ArrayList<>();
        if (s == null) {
            return new ArrayList<>();
        }
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j < s.length() - 1; j++) {
                res.add(s.substring(i, j));
            }
        }
        return res;
    }

    public static String[] permutation(String s) {
        if (s == null || s.length() == 0) {
            return new String[0];
        }
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        char[] chars = s.toCharArray();
        dfs(chars, new boolean[chars.length], res, sb);
        return res.toArray(new String[res.size()]);


    }

    public static void dfs(char[] chars, boolean[] visited, List<String> res,
                           StringBuilder sb) {
        if (sb.length() == chars.length) {
            res.add(sb.toString());
            return;
        }
        for (int i = 0; i < chars.length; i++) {
            if (!visited[i]) {
                sb.append(chars[i]);
                visited[i] = true;
                dfs(chars, visited, res, sb);
                sb.deleteCharAt(sb.length() - 1);
                visited[i] = false;
            }
        }

    }


}
