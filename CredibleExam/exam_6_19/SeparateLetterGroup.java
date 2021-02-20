package CredibleExam.exam_6_19;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Classname SeparateLetterGroup
 * @Description TODO
 * @Date 2020/7/18 23:36
 * @Created by Administrator
 * 将单词分为更多的连续子串，并且每两个子串之间没有重复的字母，
 * 求出每个子串的长度集合（leetCode 划分字母区间 763）
 */
public class SeparateLetterGroup {

    private static Map<Character, Integer> indexMap = new HashMap<>();

    public static void main(String[] args) {
        String S = "ababcbacadefegdehijhklij";
        Arrays.stream(getGroups(S)).forEach(t -> System.out.print(t + " "));

    }

    public static int[] getGroups(String word) {
        if (word == null || word.length() == 0) {
            return new int[]{0};
        }
        int left = 0;
        int index = 0;
        int[] ans = new int[word.length()];
        for (int i = 0; i < word.length(); i++) {
            indexMap.put(word.charAt(i), i);
        }
        while (left < word.length()) {
            int curMax = getCurIndexMax(word, left);
            ans[index++] = curMax - left + 1;
            left = curMax + 1;
        }
        return Arrays.copyOf(ans, index);
    }

    public static int getCurIndexMax(String word, int curIndex) {
        char curChar = word.charAt(curIndex);
        int curMax = indexMap.get(curChar);
        while (curIndex < curMax) {
            int tempMax = indexMap.get(word.charAt(curIndex));
            curMax = Math.max(curMax, tempMax);
            curIndex++;
        }
        return curMax;
    }
}
