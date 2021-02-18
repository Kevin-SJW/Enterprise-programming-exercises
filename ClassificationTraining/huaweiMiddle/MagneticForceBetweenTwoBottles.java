package ClassificationTraining.huaweiMiddle;

import java.util.Arrays;

/**
 * @Classname MagneticForceBetweenTwoBottles
 * @Description TODO
 * @Date 2020/10/2 16:09
 * @Created by Administrator
 * 在代号为 C-137 的地球上，Rick 发现如果他将两个球放在他新发明的篮子里，它们之间会形成特殊形式的磁力。
 * Rick 有 n 个空的篮子，第 i 个篮子的位置在 position[i] ，Morty 想把 m 个球放到这些篮子里，
 * 使得任意两球间 最小磁力 最大。
 * <p>
 * 已知两个球如果分别位于 x 和 y ，那么它们之间的磁力为 |x - y| 。
 * <p>
 * 给你一个整数数组 position 和一个整数 m ，请你返回最大化的最小磁力。
 */
public class MagneticForceBetweenTwoBottles {
    static int inf = (int) 1e9;

    public static void main(String[] args) {
        int[] position = {1, 2, 3, 4, 7};
        int m = 3;
        System.out.println(maxDistance(position, m));
    }

    public static int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int l = 0;
        int r = inf;
        while (l < r) {
            int mid = (l + r + 1) / 2;
            if (check(position, m, mid)) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        return l;
    }

    public static boolean check(int[] position, int m, int distance) {
        int pre = -inf;
        for (int next : position) {
            if (next - pre >= distance) {
                m--;
                pre = next;
            }
        }
        return m <= 0;
    }

    public static int maxDistance2(int[] position, int m) {
        Arrays.sort(position);
        int l = 0, r = inf;
        while (l < r) {
            int mid = (l + r + 1) / 2;
            if (check2(position, m, mid)) {
                l = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;

    }

    public static boolean check2(int[] position, int m, int distance) {
        int pre = -inf;
        for (int next : position) {
            if (next - pre >= distance) {
                m--;
                pre = next;
            }
        }
        return m <= 0;
    }
}
