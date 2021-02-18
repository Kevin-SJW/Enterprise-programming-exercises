package ClassificationTraining.huaweiSimple;

/**
 * @Classname CanPlaceFlower
 * @Description TODO
 * @Date 2020/9/13 17:09
 * @Created by Administrator
 * 假设你有一个很长的花坛，一部分地块种植了花，另一部分却没有。可是，花卉不能种植在相邻的地块上，它们会争夺水源，两者都会死去。
 * <p>
 * 给定一个花坛（表示为一个数组包含0和1，其中0表示没种植花，1表示种植了花），和一个数 n 。能否在不打破种植规则的情况下种入 n 朵花？能则返回True，不能则返回False。
 */
public class CanPlaceFlower {
    public static void main(String[] args) {
        int[] flowered = {1, 0, 0, 0, 1};
        int n = 2;
        System.out.println(canPlaceFlowers2(flowered, n));

    }

    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        int count = 0;
        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] == 0 && (i == 0 || flowerbed[i - 1] == 0)
                    && (flowerbed[i + 1] == 0 || i == flowerbed.length - 1)) {
                flowerbed[i] = 1;
                count++;
            }
        }
        return count >= n;
    }

    public static boolean canPlaceFlowers2(int[] flowerbed, int n) {
        int count = 0;
        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] == 0 && (i == 0 || flowerbed[i - 1] == 0)
                    && (i == flowerbed.length - 1 || flowerbed[i + 1] == 0)) {
                flowerbed[i] = 1;
                count++;
            }
        }
        return count >= n;
    }
}
