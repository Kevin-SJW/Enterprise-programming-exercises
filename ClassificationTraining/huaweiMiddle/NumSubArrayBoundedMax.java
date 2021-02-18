package ClassificationTraining.huaweiMiddle;

/**
 * @Classname NumSubArrayBoundedMax
 * @Description TODO
 * @Date 2021/1/13 23:00
 * @Created by Administrator
 * 给定一个元素都是正整数的数组A ，正整数 L 以及 R (L <= R)。
 * 求连续、非空且其中最大元素满足大于等于L 小于等于R的子数组个数。
 * 输入:
 * A = [2, 1, 4, 3],L = 2,R = 3
 * 输出: 3
 * 解释: 满足条件的子数组: [2], [2, 1], [3].
 */
public class NumSubArrayBoundedMax {
    public static void main(String[] args) {
        int[] A = {2, 1, 4, 3};
        int L = 2;
        int R = 3;
        System.out.println(numSubarrayBoundedMax(A, L, R));
    }
    public static int numSubarrayBoundedMax(int[] A, int L, int R) {
        // l for  the frist element which is smaller or equal L's index
        int l = 0, count = 0, ans = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] > R) {
                // if current element is bigger than R
                // move l to the next of i
                l = i + 1;
                count = 0;
            } else if (A[i] >= L && A[i] <= R) {
                count = i - l + 1;
                ans += count;
            } else {
                ans += count;
            }
        }
        return ans;
    }
}
