package ClassificationTraining.huaweiSimple;

/**
 * 给你一个非负整数数组 nums 。如果存在一个数 x ，使得 nums 中恰好有 x 个元素
 * 大于或者等于 x ，那么就称 nums 是一个 特殊数组 ，而 x 是该数组的 特征值 。
 * 注意： x 不必 是 nums 的中的元素。
 * 如果数组 nums 是一个 特殊数组 ，请返回它的特征值 x 。否则，返回 -1 。
 * 可以证明的是，如果 nums 是特殊数组，那么其特征值 x 是 唯一的 。 
 * 输入：nums = [3,5]
 * 输出：2
 * 解释：有 2 个元素（3 和 5）大于或等于 2 。
 * 对于特征值的判断：大于等于x的数字在数组中恰好有x个，需要知道数组中大于等于x的个数
 * 是否为x，可通过统计实现
 * 结合上述第2条规则，可用辅助数组cnt[1001]即可统计所有数字出现的频次
 * 然后，找到一个下标x，并且cnt[x]+cnt[x+1]...cnt[1000]的个数总和等于x即可。
 */
public class SpecialArray {
    public static void main(String[] args) {
        int[] nums = {3, 5};
        System.out.println(specialArray(nums));
    }

    public static int specialArray(int[] nums) {
        int[] cnt = new int[1001];
        for (int i = 0; i < nums.length; i++) {
            cnt[nums[i]]++;
        }
        int preSum=0;
        for(int i=1000;i>=0;i--){
            preSum+=cnt[i];
            if(preSum==i){
                return i;
            }
        }
        return -1;

    }

    public static int specialArray2(int[] nums) {
        if (nums.length == 0) {
            return -1;
        }
        int sum = 0;
        int count = 0;
        int len = nums.length;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        int avg = sum / len;
        for (int num : nums) {
            if (num >= avg) {
                count++;
            }
        }
        if (count == avg) {
            return count;
        } else {
            return -1;
        }
    }
}
