package ClassificationTraining.huaweiMiddle;

/**
 * @Classname FindMinInRoatedArray
 * @Description TODO
 * @Date 2020/8/26 23:18
 * @Created by Administrator
 */
public class FindMinInRoatedArray {
    public static void main(String[] args) {
        int[] nums={3,4,5,1,2};
        System.out.println(findMin(nums));
    }
    public static int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[left] < nums[right]) {
                return nums[left];
            } else {
                if (nums[left] <= nums[mid]) {
                    left = mid + 1;
                } else {
                    right = mid;
                }

            }
        }
        return nums[left];
    }
}
