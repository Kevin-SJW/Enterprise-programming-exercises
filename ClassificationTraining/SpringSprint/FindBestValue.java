package ClassificationTraining.SpringSprint;

import java.util.Arrays;

/**
 * 给你一个整数数组 arr 和一个目标值 target ，请你返回一个整数 value ，
 * 使得将数组中所有大于 value 的值变成 value 后，数组的和最接近  target （最接近表示两者之差的绝对值最小）。
 * 如果有多种使得和最接近 target 的方案，请你返回这些整数中的最小值。
 * 请注意，答案不一定是 arr 中的数字。
 * 输入：arr = [4,9,3], target = 10
 * 输出：3
 * 解释：当选择 value 为 3 时，数组会变成 [3, 3, 3]，和为 9 ，这是最接近 target 的方案。
 *
 * 对arr升序排序。复杂度O(N \bullet log(N))O(N∙log(N))
 * 求arr的前缀和的过程中，遇到超过答案ans的arr[i]，就可以马上得出答案了（利用单调性，见分析）。此步复杂度：最坏情况O(N)O(N)，最优O(1)
 *
 */
public class FindBestValue {
    public static void main(String[] args) {
        int[] arr = {4, 9, 3};
        int target = 10;
        System.out.println(findBestValue(arr, target));
    }

    public static int findBestValue(int[] arr, int target) {
        Arrays.sort(arr);
        int n = arr.length;
        int k = n, pre = 0;
        for (int a : arr) {
            int d = pre + a * k - target;//前i项和pre + 后k项全置为a 与 target差值
            if (d >= 0) {
                return a - (d + k / 2) / k;//等价于 a - 四舍五入(d÷k) 。
            }
            pre += a;//当d÷k的小数部分为0.5，则取1（注意整体是减去1）符合同近取小原则。
            --k;
        }
        return arr[n - 1];//for循环内无解，取arr[]最大值作为结果。
    }
}
