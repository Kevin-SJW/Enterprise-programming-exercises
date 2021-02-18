package ClassificationTraining.SpringSprint;

/**
 * 有 N 名工人。 第 i 名工人的工作质量为 quality[i] ，其最低期望工资为 wage[i] 。
 * 现在我们想雇佣 K 名工人组成一个工资组。在雇佣 一组 K 名工人时，我们必须按照下述规则向他们支付工资：
 * 对工资组中的每名工人，应当按其工作质量与同组其他工人的工作质量的比例来支付工资。
 * 工资组中的每名工人至少应当得到他们的最低期望工资。
 * 返回组成一个满足上述条件的工资组至少需要多少钱。
 */
public class MinCostToHireWorkers {
    public static void main(String[] args) {
        int[] quality = {10, 20, 5};
        int[] wage = {70, 50, 30};
        int k = 2;
        System.out.println(mincostToHireWorkers(quality, wage, k));
    }

    public static double mincostToHireWorkers(int[] quality, int[] wage, int K) {
        return 0.0;
    }
}
