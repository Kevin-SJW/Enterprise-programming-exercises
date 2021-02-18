package ClassificationTraining.huaweiMiddle;

/**
 * @Classname FindMaxConsecutiveOnes
 * @Description TODO
 * @Date 2021/1/12 0:05
 * @Created by Administrator
 * 给定一个二进制数组，你可以最多将 1 个 0 翻转为 1，找出其中最大连续 1 的个数。
 * <p>
 * 示例 1：
 * <p>
 * 输入：[1,0,1,1,0]
 * 输出：4
 * 解释：翻转第一个 0 可以得到最长的连续 1。
 *      当翻转以后，最大连续 1 的个数为 4。
 */
public class FindMaxConsecutiveOnes {
    public static void main(String[] args) {
        int[] nums = {1, 0, 1, 1, 0};
        System.out.println(findMaxConsecutiveOnes(nums));

    }

    public static int findMaxConsecutiveOnes(int[] nums) {
        int l, r, c = 0;
        for (l = 0, r = 0; r < nums.length; ++r) {
            c += nums[r];
            if (r - l + 1 > c + 1) {
                c -= nums[l++];
            }
        }
        return r - l;
    }
}
