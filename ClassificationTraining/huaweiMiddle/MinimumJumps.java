package ClassificationTraining.huaweiMiddle;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Classname MinimumJumps
 * @Description TODO
 * @Date 2020/11/22 16:00
 * @Created by Administrator
 * 有一只跳蚤的家在数轴上的位置 x 处。请你帮助它从位置 0 出发，到达它的家。
 *
 * 跳蚤跳跃的规则如下：
 *
 * 它可以 往前 跳恰好 a 个位置（即往右跳）。
 * 它可以 往后 跳恰好 b 个位置（即往左跳）。
 * 它不能 连续 往后跳 2 次。
 * 它不能跳到任何 forbidden 数组中的位置。
 * 跳蚤可以往前跳 超过 它的家的位置，但是它 不能跳到负整数 的位置。
 *
 * 给你一个整数数组 forbidden ，其中 forbidden[i] 是跳蚤不能跳到的位置，
 * 同时给你整数 a， b 和 x ，请你返回跳蚤到家的最少跳跃次数。如果没有恰好到达 x 的可行方案，请你返回 -1 。
 *
 */
public class MinimumJumps {
    public static void main(String[] args) {
        int[] forbidden = {14,4,18,1,15};
        int a = 3, b = 15, x = 9;
        System.out.println(minimumJumps(forbidden,a,b,x));
    }

    public static int minimumJumps(int[] forbidden, int a, int b, int x) {
        if (a > b + x) {
            return -1;
        }
        if (a == x) {
            return 1;
        }
        if (x == 0) {
            return 0;
        }
        Set<Integer> l = new HashSet<>();
        l.add(a);
        int step = 1;
        Map<Integer, Integer> visitedMap = new HashMap<>();
        while (!l.isEmpty()) {
            boolean arrive = false;
            int size = l.size();
//            System.out.println(step + ": " + l);
            Integer[] is = new Integer[size];
            l.toArray(is);
            l.clear();
            for (int i = 0; i < size; i++) {
                Integer head = is[i];
                boolean cont = contain(forbidden, head);
                if ((a > b && head - b > x) || head > x + 4000 || cont) {
                    continue;
                }
                if (head == x) {
                    return step;
                }
                Integer exists = visitedMap.get(head - b);
                if (exists != null && exists == -1) {
                    continue;
                }
                int visited = visitedMap.getOrDefault(head, 0);
                cont = contain(forbidden, head - b);
                if (head - b > 0 && !cont && visited != -1) {
                    l.add(head - b);
                    // 当前位置可向左跳，并且要即将到达的位置在本次for循环中没有被向右的step到达过（换句话说就是：即将到达的点最后一步可以是以向右跳的方式，这样的话，就不要用向左跳这种更差的方式去覆盖）
                    if(visited == 0 && visitedMap.getOrDefault(head - b, 0) != 1) {
                        visitedMap.put(head - b, -1);
                    }
                    arrive = true;
                }
                cont = contain(forbidden, head + a);
                if (!cont) {
                    l.add(head + a);
                    visitedMap.put(head + a, 1);
                    arrive = true;
                }
            }
            if (arrive) {
                step++;
            }
            // 所有向右跳之后 达到的点都置成可向左跳
            for (Integer v : l) {
                if (visitedMap.get(v) != -1) {
                    visitedMap.put(v, 0);
                }
            }
        }
        return -1;
    }
    public static boolean contain(int[] arr, int k) {
        for (int i : arr) {
            if (k == i) {
                return true;
            }
        }
        return false;
    }
}
