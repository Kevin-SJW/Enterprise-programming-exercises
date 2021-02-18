package ClassificationTraining.huaweiMiddle;

import java.util.Arrays;

/**
 * @Classname NextGreatElement2
 * @Description TODO
 * @Date 2020/8/28 0:56a
 * @Created by Administrator
 * Given a circular array (the next element of the last element is the first
 * element of the array), print the Next Greater Number for every element.
 * The Next Greater Number of a number x is the first greater number
 * to its traversing-order next in the array,
 * which means you could search circularly to find its next greater number.
 * If it doesn't exist, output -1 for this number.
 */
public class NextGreatElement2 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 1};
        Arrays.stream(nextGreaterElements(nums)).forEach(t -> System.out.print(t + " "));
    }

    public static int[] nextGreaterElements(int[] nums) {
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            res[i] = -1;
        }
        for (int i = 0; i < nums.length; i++) {
            int count = 0;
            int j = i + 1;
            while (count < nums.length) {
                j = j % nums.length;
                if (nums[j] > nums[i]) {
                    res[i] = nums[j];
                    break;
                }
                count++;
                j++;
            }
        }
        return res;
    }
}
