package ClassificationTraining.String;

import java.util.HashMap;

/**
 * @Classname CountNumberOfNiceSubArray
 * @Description TODO
 * @Date 2020/7/29 0:20
 * @Created by Administrator
 * Given an array of integers nums and an integer k.
 * A subarray is called nice if there are k odd numbers on it.
 * <p>
 * Return the number of nice sub-arrays.
 */
public class CountNumberOfNiceSubArray {
    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 1, 1};
        int k = 3;
        System.out.println(numberOfSubarrays(nums, k));

    }

    public static int numberOfSubarrays(int[] nums, int k) {
        int res = 0;
        int sum = 0;
        //map 的键是前缀和，map的值是前缀和出现的次数
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i]&1;
            //当前前缀和是sum，尝试在map中查找是否存在键值是sum-k（前缀和是sum-k），即子序列的和为k
            map.put(sum, map.getOrDefault(sum, 0) + 1);
            res += map.getOrDefault(sum - k, 0);
        }
        return res;
    }

//    public static int numberOfSubarrays(int[] nums, int k) {
//        int start = 0;
//        int end = 0;
//        int res = 0;
//        int count = 0;
//        while (end < nums.length) {
//            if (nums[end] % 2 == 1) {
//                k--;
//                count = 0;
//            }
//            while (k == 0) {
//                if (nums[start] % 2 == 1) {
//                    k++;
//                }
//                start++;
//                count++;
//            }
//            res += count;
//            end++;
//        }
//        return res;
//    }



}
