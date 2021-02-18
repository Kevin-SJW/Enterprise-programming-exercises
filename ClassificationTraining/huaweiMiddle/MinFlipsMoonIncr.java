package ClassificationTraining.huaweiMiddle;

/**
 * @Classname MinFlipsMoonIncr
 * @Description TODO
 * @Date 2020/12/24 0:00
 * @Created by Administrator
 * 如果一个由 '0' 和 '1' 组成的字符串，是以一些 '0'（可能没有 '0'）后面跟着一些 '1'（也可能没有 '1'）的形式组成的，那么该字符串是单调递增的。
 * <p>
 * 我们给出一个由字符 '0' 和 '1' 组成的字符串 S，我们可以将任何 '0' 翻转为 '1' 或者将 '1' 翻转为 '0'。
 * <p>
 * 返回使 S 单调递增的最小翻转次数。
 * <p>
 * 示例 1：
 * <p>
 * 输入："00110"
 * 输出：1
 * 解释：我们翻转最后一位得到 00111.
 * <p>
 * dp[i]表示前i个字符所需最小翻转次数，则dp[i+1]有如下四种情况，取其最小值即可
 * 1、第i+1个字符为0，且不翻转，d[i+1]=前i个字符中1的个数
 * 2、第i+1个字符为0，且翻转，d[i+1]=d[i]+1
 * 3、第i+1个字符为1，且不翻转，d[i+1]=d[i]
 * 4、第i+1个字符为1，且翻转，d[i+1]=前i个字符中1的个数+1
 */
public class MinFlipsMoonIncr {
    public static void main(String[] args) {
        String s = "00110";
        System.out.println(minFlipsMonoIncr(s));
    }

    public static int minFlipsMonoIncr(String s) {
        int numOfOne = 0;
        int len = s.length();
        int[] dp = new int[len];
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == '1') {
                dp[i] = (i == 0 ? 0 : Math.min(dp[i - 1], numOfOne + 1));
                numOfOne++;
            } else {
                dp[i] = (i == 0 ? 0 : Math.min(dp[i - 1] + 1, numOfOne));
            }
        }
        return dp[len - 1];
    }
}
