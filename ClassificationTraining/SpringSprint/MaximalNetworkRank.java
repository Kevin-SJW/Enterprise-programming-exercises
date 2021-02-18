package ClassificationTraining.SpringSprint;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname MaximalNetworkRank
 * @Description TODO
 * @Date 2021/2/7 23:19
 * @Created by Administrator
 * n 座城市和一些连接这些城市的道路 roads 共同组成一个基础设施网络。每个 roads[i] = [ai, bi]
 * 都表示在城市 ai 和 bi 之间有一条双向道路。两座不同城市构成的 城市对 的 网络秩 定义为：
 * 与这两座城市 直接 相连的道路总数。如果存在一条道路直接连接这两座城市，则这条道路只计算 一次 。
 * 整个基础设施网络的 最大网络秩 是所有不同城市对中的 最大网络秩,给你整数 n 和数组 roads，
 * 返回整个基础设施网络的 最大网络秩 。
 */
public class MaximalNetworkRank {
    public static void main(String[] args) {
        int[][] roads = {{0, 1}, {0, 3}, {1, 2}, {1, 3}};
        int n = 4;
        System.out.println(maximalNetworkRank(n, roads));
    }

    public static int maximalNetworkRank(int n, int[][] roads) {
        List<List<Integer>> network = new ArrayList<>();
        for (int i=0;i<n;++i) {
            network.add(new ArrayList<>());
        }
        for (int[] road : roads) {
            network.get(road[0]).add(road[1]);
            network.get(road[1]).add(road[0]);
        }
        int ans = 0;
        for (int i = 0; i < n; ++i) {
      for (int j = i + 1; j < n; ++j) {
                List<Integer> list1 = network.get(i);
                List<Integer> list2 = network.get(j);
                int res = list1.size() + list2.size();
                if (list1.contains(j)) {
                    res--;
                }
                ans = Math.max(res, ans);
            }

        }

        return ans;
    }
}
