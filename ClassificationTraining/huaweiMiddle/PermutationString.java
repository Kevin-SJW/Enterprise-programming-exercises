package ClassificationTraining.huaweiMiddle;

import java.util.*;

/**
 * @Classname PermutationString
 * @Description TODO
 * @Date 2021/1/2 12:58
 * @Created by Administrator
 */
public class PermutationString {
    public static void main(String[] args) {
        String str = "abc";
        System.out.println(Arrays.deepToString(permutation(str)));
    }

    static List<String> res = new LinkedList<>();
    static char[] c;

    public static String[] permutation(String s) {
        c = s.toCharArray();
        dfs(0);
        return res.toArray(new String[res.size()]);
    }

    static void dfs(int x) {
        if (x == c.length - 1) {
            res.add(String.valueOf(c));
            return;
        }
        Set<Character> set = new HashSet<>();
        for (int i = x; i < c.length; i++) {
            if (set.contains(c[i])) {
                continue;
            }
            set.add(c[i]);
            swap(i, x);
            dfs(x + 1);
            swap(i, x);
        }
    }
    static void swap(int a, int b) {
        char temp = c[a];
        c[a] = c[b];
        c[b] = temp;
    }
}
