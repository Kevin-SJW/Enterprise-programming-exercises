package ClassificationTraining.huaweiSimple;

import java.util.Arrays;

/**
 * @Classname RotateArray
 * @Description TODO
 * @Date 2020/8/26 23:47
 * @Created by Administrator
 */
public class RotateArray {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        int k = 3;
        Arrays.stream(nums).forEach(t -> System.out.print(t + "　"));
        rotate(nums, k);
        System.out.println();
        Arrays.stream(nums).forEach(t -> System.out.print(t + "　"));
    }

    public static void rotate(int[] nums, int k) {
        int previous;
        for (int i = 0; i < k; i++) {
            previous = nums[nums.length - 1];
            for (int j = 0; j < nums.length; j++) {
                int temp = nums[j];
                nums[j] = previous;
                previous = temp;
            }
        }
    }
}
