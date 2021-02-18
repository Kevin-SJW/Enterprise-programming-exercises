package ClassificationTraining.huaweiMiddle;


import java.util.Arrays;

/**
 * @Classname MaxOperations
 * @Description TODO
 * @Date 2020/12/9 23:48
 * @Created by Administrator
 * 给你一个整数数组 nums 和一个整数 k 。
 * 每一步操作中，你需要从数组中选出和为 k 的两个整数，并将它们移出数组。
 * 返回你可以对数组执行的最大操作数。
 * 输入：nums = [1,2,3,4], k = 5
 * 输出：2
 * 解释：开始时 nums = [1,2,3,4]：
 * - 移出 1 和 4 ，之后 nums = [2,3]
 * - 移出 2 和 3 ，之后 nums = []
 * 不再有和为 5 的数对，因此最多执行 2 次操作。
 */
public class MaxOperations {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        int k = 5;
        System.out.println(maxOperations(nums, k));
    }

    public static int maxOperations(int[] nums, int k) {
        Arrays.sort(nums);
        int l = 0;
        int r = nums.length - 1;
        int ans = 0;
        while(l < r){
            if(nums[l] + nums[r] == k){
                l++;
                r--;
                ans++;
            }else if(nums[l] + nums[r] < k){
                l++;
            }else{
                r--;
            }
        }
        return ans;

    }
}
