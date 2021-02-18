package ClassificationTraining.huaweiSimple;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @Classname FindShortestSubArray
 * @Description TODO
 * @Date 2020/9/16 23:42
 * @Created by Administrator
 * 给定一个非空且只包含非负数的整数数组 nums, 数组的度的定义是指数组里任一元素出现频数的最大值。
 * <p>
 * 你的任务是找到与 nums 拥有相同大小的度的最短连续子数组，返回其长度。
 */
public class FindShortestSubArray {
    public static void main(String[] args) {
        int[] nums = {1, 2, 2, 3, 1};
        System.out.println(findShortestSubArray(nums));

    }

    public static int findShortestSubArray(int[] nums) {

        Map<Integer, Integer> start = new HashMap<>();
        Map<Integer, Integer> end = new HashMap<>();
        Map<Integer, Integer> freq = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            start.putIfAbsent(nums[i], i);
            end.put(nums[i], i);
            freq.put(nums[i], freq.getOrDefault(nums[i], 0) + 1);

        }
        int ans = nums.length;
        int degree = Collections.max(freq.values());
        for (int key : freq.keySet()) {
            if (freq.get(key) == degree) {
                ans = Math.min(ans, end.get(key) - start.get(key) + 1);
            }
        }
        return ans;
    }
}
