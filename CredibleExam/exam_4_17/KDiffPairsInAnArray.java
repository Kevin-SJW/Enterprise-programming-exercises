package CredibleExam.exam_4_17;

import java.util.HashSet;

/**
 * @Classname KDiffPairsInAnArray
 * @Description TODO
 * @Date 2020/7/31 0:11
 * @Created by Administrator
 */
public class KDiffPairsInAnArray {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int k = 1;
        System.out.println(findPairs(arr, k));
    }

    public static int findPairs(int[] nums, int k) {
        HashSet<Object> set = new HashSet<>();
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (Math.abs(nums[i] - nums[j]) == k) {
                    //转换思路
                    set.add(nums[i] + nums[j]);
                }
            }
        }
        return set.size();
    }
}
