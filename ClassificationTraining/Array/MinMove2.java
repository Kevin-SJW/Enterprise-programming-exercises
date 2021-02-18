package ClassificationTraining.Array;

import java.util.Arrays;

/**
 * @Classname MinMove2
 * @Description TODO
 * @Date 2020/9/28 0:05
 * @Created by Administrator
 * 给定一个非空整数数组，找到使所有数组元素相等所需的最小移动数，
 * 其中每次移动可将选定的一个元素加1或减1。 您可以假设数组的长度最多为10000。
 * 输入:
 * [1,2,3]
 * <p>
 * 输出:
 * 2
 * <p>
 * 说明：
 * 只有两个动作是必要的（记得每一步仅可使其中一个元素加1或减1）：
 * [1,2,3]  =>  [2,2,3]  =>  [2,2,2]
 */
public class MinMove2 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println(minMoves2(nums));

    }

    public static int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        for (int num : nums) {
            sum += Math.abs(nums[nums.length / 2] - num);
        }
        return sum;

    }

    /**
     * 最小操作次数
     *
     * @param nums
     * @return
     */
    public static int minMoves3(int[] nums) {
        Arrays.sort(nums);
        int s = 0;
        for (int i = 0; i < nums.length; i++) {
            s += nums[i] - nums[0];
        }
        return s;
    }
}
