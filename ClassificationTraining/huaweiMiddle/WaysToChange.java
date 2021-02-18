package ClassificationTraining.huaweiMiddle;

/**
 * 硬币。给定数量不限的硬币，币值为25分、10分、5分和1分，编写代码计算n分有几种表示法。
 * (结果可能会很大，你需要将结果模上1000000007)
 * 示例1:
 * 输入: n = 5
 * 输出：2
 * 解释: 有两种方式可以凑成总金额:
 * 5=5
 * 5=1+1+1+1+1
 */
public class WaysToChange {
    public static void main(String[] args) {
        int n = 5;
        System.out.println(waysToChange(n));
    }
    public static int waysToChange(int n) {
        int[] coins = {25, 10, 5, 1};
        return coinsChange(n, coins);
    }
    public static int coinsChange(int amount, int[] coins) {
        if(amount==0||coins==null){
            return 0;
        }
        int n = coins.length;
        int[][] dp = new int[n + 1][amount + 1];
        //base case
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= amount; j++) {
                if (j - coins[i - 1] >= 0) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i - 1]]%1000000007;
                } else {
                    dp[i][j] = dp[i - 1][j]%1000000007;
                }
            }
        }
        return dp[n][amount];
    }
}
