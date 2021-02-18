package ClassificationTraining.Array;

import java.util.Arrays;

/**
 * @Classname NextGreatElement2
 * @Description TODO
 * @Date 2020/9/26 9:08
 * @Created by Administrator
 * 输入: [1,2,1]
 * 输出: [2,-1,2]
 * 解释: 第一个 1 的下一个更大的数是 2；
 * 数字 2 找不到下一个更大的数；
 * 第二个 1 的下一个最大的数需要循环搜索，结果也是 2。
 */
public class NextGreatElement2 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 1};
        Arrays.stream(nextGreaterElements2(nums)).forEach(t -> System.out.print(t + " "));

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
                if (nums[i] < nums[j]) {
                    res[i] = nums[j];
                    break;
                }
                count++;
                j++;
            }
        }
        return res;
    }

    public static int[] nextGreaterElements2(int[] nums) {
        int[] res = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            res[i] = -1;
        }

        for (int i = 0; i < nums.length; i++) {
            int count = 0;
            int j = i + 1;
            while (count < nums.length) {
                j = j % nums.length;
                if (nums[i] < nums[j]) {
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
