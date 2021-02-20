package ClassificationTraining.SpringSprint;

/**
 * 给定一个由整数数组 A 表示的环形数组 C，求 C 的非空子数组的最大可能和。
 * 在此处，环形数组意味着数组的末端将会与开头相连呈环状。
 * （形式上，当0 <= i < A.length 时 C[i] = A[i]，且当 i >= 0 时 C[i+A.length] = C[i]）
 * 此外，子数组最多只能包含固定缓冲区 A 中的每个元素一次。
 * （形式上，对于子数组 C[i], C[i+1], ..., C[j]，不存在 i <= k1, k2 <= j 其中 k1 % A.length = k2 % A.length）
 */
public class MaxSubArraySumCircular {
    public static void main(String[] args) {
        int[] A = {1, -2, 3, -2};
        System.out.println(maxSubarraySumCircular(A));
    }

    public static int maxSubarraySumCircular(int[] A) {
        if (A.length == 1) return A[0];
        int sum = 0;
        for (int val : A) sum += val;
        return Math.max(maxSubarraySum(A), sum - minSubarraySum(A));
    }

    private static int maxSubarraySum(int[] A) {
        int res = A[0], sum = A[0];
        for (int i = 1; i < A.length; i++) {
            sum = Math.max(sum + A[i], A[i]);
            res = Math.max(res, sum);
        }
        return res;
    }

    private static int minSubarraySum(int[] A) {
        int res = A[1], sum = A[1];
        for (int i = 2; i < A.length - 1; i++) {
            sum = Math.min(sum + A[i], A[i]);
            res = Math.min(res, sum);
        }
        return res;
    }
}
