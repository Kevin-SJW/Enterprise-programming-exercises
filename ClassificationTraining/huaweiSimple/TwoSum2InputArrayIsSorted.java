package ClassificationTraining.huaweiSimple;

import java.util.Arrays;

/**
 * @Classname TwoSum2InputArrayIsSorted
 * @Description TODO
 * @Date 2020/8/26 23:29
 * @Created by Administrator
 */
public class TwoSum2InputArrayIsSorted {
    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        Arrays.stream(twoSum(nums, target)).forEach(t -> System.out.print(t + " "));

    }

    public static int[] twoSum(int[] numbers, int target) {

        int l = 0, r = numbers.length - 1;

        while (l < r) {
            if (numbers[l] + numbers[r] == target) {
                int[] res = {l + 1, r + 1};
                return res;
            } else if (numbers[l] + numbers[r] > target) {
                r--;
            } else {
                l++;
            }
        }
        throw new RuntimeException("The input has no solution");
    }
}
