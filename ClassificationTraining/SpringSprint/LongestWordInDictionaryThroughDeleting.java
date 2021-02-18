package ClassificationTraining.SpringSprint;

import java.util.Arrays;
import java.util.List;

/**
 * @Classname LongestWordInDictionaryThroughDeleting
 * @Description TODO
 * @Date 2021/2/11 10:19
 * @Created by Administrator
 * 给定一个字符串和一个字符串字典，找到字典里面最长的字符串，该字符串可以通过删除给定字符串的某些字符来得到。
 * 如果答案不止一个，返回长度最长且字典顺序最小的字符串。如果答案不存在，则返回空字符串。
 * 输入:
 * s = "abpcplea", d = ["ale","apple","monkey","plea"]
 * 输出:
 * "apple"
 */
public class LongestWordInDictionaryThroughDeleting {
    public static void main(String[] args) {
        String s = "abpcplea";
        List<String> d = Arrays.asList("ale", "apple", "monkey", "plea");
        System.out.println(findLongestWord(s, d));
    }
    public static String findLongestWord(String s, List<String> d) {
        String res = "";
        for (String target : d) {
            int l1 = res.length(), l2 = target.length();
            if (l1 > l2 || l1 == l2 && res.compareTo(target) < 0) {
                continue;
            }
            if (isSubStr(s, target)) {
                res = target;
            }
        }
        return res;
    }
    public static boolean isSubStr(String s, String target) {
        int i = 0, j = 0;
        while (i < s.length() && j < target.length()) {
            if (s.charAt(i) == target.charAt(j)) {
                j++;
            }
            i++;
            if (j == target.length()) {
                return true;
            }
        }
        return false;
    }
}
