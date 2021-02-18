package ClassificationTraining.huaweiMiddle;

/**
 * @Classname ConstructKPalindromeString
 * @Description TODO
 * @Date 2021/1/20 23:15
 * @Created by Administrator
 * 给你一个字符串 s 和一个整数 k 。请你用 s 字符串中 所有字符 构造 k 个非空 回文串 。
 * 如果你可以用 s 中所有字符构造 k 个回文字符串，那么请你返回 True ，否则返回 False 。
 * <p>
 * 输入：s = "annabelle", k = 2
 * 输出：true
 * 解释：可以用 s 中所有字符构造 2 个回文字符串。
 * 一些可行的构造方案包括："anna" + "elble"，"anbna" + "elle"，"anellena" + "b"
 */
public class ConstructKPalindromeString {
    public static void main(String[] args) {
        String s = "annabelle";
        int k = 2;
        System.out.println(canConstruct(s, k));

    }

    public static boolean canConstruct(String s, int k) {
        if (k > s.length()) return false;
        int[] arr = new int[26];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            arr[c - 97]++;
        }
        int count = 0;
        for (int i : arr) {
            if (i % 2 == 1) count++;
        }
        return count <= k;
    }
}
