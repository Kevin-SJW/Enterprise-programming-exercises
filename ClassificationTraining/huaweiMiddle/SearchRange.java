package ClassificationTraining.huaweiMiddle;

/**
 * @Classname SearchRange
 * @Description TODO
 * @Date 2020/8/30 18:23
 * @Created by Administrator
 * 在排序数组中查找元素的第一个和最后一个位置
 */
public class SearchRange {
    public int[] searchRange(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (target > nums[mid]) {
                left = mid + 1;
            } else if (target < nums[mid]) {
                right = mid - 1;
            } else {//target==nums[mid]
                while (nums[left] != target) left++;
                while (nums[right] != target) right--;
                return new int[]{left, right};
            }
        }
        return new int[]{-1, -1};
    }
}
