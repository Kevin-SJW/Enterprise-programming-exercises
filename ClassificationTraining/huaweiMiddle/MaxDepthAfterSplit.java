package ClassificationTraining.huaweiMiddle;

import java.util.Arrays;

/**
 * @Classname MaxDepthAfterSplit
 * @Description TODO
 * @Date 2020/9/18 23:41
 * @Created by Administrator
 * 输入：seq = "(()())"
 * 输出：[0,1,1,1,1,0]
 */
public class MaxDepthAfterSplit {
    public static void main(String[] args) {
        String seq = "(()())";
        Arrays.stream(maxDepthAfterSplit(seq)).forEach(t -> System.out.print(t + " "));

    }

    public static int[] maxDepthAfterSplit(String seq) {
        int[] ans = new int[seq.length()];
        int depth = 0;
        for (int i = 0; i < seq.length(); i++) {
            char c = seq.charAt(i);

            if (c == '(') {
                ans[i] = depth % 2;
                depth++;

            } else {
                depth--;
                ans[i] = depth % 2;
            }
        }

        return ans;
    }

    public static int[] maxDepthAfterSplit2(String seq) {
        int[] ans = new int[seq.length()];
        int depth = 0;
        for (int i = 0; i < seq.length(); i++) {
            char c = seq.charAt(i);
            if (c == '(') {

                ans[i] = depth % 2;
                depth++;
            } else {
                depth--;
                ans[i] = depth % 2;
            }
        }
        return ans;
    }
}

