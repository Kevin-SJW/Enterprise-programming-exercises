package ClassificationTraining.huaweiMiddle;

/**
 * @Classname LongestMountain
 * @Description TODO
 * @Date 2020/10/17 20:41
 * @Created by Administrator
 * 我们把数组 A 中符合下列属性的任意连续子数组 B 称为 “山脉”：
 * <p>
 * B.length >= 3
 * 存在 0 < i < B.length - 1 使得 B[0] < B[1] < ... B[i-1] < B[i] > B[i+1] > ... > B[B.length - 1]
 * （注意：B 可以是 A 的任意子数组，包括整个数组 A。）
 * <p>
 * 给出一个整数数组 A，返回最长 “山脉” 的长度。
 * <p>
 * 如果不含有 “山脉” 则返回 0。
 * <p>
 * 先找峰顶，在找两边
 */
public class LongestMountain {
    public static void main(String[] args) {
        int[] A = {2, 1, 4, 7, 3, 2, 5};
        System.out.println(longestMountain2(A));
    }

    public static int longestMountain(int[] A) {
        if (A == null || A.length < 3) {
            return 0;
        }
        int res = 0;
        for (int i = 1; i < A.length - 1; i++) {
            if (A[i] > A[i - 1] && A[i] > A[i + 1]) {
                int left = i - 1, right = i + 1;
                while (left > 0 && A[left] > A[left - 1]) {
                    left--;
                }
                while (right < A.length - 1 && A[right] > A[right + 1]) {
                    right++;
                }
                int len = right - left + 1;
                res = Math.max(res, len >= 3 ? len : 0);

            }

        }
        return res;
    }

    public static int longestMountain2(int[] A) {
        if (A == null || A.length < 3) {
            return 0;
        }
        int res = 0;
        for (int i = 1; i < A.length - 1; i++) {
            if (A[i] > A[i - 1] && A[i] < A[i + 1]) {
                int left = i - 1, right = i + 1;
                while (left > 0 && A[left] > A[left - 1]) {
                    left--;
                }
                while (right < A.length - 1 && A[right] > A[right + 1]) {
                    right++;
                }
                int len = right - left + 1;
                res = Math.max(res, len > 3 ? len : 0);
            }
        }
        return res;
    }
}
