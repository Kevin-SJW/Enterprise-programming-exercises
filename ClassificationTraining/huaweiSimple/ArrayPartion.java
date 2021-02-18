package ClassificationTraining.huaweiSimple;

import java.util.Arrays;

/**
 * @Classname ArrayPartion
 * @Description TODO
 * @Date 2020/8/27 0:47
 * @Created by Administrator
 * Given an array of 2n integers, your task is to group these integers into
 * n pairs of integer, say (a1, b1), (a2, b2), ...,
 * (an, bn) which makes sum of min(ai, bi) for all i from 1 to n as large as possible.
 *
 */
public class ArrayPartion {
    public static void main(String[] args) {
        int[] nums={1,4,3,2};
        System.out.println(arrayPairSum(nums));
    }
    public static int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        for (int i = 0; i < nums.length; i += 2) {
            sum += nums[i];
        }
        return sum;
    }
}
