package ClassificationTraining.huaweiSimple;

/**
 * @Classname FindRadius
 * @Description TODO
 * @Date 2020/8/22 0:08
 * @Created by Administrator
 */
public class FindRadius {
    public static void main(String[] args) {
        int[] house = {1, 2, 3};
        int[] heaters = {2};
        System.out.println(findRadius(house, heaters));
    }

    public static int findRadius(int[] houses, int[] heaters) {
        int max = 0;
        for (int i = 0; i < houses.length; i++) {
            max = Math.max(max, findNearest(houses[i], heaters));
        }
        return max;

    }

    public static int findNearest(int n, int[] heaters) {
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < heaters.length; i++) {
            ans = Math.min(ans, Math.abs(heaters[i] - n));
        }
        return ans;
    }
}
