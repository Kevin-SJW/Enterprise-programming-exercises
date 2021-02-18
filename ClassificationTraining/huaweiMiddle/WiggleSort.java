package ClassificationTraining.huaweiMiddle;

import java.util.Arrays;

/**
 * 给你一个无序的数组 nums, 将该数字 原地 重排后使得 nums[0] <= nums[1] >= nums[2] <= nums[3]...。
 * 输入: nums = [3,5,2,1,6,4]
 * 输出: 一个可能的解答是 [3,5,1,6,2,4]
 */
public class WiggleSort {
    public static void main(String[] args) {
        int[] nums = {3, 5, 2, 1, 6, 4};
        Arrays.stream(nums).forEach(t -> System.out.print(t + " "));
        wiggleSort(nums);
        System.out.println();
        Arrays.stream(nums).forEach(t -> System.out.print(t + " "));
    }

    public static void wiggleSort(int[] nums) {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length - 1; i += 2) {
            swap(nums, i, i + 1);
        }
    }

    public static void wiggleSort2(int[] nums) {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i += 2) {
            swap(nums, i, i + 1);
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
