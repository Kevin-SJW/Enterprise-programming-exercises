package ClassificationTraining.huaweiSimple;

/**
 * 数组的每个索引作为一个阶梯，第 i个阶梯对应着一个非负数的体力花费值 cost[i](索引从0开始)。
 * 每当你爬上一个阶梯你都要花费对应的体力花费值，然后你可以选择继续爬一个阶梯或者爬两个阶梯。
 * 您需要找到达到楼层顶部的最低花费。在开始时，你可以选择从索引为 0 或 1 的元素作为初始阶梯。
 * 输入: cost = [10, 15, 20]
 * 输出: 15
 * 解释: 最低花费是从cost[1]开始，然后走两步即可到阶梯顶，一共花费15。
 */
public class MinCostClimbingStairs {
    public static void main(String[] args) {
        int[] cost = {10, 15, 20};
        System.out.println(minCostClimbingStairs(cost));
    }

    public static int minCostClimbingStairs(int[] cost) {
        int pre = 0;
        int cur = 0;
        for (int i = 0; i < cost.length; i++) {
            int temp = cur;
            cur = cost[i] + Math.min(pre, cur);
            pre = temp;
        }
        return Math.min(pre, cur);
    }

    public static int minCostClimbingStairs2(int[] cost) {
        int pre = 0;
        int cur = 0;
        for (int i = 0; i < cost.length; i++) {
            int temp = cur;
            cur = cost[i] + Math.min(pre, cur);
            pre = temp;

        }
        return Math.min(cur, pre);
    }
}
