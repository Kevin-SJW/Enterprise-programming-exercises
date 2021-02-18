package ClassificationTraining.huaweiMiddle;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname CanPartionKSubsets
 * @Description TODO
 * @Date 2020/10/2 10:00
 * @Created by Administrator
 * 给定一个整数数组  nums 和一个正整数 k，找出是否有可能把这个数组分成 k 个非空子集，其总和都相等。
 * <p>
 * 示例 1：
 * <p>
 * 输入： nums = [4, 3, 2, 3, 5, 2, 1], k = 4
 * 输出： True
 * 说明： 有可能将其分成 4 个子集（5），（1,4），（2,3），（2,3）等于总和。
 */
public class CanPartionKSubsets {
    public static void main(String[] args) {
        int[] nums = {4, 3, 2, 3, 5, 2, 1};
        System.out.println(getSubSets(nums).toString());
        int k = 4;
        System.out.println(canPartitionKSubsets(nums, k));

    }

    public static boolean canPartitionKSubsets(int[] nums, int k) {
        return false;
    }

    public static List<List<Integer>> getSubSets(int[] nums){
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<Integer>());
        for (int num : nums) {
            int size = res.size();
            for (int i = 0; i < size; i++) {
                List<Integer> copyItem = new ArrayList<>(res.get(i));
                copyItem.add(num);
                res.add(copyItem);
            }
        }
        return res;
    }
}
