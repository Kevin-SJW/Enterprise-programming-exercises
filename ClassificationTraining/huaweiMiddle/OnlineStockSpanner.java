package ClassificationTraining.huaweiMiddle;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @Classname OnlineStockSpan
 * @Description TODO
 * @Date 2020/8/28 22:54
 * @Created by Administrator
 * Write a class StockSpanner which collects daily price quotes for some stock,
 * and returns the span of that stock's price for the current day.
 * <p>
 * The span of the stock's price today is defined as the maximum number
 * of consecutive days (starting from today and going backwards) for
 * which the price of the stock was less than or equal to today's price.
 * <p>
 * For example, if the price of a stock over the next 7 days were
 * [100, 80, 60, 70, 60, 75, 85], then the stock spans would be [1, 1, 1, 2, 1, 4, 6].
 */
public class OnlineStockSpanner {
    Stack<Integer> stack;
    Map<Integer, Integer> map;

    public OnlineStockSpanner() {
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
        stack.push(price);
        map.put(price, num);
        return num;
    }


}
