package ClassificationTraining.huaweiMiddle;

/**
 * @Classname MinimumSizeSubArray
 * @Description TODO
 * @Date 2020/8/27 0:04
 * @Created by Administrator
 */
public class MinimumSizeSubArray {
    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 2, 4, 3};
        int s = 7;
        System.out.println(minSubArrayLen(s, nums));
    }
    public static int minSubArrayLen(int s, int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int res = 0;

            for (int j = i; j < nums.length; j++) {
                res += nums[j];
                if (res >= s) {
                    min = Math.min(min, j - i + 1);
                    break;
                }
            }
        }
        return min==Integer.MAX_VALUE?0:min;
    }
}
