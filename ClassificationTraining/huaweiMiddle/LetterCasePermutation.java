package ClassificationTraining.huaweiMiddle;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname LetterCasePermutation
 * @Description TODO
 * @Date 2021/1/7 23:53
 * @Created by Administrator
 * 给定一个字符串S，通过将字符串S中的每个字母转变大小写，我们可以获得一个新的字符串。
 * 返回所有可能得到的字符串集合
 * 输入：S = "a1b2"
 * 输出：["a1b2", "a1B2", "A1b2", "A1B2"]
 * 如果下一个字符 c 是字母，将当前已遍历过的字符串全排列复制两份，
 * 在第一份的每个字符串末尾添加 lowercase(c)，
 * 在第二份的每个字符串末尾添加 uppercase(c)。
 * 如果下一个字符 c 是数字，将 c 直接添加到每个字符串的末尾。
 */
public class LetterCasePermutation {
    public static void main(String[] args) {
        String s = "a1b2";
        letterCasePermutation(s).stream().forEach(t -> System.out.print(t + " "));
    }
    public static List<String> letterCasePermutation(String s) {
        List<StringBuilder> ans = new ArrayList<>();
        ans.add(new StringBuilder());

        for (char c : s.toCharArray()) {
            int n = ans.size();
            if (Character.isLetter(c)) {
                for (int i = 0; i < n; ++i) {
                    ans.add(new StringBuilder(ans.get(i)));
                    ans.get(i).append(Character.toLowerCase(c));
                    ans.get(n + i).append(Character.toUpperCase(c));
                }
            } else {
                for (int j = 0; j < n; ++j) {
                    ans.get(j).append(c);
                }
            }
        }
        List<String> res = new ArrayList<>();
        for (StringBuilder sb : ans) {
            res.add(sb.toString());
        }
        return res;
    }
}
