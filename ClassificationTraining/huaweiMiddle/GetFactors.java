package ClassificationTraining.huaweiMiddle;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname GetFactors
 * @Description TODO
 * @Date 2020/10/25 23:13
 * @Created by Administrator
 * 8 = 2 x 2 x 2;
 * = 2 x 4.
 * 请实现一个函数，该函数接收一个整数 n 并返回该整数所有的因子组合。
 */
public class GetFactors {
    public static void main(String[] args) {
        int n = 12;
        System.out.println(getFactors(n));

    }

    public static List<List<Integer>> getFactors(int n) {
        if (n == 1) {
            return new ArrayList<>();
        }
        List<List<Integer>> res = new ArrayList<>();
        dfs(res, new ArrayList<>(), n, 2);
        return res;


    }

    private static void dfs(List<List<Integer>> res, List<Integer> item, int n, int start) {
        if (n == 1) {
            if (item.size() > 1) {
                res.add(new ArrayList<>(item));
            }
            return;
        }
        for (int i = start; i * i <= n; i++) {
            if (n % i == 0) {
                item.add(i);
                item.add(n / i);
                res.add(new ArrayList<>(item));
                item.remove(item.size() - 1);
                dfs(res, item, n / i, i);
                item.remove(item.size() - 1);
            }
        }

    }

    private static void dfs2(List<List<Integer>> res, List<Integer> item, int n, int start) {
        if (n == 1) {
            if (item.size() > 1) {
                res.add(new ArrayList<>());
            }
        }
        for (int i = start; i * i <= n; i++) {
            if (n % i == 0) {
                item.add(i);
                item.add(n / i);
                res.add(new ArrayList<>());
                item.remove(item.size() - 1);
                dfs(res, item, n / i, i);
                item.remove(item.size() - 1);
            }
        }
    }
}
