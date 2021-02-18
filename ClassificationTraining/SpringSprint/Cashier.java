package ClassificationTraining.SpringSprint;

import java.util.HashMap;
import java.util.Map;

/**
 * 超市里正在举行打折活动，每隔 n 个顾客会得到 discount 的折扣。
 * 超市里有一些商品，第 i 种商品为 products[i] 且每件单品的价格为 prices[i] 。
 * 结账系统会统计顾客的数目，每隔 n 个顾客结账时，该顾客的账单都会打折，折扣为 discount 
 * （也就是如果原本账单为 x ，那么实际金额会变成 x - (discount * x) / 100 ），然后系统会重新开始计数。
 * 顾客会购买一些商品， product[i] 是顾客购买的第 i 种商品， amount[i] 是对应的购买该种商品的数目。
 * 请你实现 Cashier 类：
 * Cashier(int n, int discount, int[] products, int[] prices) 初始化实例对象，参数分别为打折频率 n ，
 * 折扣大小 discount ，超市里的商品列表 products 和它们的价格 prices 。
 * double getBill(int[] product, int[] amount) 返回账单的实际金额（如果有打折，请返回打折后的结果）。
 * 返回结果与标准答案误差在 10^-5 以内都视为正确结果。
 */
public class Cashier {
    private int n;
    private int discount;
    private int[] products;
    private int[] prices;
    private int count = 0;
    private Map<Integer, Integer> map = new HashMap();

    public Cashier(int n, int discount, int[] products, int[] prices) {
        this.n = n;
        this.discount = discount;
        this.products = products;
        this.prices = prices;
        for(int i = 0; i < products.length; i++) {
            map.put(products[i], prices[i]);
        }
    }

    public double getBill(int[] product, int[] amount) {
        count++;

        double cost = 0;
        int len = product.length;
        for(int i = 0; i < len; i++) {
            cost += (double)(map.get(product[i]) * amount[i]);
        }

        if (count % n == 0) {
            cost = cost * (100 - discount) / 100;
        }

        return cost;
    }

    public double getBill2(int[] product, int[] amount) {
        double res = 0.0;
        for (int i = 0; i <= product.length; i++) {
            for (int j = i; j <amount.length; j++) {
                if (count != n) {
                    res += ((double)prices[product[i] - 1] * amount[j]);
                    if (j == product.length - 1) {
                        count++;
                    }
                } else {
                    double index=(1 - ((double)discount / 100));
                    res += (prices[product[i] - 1] * amount[j])*index;
                    if (j == product.length - 1) {
                        count = 1;
                    }
                }
                break;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Cashier cashier = new Cashier(3, 50, new int[]{1, 2, 3, 4, 5, 6, 7}, new int[]{100, 200, 300, 400, 300, 200, 100});
        System.out.println(cashier.getBill(new int[]{1, 2}, new int[]{1, 2}));
               // 返回 500.0, 账单金额为 = 1 * 100 + 2 * 200 = 500.
        System.out.println(cashier.getBill(new int[]{3, 7}, new int[]{10, 10}));
              // 返回 4000.0
        // 返回 800.0 ，账单原本为 1600.0 ，但由于该顾客是第三位顾客，他将得到 50% 的折扣，所以实际金额为 1600 - 1600 * (50 / 100) = 800 。
        System.out.println(cashier.getBill(new int[]{1, 2, 3, 4, 5, 6, 7}, new int[]{1, 1, 1, 1, 1, 1, 1}));

        System.out.println(cashier.getBill(new int[]{4}, new int[]{10}));
                       // 返回 4000.0
        System.out.println(cashier.getBill(new int[]{7, 3}, new int[]{10, 10}));
                // 返回 4000.0
        // 返回 7350.0 ，账单原本为 14700.0 ，但由于系统计数再次达到三，该顾客将得到 50% 的折扣，实际金额为 7350.0 。
        System.out.println(cashier.getBill(new int[]{7, 5, 3, 1, 6, 4, 2}, new int[]{10, 10, 10, 9, 9, 9, 7}));

        System.out.println(cashier.getBill(new int[]{2, 3, 5}, new int[]{5, 3, 2}));
            // 返回 2500.0

    }
}
