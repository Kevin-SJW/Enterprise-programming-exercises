package ClassificationTraining.huaweiMiddle;

/**
 * @Classname NumMatchingSubSeq
 * @Description TODO
 * @Date 2021/1/9 0:03
 * @Created by Administrator
 * 给定字符串 S 和单词字典 words, 求 words[i] 中是 S 的子序列的单词个数。
 * <p>
 * 示例:
 * 输入:
 * S = "abcde"
 * words = ["a", "bb", "acd", "ace"]
 * 输出: 3
 * 解释: 有三个是 S 的子序列的单词: "a", "acd", "ace"。
 */
public class NumMatchingSubSeq {
    public static void main(String[] args) {
        String s = "abcde";
        String[] words = {"a", "bb", "acd", "ace"};
        System.out.println(numMatchingSubseq(s,words));
    }

    public static int numMatchingSubseq(String s, String[] words) {
        int count = 0;
        for (String word : words) {
            if (isSubSequence(word, s)) {
                count++;
            }
        }
        return count;
    }

    public static boolean isSubSequence(String a, String b) {
        int index = -1;
        for (char c : a.toCharArray()) {
            index = b.indexOf(c, index + 1);
            if (index == -1) {
                return false;
            }
        }
        return true;
    }
}
