package ClassificationTraining.Array;

/**
 * @Classname LengthOfLIS
 * @Description TODO
 * @Date 2020/8/1 10:03
 * @Created by Administrator
 */
public class LengthOfLIS {
    public static void main(String[] args) {
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println(lengthOfLIS2(nums));

    }

    public static int lengthOfLIS(int[] nums) {
        int maxLen = 0;
        int[] maxLens = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    maxLens[i] = Math.max(maxLens[j] + 1, maxLens[i]);
                }
            }
            maxLen = Math.max(maxLen, maxLens[i] + 1);
        }
        return maxLen;

    }

    public static int lengthOfLIS2(int[] nums) {
        int maxlen = 0;
        int[] maxLen = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    maxLen[i] = Math.max(maxLen[i], maxLen[j] + 1);
                }
            }
            maxlen = Math.max(maxLen[i] + 1, maxlen);
        }
        return maxlen;

    }
}
