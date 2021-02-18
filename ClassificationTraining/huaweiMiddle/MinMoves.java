package ClassificationTraining.huaweiMiddle;

/**
 * @Classname MinMoves
 * @Description TODO
 * @Date 2020/12/5 11:12
 * @Created by Administrator
 * 给你一个长度为 偶数 n 的整数数组 nums 和一个整数 limit 。每一次操作，
 * 你可以将 nums 中的任何整数替换为 1 到 limit 之间的另一个整数。
 * <p>
 * 如果对于所有下标 i（下标从 0 开始），nums[i] + nums[n - 1 - i] 都等于同一个数，
 * 则数组 nums 是 互补的 。例如，数组 [1,2,3,4] 是互补的，因为对于所有下标 i ，
 * nums[i] + nums[n - 1 - i] = 5 。
 * <p>
 * 返回使数组 互补 的 最少 操作次数。
 * <p>
 * 输入：nums = [1,2,4,3], limit = 4
 * 输出：1
 * 解释：经过 1 次操作，你可以将数组 nums 变成 [1,2,2,3]（加粗元素是变更的数字）：
 * nums[0] + nums[3] = 1 + 3 = 4.
 * nums[1] + nums[2] = 2 + 2 = 4.
 * nums[2] + nums[1] = 2 + 2 = 4.
 * nums[3] + nums[0] = 3 + 1 = 4.
 * 对于每个 i ，nums[i] + nums[n-1-i] = 4 ，所以 nums 是互补的。
 */
public class MinMoves {
    public static void main(String[] args) {
        int[] nums = {1, 2, 4, 3};
        int limit = 6;
        System.out.println(minMoves(nums, limit));
    }

    public static int minMoves(int[] nums, int limit) {
        int n = nums.length;
        //开到2 * limit + 2防止 max = limit的情况数组越界,起到简化代码，减少讨论的效果。
        int[] diff = new int[2 * limit + 2];
        for (int i = 0; i < nums.length / 2; i++) {
            int max = Math.max(nums[i], nums[n - i - 1]),
                    min = Math.min(nums[i], nums[n - i - 1]);
            //这一步是理解的关键。其实这里也可以为diff[0] += 2，下面做前缀和的时候从 i = 1的时候开始做就行
            diff[1] += 2;
            diff[min + 1] -= 1;
            diff[min + max] -= 1;
            diff[min + max + 1] += 1;
            diff[max + limit + 1] += 1;
        }
        int ans = diff[1];
        for (int i = 2; i < 2 * limit + 1; i++) {
            diff[i] += diff[i - 1];
            ans = Math.min(ans, diff[i]);
        }
        return ans;

    }
}
