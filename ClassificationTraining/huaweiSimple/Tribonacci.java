package ClassificationTraining.huaweiSimple;

/**
 * @Classname Tribonacci
 * @Description TODO
 * @Date 2020/10/1 13:06
 * @Created by Administrator
 */
public class Tribonacci {
    public static void main(String[] args) {
        int n = 4;
        System.out.println(tribonacci(n));

    }

    public static int tribonacci(int n) {
        if (n == 0) {
            return 0;
        }
        if (n <= 2) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 3] + dp[i - 2] + dp[i-1];
        }
        return dp[n];

    }
}
