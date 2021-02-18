package ClassificationTraining.huaweiMiddle;

import java.util.*;

/**
 * @Classname FindAnagrams
 * @Description TODO
 * @Date 2020/10/5 11:19
 * @Created by Administrator
 * 给定一个字符串 s 和一个非空字符串 p，找到 s 中所有是 p 的字母异位词的子串，返回这些子串的起始索引。
 * 字符串只包含小写英文字母，并且字符串 s 和 p 的长度都不超过 20100。
 * 字母异位词指字母相同，但排列不同的字符串。
 * 不考虑答案输出的顺序。
 * 输入:
 * s: "cbaebabacd" p: "abc"
 * 输出:
 * [0, 6]
 * 起始索引等于 0 的子串是 "cba", 它是 "abc" 的字母异位词。
 * 起始索引等于 6 的子串是 "bac", 它是 "abc" 的字母异位词。
 * 从s的第一个位置开始，以p的长度作为窗口，从左到右遍历截取s，即可得s中所有与p等长的字串，然后与p判断。
 * 判断的话可以使用map记录单词中每个字母出现的次数，出现次数一致的即为异位词；这样一来需要开辟额外的空间资源；
 * 也可转换为数组进行排序，排序后的数组相等的即为异位词，这样的话不用开辟额外的空间，但是相应的在时间复杂度上会比较高。
 */
public class FindAnagrams {
    static Set<String> set = new HashSet<>();

    public static void main(String[] args) {
        String s = "cbaebabacd", p = "abc";
        System.out.println(findAnagrams2(s, p));

        System.out.println();
        char[] a = {'a', 'b', 'b'};
        permutation(a, 0, 2);
        System.out.println(set);
    }
    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        char[] pChar = p.toCharArray();
        Arrays.sort(pChar);
        int pLen = pChar.length;
        for (int i = 0; i < s.length() - pLen + 1; i++) {
            String curr = s.substring(i, i + pLen);
            char[] currChar = curr.toCharArray();
            Arrays.sort(currChar);
            if (Arrays.equals(pChar, currChar)) {
                res.add(i);
            }
        }
        return res;

    }

    public static List<Integer> findAnagrams2(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        int k = p.length();
        char[] pChar = p.toCharArray();
        Arrays.sort(pChar);
        for (int i = 0; i < s.length() - k + 1; i++) {
            String str = s.substring(i, i + k);
            char[] strChar = str.toCharArray();
            Arrays.sort(strChar);
            if (Arrays.equals(pChar, strChar)) {
                ans.add(i);
            }
        }
        return ans;

    }

    //
    public static void permutation(char[] a, int from, int to) {
        if (from > to || a == null || to < 0) {
            return;
        }
        if (from == to) {
            set.add(String.valueOf(a));
        }
        for (int i = from; i <= to; i++) {
            swap(a, i, from);
            permutation(a, from + 1, to);
            swap(a, i, from);
        }


    }

    public static void swap(char[] ch, int from, int to) {

        char temp = ch[from];
        ch[from] = ch[to];
        ch[to] = temp;

    }


}
