package ClassificationTraining.SpringSprint;

/**
 * @Classname ShipWithinDays
 * @Description TODO
 * @Date 2021/2/11 16:33
 * @Created by Administrator
 * 传送带上的包裹必须在 D 天内从一个港口运送到另一个港口。传送带上的第 i 个包裹的重量为 weights[i]。
 * 每一天，我们都会按给出重量的顺序往传送带上装载包裹。我们装载的重量不会超过船的最大运载重量。
 * 返回能在 D 天内将传送带上的所有包裹送达的船的最低运载能力。
 * 示例 1：
 * <p>
 * 输入：weights = [1,2,3,4,5,6,7,8,9,10], D = 5
 * 输出：15
 */
public class ShipWithinDays {
    public static void main(String[] args) {
        int[] weights = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int d = 5;
        System.out.println(shipWithinDays(weights, d));
    }

    public static int shipWithinDays(int[] weights, int d) {
        int left = getMax(weights);
        int right = getSum(weights) + 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (canFinsh(weights, d, mid)) {
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
                if(i==w.length){
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

    public static int getMax(int[] weights) {
        int max = 0;
        for (int n : weights) {
            max = Math.max(n, max);
        }
        return max;
    }
}
