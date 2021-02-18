package ClassificationTraining.Dp;

/**
 * @Classname FrogLadderJump
 * @Description TODO
 * @Date 2020/9/30 0:14
 * @Created by Administrator
 */
public class FrogLadderJump {
    public static void main(String[] args) {
        int n = 7;
        System.out.println(numWays(n));

    }

    public static int numWays(int n) {
        if (n<=1) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
            dp[i]=dp[i]%1000000007;
        }

        return dp[n];

    }
}
