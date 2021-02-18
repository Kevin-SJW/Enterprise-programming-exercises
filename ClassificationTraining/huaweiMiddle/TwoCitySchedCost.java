package ClassificationTraining.huaweiMiddle;

import java.util.Arrays;

/**
 * @Classname TwoCitySchedCost
 * @Description TODO
 * @Date 2020/9/22 23:50
 * @Created by Administrator
 * 公司计划面试 2N 人。第 i 人飞往 A 市的费用为 costs[i][0]，
 * 飞往 B 市的费用为 costs[i][1]。
 * 返回将每个人都飞到某座城市的最低费用，要求每个城市都有 N 人抵达。
 * 输入：[[10,20],[30,200],[400,50],[30,20]]
 * 输出：110
 * 解释：
 * 第一个人去 A 市，费用为 10。
 * 第二个人去 A 市，费用为 30。
 * 第三个人去 B 市，费用为 50。
 * 第四个人去 B 市，费用为 20。
 * <p>
 * 先假设都去了A城市
 * 用一个数组保存每个人 （去B城市的费用-去A城市的费用）
 * 按照 从小到大 的顺序，给 费用差数组 排序
 * 将费用差最小的一半数组的值，加给总费用
 */
public class TwoCitySchedCost {
    public static void main(String[] args) {
        int[][] costs = {{10, 20}, {30, 200}, {400, 50}, {30, 20}};
        System.out.println(twoCitySchedCost(costs));
    }

    public static int twoCitySchedCost(int[][] costs) {
        int res = 0;
        int[] temp = new int[costs.length];
        for (int i = 0; i < costs.length; i++) {
            temp[i] = costs[i][1] - costs[i][0];
            res += costs[i][0];
        }
        Arrays.sort(temp);
        for (int i = 0; i < temp.length / 2; i++) {
            res += temp[i];
        }
        return res;
    }

    public static int twoCitySchedCost2(int[][] costs) {
        int res = 0;
        int[] temp = new int[costs.length];
        for (int i = 0; i < costs.length; i++) {
            res += costs[i][0];
            temp[i] = costs[i][1] - costs[i][0];

        }
        Arrays.sort(temp);
        for (int i = 0; i < temp.length / 2; i++) {
            res += temp[i];
        }
        return res;

    }
}
