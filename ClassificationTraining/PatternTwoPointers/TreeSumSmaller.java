package ClassificationTraining.PatternTwoPointers;

import java.util.Arrays;

/**
 * @Classname TreeSumSmaller
 * @Description TODO
 * @Date 2020/7/21 23:36
 * medium
 * @Created by Administrator
 * 在连续存储空间中寻找 3 个元素，要求 3 个元素的和小于目标值的个数。
 */
public class TreeSumSmaller {
    public static void main(String[] args) {
        int[] nums = {-2, 0, 1, 3};
        int target = 2;
        System.out.println(threeSumSmaller(nums, target));

    }

    public static int threeSumSmaller(int[] nums, int target) {
        // array 排序
        Arrays.sort(nums);
        //初始化符合条件的个数为 0
        int count = 0;
        //三个数之和，所以遍历到倒数第三个数
        for (int i = 0; i < nums.length - 2; i++) {
            //如果第一个数已经大于目标值，则跳出循环
            if (nums[i] >= target) {
                break;
            }
            //当前值下一个是最小指针, array 最后一个是最大指针
            int left = i + 1;
            int right = nums.length - 1;
            //最小最大指针相交前不断循环
            while (left < right) {
                //当前三个数的和
                int currentSum = nums[i] + nums[left] + nums[right];
                //如果当前和大于等于目标值，则最大值指针左移
                if (currentSum >= target) {
                    right -= 1;
                } else {
                    //小于目标值，则计算最大最小值距离，加到符合个数的统计中
                    count += right - left;
                    break;
                }
            }
        }
        return count;

    }
}
