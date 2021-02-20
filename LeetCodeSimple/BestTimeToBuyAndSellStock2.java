package LeetCodeSimple;

/**
 * @Classname BestTimeToBuyAndSellStock2
 * @Description TODO
 * @Date 2020/7/8 23:55
 * @Created by Administrator
 * Design an algorithm to find the maximum profit.
 * You may complete as many transactions as you like
 * (i.e., buy one and sell one share of the stock multiple times).
 *
 * Note: You may not engage in multiple transactions at the same time
 * (i.e., you must sell the stock before you buy again).
 *
 */
public class BestTimeToBuyAndSellStock2 {
    public static void main(String[] args) {
        int[] prices={7,1,5,3,6,4};
        System.out.println(maxProfit(prices));

    }
    public static int maxProfit(int[] prices) {
        int maxProfit=0;
        for(int i=1;i<prices.length;i++){
            if(prices[i]-prices[i-1]>0){
                maxProfit+=prices[i]-prices[i-1];
            }
        }
        return maxProfit;
    }
}
