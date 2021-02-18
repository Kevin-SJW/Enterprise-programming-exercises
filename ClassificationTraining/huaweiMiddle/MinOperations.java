package ClassificationTraining.huaweiMiddle;

import java.util.Arrays;

/**
 * @Classname MinOperations
 * @Description TODO
 * @Date 2020/11/22 11:22
 * @Created by Administrator
 * 给你一个整数数组 nums 和一个整数 x 。每一次操作时，你应当移除数组 nums 最左边或最右边的元素，
 * 然后从 x 中减去该元素的值。请注意，需要 修改 数组以供接下来的操作使用。
 * 如果可以将 x 恰好 减到 0 ，返回 最小操作数 ；否则，返回 -1 。
 * 输入：nums = [1,1,4,2,3], x = 5
 * 输出：2
 * 解释：最佳解决方案是移除后两个元素，将 x 减到 0 。
 */
public class MinOperations {
    public static void main(String[] args) {
        int[] nums = {1, 1, 4, 2, 3};
        int x = 5;
        System.out.println(minOperations(nums, x));
    }

    public static int minOperations(int[] nums, int x) {
        int left = 0;
        int right = 0;
        int maxPart = -1;
        int currentSum = 0;
        int sum = Arrays.stream(nums).sum();
        int target = sum - x;
        while (left < nums.length && right < nums.length) {
            currentSum += nums[right];
            if (right<nums.length) {
                right++;
            }
            while (currentSum > left && left <= right) {
                currentSum -=nums[left];
                left++;
            }
            if (currentSum == target) {
                maxPart = Math.max(maxPart, right - left);
            }
        }
        return maxPart==-1?-1:nums.length-maxPart;

    }
}
