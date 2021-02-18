package ClassificationTraining.huaweiMiddle;

import java.util.HashMap;
import java.util.Map;

/**
 * @Classname FindMaxSubArrayLength
 * @Description TODO
 * @Date 2021/1/1 16:53
 * @Created by Administrator
 * 给定一个二进制数组, 找到含有相同数量的 0 和 1 的最长连续子数组（的长度）。
 * 示例 1:
 * <p>
 * 输入: [0,1]
 * 输出: 2
 * 说明: [0, 1] 是具有相同数量0和1的最长连续子数组。
 */
public class FindMaxSubArrayLength {
    public static void main(String[] args) {
        int[] nums = {0, 1};
        System.out.println(findMaxLength(nums));
    }

    public static int findMaxLength(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int maxlen = 0, count = 0;
        for (int i = 0; i < nums.length; i++) {
            count = count + (nums[i] == 1 ? 1 : -1);
            if (map.containsKey(count)) {
                maxlen = Math.max(maxlen, i - map.get(count));
            } else {
                map.put(count, i);
            }
        }
        return maxlen;
    }


    //暴力
    public static int findMaxLength2(int[] nums) {
        int maxlen = 0;
        for (int i = 0; i < nums.length; i++) {
            int zeroes = 0, ones = 0;
            for (int j = i; j < nums.length; j++) {
                if (nums[j] == 0) {
                    zeroes++;
                } else {
                    ones++;
                }
                if (zeroes == ones) {
                    maxlen = Math.max(maxlen, j - i + 1);
                }
            }
        }
        return maxlen;
    }
}
