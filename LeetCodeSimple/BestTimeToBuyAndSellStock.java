package LeetCodeSimple;

/**
 * @Classname BestTimeToBuyAndSellStock
 * @Description TODO
 * @Date 2020/7/8 23:42
 * @Created by Administrator
 */
public class BestTimeToBuyAndSellStock {
    public static void main(String[] args) {
        int[] prices={7,1,5,3,6,4};
        System.out.println(maxProfit(prices));

    }
    public static int maxProfit(int[] prices) {
            int maxProfit=0;
            for(int i=0;i<prices.length;i++){
                for(int j=i+1;j<prices.length;j++){
                    if(prices[j]-prices[i]>maxProfit){
                     maxProfit=prices[j]-prices[i];
                    }
                }
            }
            return maxProfit;
    }
}
