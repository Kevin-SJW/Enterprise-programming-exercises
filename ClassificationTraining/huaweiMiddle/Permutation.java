package ClassificationTraining.huaweiMiddle;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname Permutation
 * @Description TODO
 * @Date 2020/9/13 15:19
 * @Created by Administrator
 */
public class Permutation {
    public static void main(String[] args) {
        String s = "qwe";
        for(String str:permutation(s)){
            System.out.print(str+" ");
        }
    }

    public static String[] permutation(String s) {
        if (s == null || s.length() == 0) {
            return new String[0];
        }
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        char[] chars = s.toCharArray();
        dfs(chars, new boolean[chars.length], res, sb);
        return res.toArray(new String[res.size()]);


    }

    public static void dfs(char[] chars, boolean[] visited, List<String> res,
                           StringBuilder sb) {
        if (sb.length() == chars.length) {
            res.add(sb.toString());
            return;
        }
        for (int i = 0; i < chars.length; i++) {
            if (!visited[i]) {
                sb.append(chars[i]);
                visited[i] = true;
                dfs(chars, visited, res, sb);
                sb.deleteCharAt(sb.length() - 1);
                visited[i] = false;
            }
        }

    }
}
