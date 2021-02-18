package ClassificationTraining.huaweiMiddle;

import java.util.Arrays;

/**
 * @Classname FirstAndLastPositionOfElementInSortedArray
 * @Description TODO
 * @Date 2020/8/25 23:44
 * @Created by Administrator
 */
public class FirstAndLastPositionOfElementInSortedArray {
    public static void main(String[] args) {
        int[] nums = {5, 7, 7, 8, 8, 10};
        int target = 8;
        Arrays.stream(searchRange(nums, target))
                .forEach(t -> System.out.print(t + " "));
    }
    public static int[] searchRange(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                //nums[mid]=target
                while (nums[left] != target) {
                    left++;
                }
                while (nums[right] != target) {
                    right--;
                }
                return new int[]{left, right};
            }
        }
        return new int[]{-1, -1};

    }
}
