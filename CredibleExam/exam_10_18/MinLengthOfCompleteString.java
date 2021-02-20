package CredibleExam.exam_10_18;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @Classname MinLengthOfCompleteString
 * @Description TODO
 * @Date 2020/7/5 22:25
 * @Created by Administrator
 * 3.	（820 单词的压缩编码）给定一个单词列表，我们将这个列表编码成一个索引字符S与一个索引列表A。
 * 例如，如果这个列表是[“time”，“me”，“bell”]，我们就可以将其表示为S=“time#bell#”和indexes=[0,2,5]
 * <p>
 * 单词列表是 [“time”, “me”, “bell”]，“me” 是 “time” 的后缀，编码时就不用再考虑 “me”，
 * “time” 和 “bell” 不是其它单词的后缀，都要编码到索引字符串中，得到 “time#bell#”，长度为 10
 * 目标就是删除单词列表中那些是其它单词的后缀的单词，留下的单词都是要编码到索引字符串中的
 */
public class MinLengthOfCompleteString {
    public static void main(String[] args) {
        String[] words = {"time", "me", "bell"};
        System.out.println(minimumLengthEncoding(words));

    }

    public static int getMinLengthOfCompleteString(String[] words) {
        Set<String> wordSet = new HashSet<>(Arrays.asList(words));
        if (wordSet == null) {
            return 0;
        }
        for (String word : words) {
            for (int i = 1; i < word.length(); i++) {
                wordSet.remove(word.substring(i));
            }
        }
        int length = 0;

        for (String s : wordSet) {
            length += s.length() + 1;
        }

        return length;

    }

    public static int minimumLengthEncoding(String[] words) {

        Set<String> wordSet = new HashSet<>(Arrays.asList(words));
        if (wordSet == null) {
            return 0;
        }
        for (String word : words) {
            for (int i = 1; i < word.length(); i++) {
                wordSet.remove(word.substring(i));
            }
        }
        int ans = 0;
        for (String s : wordSet) {
            ans += s.length() + 1;
        }
        return ans;
    }
}
