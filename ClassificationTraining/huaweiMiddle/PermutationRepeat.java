package ClassificationTraining.huaweiMiddle;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @Classname PermutationRepeat
 * @Description TODO
 * @Date 2021/2/6 11:36
 * @Created by Administrator
 * 全排列 有重复
 */
public class PermutationRepeat {
    public static void main(String[] args) {
        String s = "qqe";
        System.out.println(Arrays.toString(permutation(s)));
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
