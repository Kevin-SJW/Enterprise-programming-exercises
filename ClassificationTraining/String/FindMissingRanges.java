package ClassificationTraining.String;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname FindMissingRanges
 * @Description TODO
 * @Date 2020/9/26 11:39
 * @Created by Administrator
 * 给定一个排序的整数数组 nums ，其中元素的范围在 闭区间 [lower, upper] 当中，
 * 返回不包含在数组中的缺失区间。
 * <p>
 * 示例：
 * <p>
 * 输入: nums = [0, 1, 3, 50, 75], lower = 0 和 upper = 99,
 * 输出: ["2", "4->49", "51->74", "76->99"]
 * 。
 */
public class FindMissingRanges {
    public static void main(String[] args) {
        int[] nums = {0, 1, 3, 50, 75};
        int lower = 0, upper = 99;
        findMissingRanges2(nums, lower, upper).stream().forEach(t -> System.out.print(t + " "));

    }

    public static List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> ans = new ArrayList<>();
        long pre = (long) lower - 1;    // 防止 lower 就是 int 最小值，减一就直接溢出了
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] - pre == 2) {
                ans.add(String.valueOf(pre + 1));
            } else if (nums[i] - pre >= 3) {
                ans.add((pre + 1) + "->" + (nums[i] - 1));
            }
            pre = nums[i]; // 'int' to 'long'
        }
        if (upper - pre == 1) {
            ans.add(String.valueOf(pre + 1));
        } else if (upper - pre >= 2) {
            ans.add((pre + 1) + "->" + upper);
        }
        return ans;

    }

    public static List<String> findMissingRanges2(int[] nums, int lower, int upper) {
        List<String> ans = new ArrayList<>();
        long pre = (long) lower - 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] - pre == 2) {
                ans.add(String.valueOf(pre + 1));
            } else if (nums[i] - pre >= 3) {
                ans.add((pre + 1) + "->" + (nums[i] - 1));
            }
            pre = nums[i];
        }
        if (upper - pre == 1) {
            ans.add(String.valueOf(pre + 1));
        } else if ((upper - pre) >= 2) {
            ans.add((pre + 1) + "->" + (upper));
        }
        return ans;

    }
}
