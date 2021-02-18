package ClassificationTraining.Array;

/**
 * 输入：A = [0,6,5,2,2,5,1,9,4], L = 1, M = 2
 * 输出：20
 * 解释：子数组的一种选择中，[9] 长度为 1，[6,5] 长度为 2。
 */
public class TwoNonOverlapSubArraySumMax {
    public static void main(String[] args) {
        int[] A = {0, 6, 5, 2, 2, 5, 1, 9, 4};
        int l = 1, m = 2;
        System.out.println(maxSumTwoNoOverlap(A, l, m));
    }

    public static int maxSumTwoNoOverlap(int[] A, int L, int M) {
        int a = maxFunc(A, L, M);
        int b = maxFunc(A, M, L);
        return Math.max(a, b);
    }

    public static int maxFunc(int[] A, int L, int M) {
        if (L + M > A.length) {
            return -1;
        }
        int i, j;
        int max = 0;
        int ret1 = 0;//滑动窗口部分和
        for (i = 0; i < L - 1; i++) {
            ret1 += A[i];
        }
        for (; i < A.length - M; i++) {
            ret1 += A[i];
            int ret2 = 0;
            for (j = i + 1; j < i + M; j++) {
                ret2 += A[j];
            }
            for (; j < A.length; j++) {
                ret2 += A[j];
                max = Math.max(max, ret1 + ret2);
                ret2 -= A[j - M + 1];
            }
            ret1 -= A[i - L + 1];
        }
        return max;
    }
}

