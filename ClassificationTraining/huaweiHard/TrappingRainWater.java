package ClassificationTraining.huaweiHard;

/**
 * @Classname TrappingRainWater
 * @Description TODO
 * @Date 2020/8/28 23:59
 * @Created by Administrator
 * 接雨水-双指针
 */
public class TrappingRainWater {
    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(trap2(nums));

    }

    public static int trap(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int left = 0;
        int right = height.length - 1;
        int left_max = 0;
        int right_max = 0;
        int res = 0;
        while (left < right) {
            if (height[left] < height[right]) {
                if (height[left] < left_max) {
                    res += left_max - height[left];
                } else {
                    left_max = height[left];
                }
                left++;
            } else {
                if (height[right] < right_max) {
                    res += right_max - height[right];
                } else {
                    right_max = height[right];
                }
                right--;
            }
        }
        return res;
    }

    public static int trap2(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int res = 0;
        int left_max = 0;
        int right_max = 0;
        int left = 0;
        int right = height.length - 1;
        while (left < right) {
            if (height[left] < height[right]) {
                if (height[left] < left_max) {
                    res += left_max - height[left];
                } else {
                    left_max = height[left];
                }
                left++;
            } else {
                if (height[right] < right_max) {
                    res += right_max - height[right];
                } else {
                    right_max = height[right];
                }
                right--;
            }
        }
        return res;
    }
}
