package ClassificationTraining.String;

/**
 * @Classname SubArraySumEqualsK
 * @Description TODO
 * @Date 2020/7/29 0:08
 * @Created by Administrator
 */
public class SubArraySumEqualsK {
    public static void main(String[] args) {
        int[] nums = {1, 1, 1};
        int k = 2;
        System.out.println(subarraySum(nums, k));
    }

    public static int subarraySum(int[] nums, int k) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int res = 0;
            for (int j = i; j < nums.length; j++) {
                res += nums[j];
                if (res == k) {
                    count++;
                }
            }
        }
        return count;

    }

    public int subArraySumEqualsK(int[] nums, int k) {
        int[] preSum = new int[nums.length + 1];
        preSum[0] = 0;
        for (int i = 0; i < nums.length; i++) {
            preSum[i] = preSum[i - 1] + nums[i];
        }
        int ans = 0;
        for (int i = 1; i <= nums.length; i++) {
            for (int j = 0; j < i; j++) {
                // sum of nums[j..i-1]
                if (preSum[i] - preSum[j] == k) {
                    ans++;
                }
            }
        }
        return ans;
    }
}
