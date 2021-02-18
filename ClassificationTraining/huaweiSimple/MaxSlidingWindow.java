package ClassificationTraining.huaweiSimple;

import java.util.Arrays;

/**
 * @Classname MaxSlidingWindow
 * @Description TODO
 * @Date 2020/10/9 23:57
 * @Created by Administrator
 */
public class MaxSlidingWindow {
    public static void main(String[] args) {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        Arrays.stream(maxSlidingWindow(nums, k)).forEach(t -> System.out.print(t + " "));

    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return new int[]{};
        }
        int len = nums.length - k + 1;
        int[] res = new int[len];
        for (int i = 0; i < len; i++) {
            res[i] = Arrays.stream(nums, i, i + k).max().getAsInt();

        }
        return res;
    }
}
