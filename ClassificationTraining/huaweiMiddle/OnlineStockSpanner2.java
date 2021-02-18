package ClassificationTraining.huaweiMiddle;

import java.util.*;

/**
 * @Classname OnlineStockSpanner2
 * @Description TODO
 * @Date 2020/10/17 16:10
 * @Created by Administrator
 * 编写一个 StockSpanner 类，它收集某些股票的每日报价，并返回该股票当日价格的跨度。
 * <p>
 * 今天股票价格的跨度被定义为股票价格小于或等于今天价格的最大连续日数（从今天开始往回数，包括今天）。
 * <p>
 * 例如，如果未来7天股票的价格是 [100, 80, 60, 70, 60, 75, 85]，
 * 那么股票跨度将是 [1, 1, 1, 2, 1, 4, 6]
 */
public class OnlineStockSpanner2 {

    Stack<Integer> stack;
    Map<Integer, Integer> map;

    public OnlineStockSpanner2() {
        stack = new Stack<>();
        map = new HashMap<>();
    }

    public int next(int price) {
        int num = 1;
        int temp;

        while (!stack.isEmpty() && stack.peek() <= price) {
            temp = map.get(stack.peek());
            stack.pop();
            num += temp;

        }
        stack.add(price);
        map.put(price, num);
        return num;

    }

    public static void main(String[] args) {
        OnlineStockSpanner2 onlineStockSpanner2 = new OnlineStockSpanner2();
        System.out.print(onlineStockSpanner2.next(100));
        System.out.print(onlineStockSpanner2.next(80));
        System.out.print(onlineStockSpanner2.next(60));
        System.out.print(onlineStockSpanner2.next(70));
        System.out.print(onlineStockSpanner2.next(60));
        System.out.print(onlineStockSpanner2.next(75));
        System.out.print(onlineStockSpanner2.next(85));
    }

}
