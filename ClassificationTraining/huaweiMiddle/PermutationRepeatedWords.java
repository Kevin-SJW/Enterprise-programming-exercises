package ClassificationTraining.huaweiMiddle;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @Classname PermutationRepeatedWords
 * @Description TODO
 * @Date 2021/1/12 23:33
 * @Created by Administrator
 * 有重复字符串的排列组合。编写一种方法，计算某字符串的所有排列组合。
 * <p>
 * 输入：S = "qqe"
 * 输出：["eqq","qeq","qqe"]
 */
public class PermutationRepeatedWords {
    public static void main(String[] args) {
        String s = "qqe";
        Arrays.stream(permutation(s)).forEach(t -> System.out.print(t + " "));
    }

    public static String[] permutation(String s) {
        Set<String> res = new HashSet<>();
        combination(res, s, new StringBuilder(), new boolean[s.length()]);
        return res.toArray(new String[res.size()]);
    }

    public static void combination(Set<String> res, String s,
                                   StringBuilder sb, boolean[] marked) {
        if (sb.length() == s.length()) {
            res.add(sb.toString());
            return;
        }
        for (int i = 0; i < s.length(); i++) {
            if (!marked[i]) {
                marked[i] = true;
                sb.append(s.charAt(i));
                combination(res, s, sb, marked);
                sb.deleteCharAt(sb.length()-1);
                marked[i] = false;
            }
        }
    }
}
