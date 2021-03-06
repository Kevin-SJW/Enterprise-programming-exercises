package ClassificationTraining.huaweiMiddle;

/**
 * @Classname MaxRepeatSubArray
 * @Description TODO
 * @Date 2020/9/16 0:11
 * @Created by Administrator
 */
public class MaxRepeatSubArray {
    public static void main(String[] args) {
        int[] A = {1, 2, 3, 2, 1};
        int[] B = {3, 2, 1, 4, 7};
        System.out.println(findLength(A, B));

    }

    public static int findLength(int[] A, int[] B) {
        int m = A.length;
        int n = B.length;
        int ans = 0;
        int[][] dp = new int[m + 1][n + 1];
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                dp[i][j] = A[i] == B[j] ? dp[i + 1][j + 1]+1: 0;
                ans = Math.max(ans, dp[i][j]);
            }
        }
        return ans;
    }
}
