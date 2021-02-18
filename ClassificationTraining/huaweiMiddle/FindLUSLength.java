package ClassificationTraining.huaweiMiddle;

import java.util.Arrays;

/**
 * @Classname FindLUSLength
 * @Description TODO
 * @Date 2020/12/29 23:20
 * @Created by Administrator
 * 给定字符串列表，你需要从它们中找出最长的特殊序列。最长特殊序列定义如下：
 * 该序列为某字符串独有的最长子序列（即不能是其他字符串的子序列）。
 * 子序列可以通过删去字符串中的某些字符实现，但不能改变剩余字符的相对顺序。
 * 空序列为所有字符串的子序列，任何字符串为其自身的子序列。
 * 输入将是一个字符串列表，输出是最长特殊序列的长度。如果最长特殊序列不存在，返回 -1 。
 * 输入: "aba", "cdc", "eae"
 * 输出: 3
 * 如果字符串中某一序列是特殊序列，由于字符串长度大于等于其子序列的长度，那么该字符串也必定是特殊序列。
 * 基于这个事实，如果存在最长特殊序列，那么一定是strs中完整的字符串而不是其中的序列，
 * 那么只需要验证strs中某一字符串是否是其他字符串的子序列，如果不是，那么该字符串是一个特殊序列。
 */
public class FindLUSLength {
    public static void main(String[] args) {
        String[] strs = {"aba", "cdc", "eae"};
        System.out.println(findLUSlength(strs));

    }

    public static int findLUSlength(String[] strs) {
        Arrays.sort(strs, (a, b) -> b.length() - a.length());
        for (int i = 0; i < strs.length; i++) {
            int j = 0;
            for (; j < strs.length; j++) {
                if (i != j && isSubsequence(strs[i], strs[j])) {
                    break;
                }
            }
            if (j == strs.length) {
                return strs[i].length();
            }
        }
        return -1;
    }
    private static boolean isSubsequence(String s1, String s2) {
        int index = -1;
        for (int i = 0; i < s1.length(); i++) {
            char c = s1.charAt(i);
            index = s2.indexOf(c, index + 1);
            if (index == -1) {
                return false;
            }
        }
        return true;
    }
}
