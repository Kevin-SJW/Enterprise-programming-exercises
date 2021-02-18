package ClassificationTraining.huaweiMiddle;

import java.util.Arrays;

/**
 * @Classname ShipWithDays
 * @Description TODO
 * @Date 2021/1/20 23:45
 * @Created by Administrator
 * 传送带上的包裹必须在 D 天内从一个港口运送到另一个港口。
 * 传送带上的第 i 个包裹的重量为 weights[i]。每一天，我们都会按给出重量的顺序往传送带上装载包裹。
 * 我们装载的重量不会超过船的最大运载重量。
 * 返回能在 D 天内将传送带上的所有包裹送达的船的最低运载能力。
 * 输入：weights = [1,2,3,4,5,6,7,8,9,10], D = 5  ,输出：15
 * 船舶最低载重 15 就能够在 5 天内送达所有包裹，如下所示：
 * 第 1 天：1, 2, 3, 4, 5;  第 2 天：6, 7 ; 第 3 天：8  第 4 天：9  第 5 天：10
 * 请注意，货物必须按照给定的顺序装运，因此使用载重能力为 14 的船舶并将包装分成
 * (2, 3, 4, 5), (1, 6, 7), (8), (9), (10) 是不允许的
 */
public class ShipWithDays {
    public static void main(String[] args) {
        int[] weights = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int D = 5;
        System.out.println(shipWithinDays2(weights, D));
    }

    private static int shipWithinDays(int[] weights, int d) {
        int maxLoad = findMaxWeight(weights);
        while (greaterThenD(maxLoad, weights, d)) {
            maxLoad++;
        }
        return maxLoad;
    }

    private static boolean greaterThenD(int maxLoad, int[] weights, int d) {
        int curLoad = maxLoad;
        for (int weight : weights) {
            if (d <= 0) {
                return true;
            }
            curLoad -= weight;
            while (curLoad < 0) {
                curLoad = maxLoad - weight;
                d--;
            }
        }
        return d <= 0;
    }

    private static int findMaxWeight(int[] weights) {
        return Arrays.stream(weights).max().orElse(1);
    }

    //法2：
    public static int shipWithinDays2(int[] weights, int D) {
        //套用左侧搜索边界的算法框架
        int left = getMax(weights), right = getSum(weights)+1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (canFinsh(weights, D, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public static boolean canFinsh(int[] w, int D, int cap) {
        int i = 0;
        for (int day = 0; day < D; day++) {
            int maxCap = cap;
            while ((maxCap -= w[i]) >= 0) {
                i++;
                if (i == w.length) {
                    return true;
                }
            }
        }
        return false;
    }

    public static int getSum(int[] weights) {
        int sum = 0;
        for (int n : weights) {
            sum += n;
        }
        return sum;
    }

    public static int getMax(int[] piles) {
        int max = 0;
        for (int n : piles) {
            max = Math.max(n, max);
        }
        return max;
    }


}
