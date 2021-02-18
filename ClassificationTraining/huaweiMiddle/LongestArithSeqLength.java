package ClassificationTraining.huaweiMiddle;

/**
 * @Classname LongestArithSeqLength
 * @Description TODO
 * @Date 2021/1/15 23:15
 * @Created by Administrator
 * 给定一个整数数组 A，返回 A 中最长等差子序列的长度。
 * 回想一下，A 的子序列是列表 A[i_1], A[i_2], ..., A[i_k]
 * 其中 0 <= i_1 < i_2 < ... < i_k <= A.length - 1。
 * 并且如果 B[i+1] - B[i]( 0 <= i < B.length - 1) 的值都相同，
 * 那么序列 B 是等差的。
 * <p>
 * 输入：[3,6,9,12]
 * 输出：4
 * 解释：
 * 整个数组是公差为 3 的等差数列。
 */
public class LongestArithSeqLength {
    public static void main(String[] args) {
        int[] A = {3, 6, 9, 12};
        System.out.println(longestArithSeqLength(A));
    }

    public static int longestArithSeqLength(int[] A) {
        int[][] d = new int[A.length][20001];
        int res = 0;
        int putInPlace = 10000;
        for (int i = 1; i < A.length; i++) {
            for (int j = 0; j < i; j++) {
                int cha = A[i] - A[j] < 0 ? A[j] - A[i] + putInPlace : A[i] - A[j];
                d[i][cha] = d[j][cha] + 1;
                res = Math.max(res, d[i][cha]);
            }
        }
        return res+1;
    }
}
