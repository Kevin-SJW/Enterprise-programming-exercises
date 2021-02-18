package ClassificationTraining.SpringSprint;

/**
 * @Classname maxProfit
 * @Description TODO
 * @Date 2021/2/14 15:48
 * @Created by Administrator
 * 假设把某股票的价格按照时间先后顺序存储在数组中，请问买卖该股票一次可能获得的最大利润是多少？
 * 输入: [7,1,5,3,6,4]
 * 输出: 5
 * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 * 注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格。
 */
public class maxProfit {
    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        int[] prices2 = {1, 2, 4};
        System.out.println(maxProfit(prices2));
    }

    public static int maxProfit(int[] prices) {
        int res = 0;
        if (prices.length <= 1) {
            return 0;
        }
        if (prices.length <= 2) {
            if (prices[1] > prices[0]) {
                return prices[1] - prices[0];
            } else {
                return 0;
            }
        }

        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j <= prices.length - 1; j++) {
                if (prices[j] > prices[i]) {
                    res = Math.max(res, prices[j] - prices[i]);
                }
            }
        }
        return res;
    }
}
