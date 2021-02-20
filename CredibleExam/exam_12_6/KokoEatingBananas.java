package CredibleExam.exam_12_6;

/**
 * @Classname KokoEatingBananas
 * @Description TODO
 * @Date 2020/7/11 21:42
 * @Created by Administrator
 * Koko loves to eat bananas.  There are N piles of bananas, the i-th pile has piles[i] bananas.  The guards have gone and will come back in H hours.
 * Koko can decide her bananas-per-hour eating speed of K.  Each hour, she chooses some pile of bananas, and eats K bananas from that pile.  If the pile has less than K bananas, she eats all of them instead, and won't eat any more bananas during this hour.
 * Koko likes to eat slowly, but still wants to finish eating all the bananas before the guards come back.
 * Return the minimum integer K such that she can eat all the bananas within H hours.
 * leetCode 875
 */
public class KokoEatingBananas {
    public static void main(String[] args) {
        int[] piles = {3, 6, 7, 11};
        int H = 8;
        System.out.println(minEatingSpeed2(piles, H));
    }

    //数学分析+暴力求解
    public static int minEatingSpeed(int[] piles, int H) {
        long sum = 0;//java long为8字节，防止求和时溢出
        for (int pile : piles) {
            sum += pile;
        }
        //将下界提高到每堆香蕉及所有香蕉都正好“整点”吃完的速度（sum/H向上取整）
        int begin = (int) ((sum - 1) / H + 1);
        while (true) {
            int count = 0;
            for (int pile : piles) {
                count += (pile - 1) / begin + 1;
            }
            if (count <= H) {
                return begin;
            }
            begin++;
        }

    }

    public static int minEatingSpeed2(int[] piles, int H) {
        //套用左侧搜索边界的算法框架
        int left = 1, right = getMax(piles);
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (canFinsh(piles, mid, H)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public static boolean canFinsh(int[] piles, int speed, int H) {
        int time = 0;
        for (int n : piles) {
            time += timeOf(n, speed);
        }
        return time <= H;
    }

    public static int timeOf(int n, int speed) {
        return (n / speed) + ((n % speed > 0) ? 1 : 0);
    }

    public static int getMax(int[] piles) {
        int max = 0;
        for (int n : piles) {
            max = Math.max(n, max);
        }
        return max;
    }
}
