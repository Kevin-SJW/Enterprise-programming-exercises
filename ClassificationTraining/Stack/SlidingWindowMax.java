package ClassificationTraining.Stack;

import java.util.Arrays;

/**
 * @Classname SlidingWindowMax
 * @Description TODO
 * @Date 2020/8/19 1:01
 * @Created by Administrator
 * 窗口大小为k
 */
public class SlidingWindowMax {
    public int[] maxSlidingWindow(int[] nums, int k) {

        if (nums.length == 0) {
            return new int[]{};
        }
        int len = nums.length + 1 - k;
        int[] res = new int[len];
        for (int i = 0; i < len; i++) {
            res[i] = Arrays.stream(nums, i, i + k).max().getAsInt();
        }
        return res;
    }
}
//    int numLen = nums.length;
//        if (numLen == 0) return new int[0];
//    int[] ans = new int[numLen - k + 1]; // 保存结果
//    int left = 0; // 左指针
//    int right = k - 1; // 右指针
//    int max = -1; // 最大值指针
//
//        while (right < numLen) {
//        if (max < left) { // 更新最大值
//            max = left;
//            for (int i = left; i <= right; i++) {
//                max = nums[max] < nums[i] ? i : max;
//            }
//        }
//        else
//            max = nums[max] < nums[right] ? right : max; // 更新最大值
//        ans[left] = nums[max];
//        left++;
//        right++;
//    }
//        return ans;


