package ClassificationTraining.huaweiMiddle;

import java.util.Arrays;

/**
 * @Classname WiggleSort2
 * @Description TODO
 * @Date 2020/9/6 22:39
 * @Created by Administrator
 */
public class WiggleSort2 {
    public void wiggleSort(int[] nums) {
        if (nums == null || nums.length <= 1) return;
        int[] val = Arrays.copyOf(nums, nums.length);
        Arrays.sort(val);
        int index = nums.length - 1;
        for (int i = 1; i < nums.length; i += 2) {
            nums[i] = val[index--];
        }
        for (int i = 0; i < nums.length; i += 2) {
            nums[i] = val[index--];
        }
    }
}
