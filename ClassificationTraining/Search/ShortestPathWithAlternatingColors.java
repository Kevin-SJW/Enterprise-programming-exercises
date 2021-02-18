package ClassificationTraining.Search;

import java.util.*;

/**
 * @Classname ShortestPathWithAlternatingColors
 * @Description TODO
 * @Date 2020/8/11 0:28
 * @Created by Administrator
 * Input: n = 3, red_edges = [[0,1],[1,2]], blue_edges = []
 * Output: [0,1,-1]
 */
public class ShortestPathWithAlternatingColors {
    public static void main(String[] args) {
        int[][] red_edges = {{0, 1}, {1, 2}};
        int[][] blue_edges = {};
        int n = 3;
        Arrays.stream(shortestAlternatingPaths(n, red_edges, blue_edges)).forEach(
                t -> System.out.print(t + " "));
    }
    public static int[] shortestAlternatingPaths(int n, int[][] red_edges,
                                                 int[][] blue_edges) {
        Set<Integer>[][] graph = new HashSet[2][n];
        for (int i = 0; i < n; i ++) {
            graph[0][i] = new HashSet<>();
            graph[1][i] = new HashSet<>();
        }
        for (int[] e : red_edges) {
            graph[0][e[0]].add(e[1]);
        }
        for (int[] e : blue_edges) {
            graph[1][e[0]].add(e[1]);
        }
        int[][] res = new int[2][n];
        for (int i = 1; i < n; i ++) {
            res[0][i] = Integer.MAX_VALUE;
            res[1][i] = Integer.MAX_VALUE; }
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0});
        q.add(new int[]{0, 1});
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int node = cur[0];
            int color = cur[1];
            for (int i : graph[1 - color][node]) {
                if (res[1 - color][i] == Integer.MAX_VALUE) {
                    res[1 - color][i] = 1 + res[color][node];
                    q.add(new int[]{i, 1 - color}); } } }
        int[] ans = new int[n];
        for (int i = 0; i < n; i ++) {
            int min = Math.min(res[0][i], res[1][i]);
            ans[i] = (min == Integer.MAX_VALUE ? -1 : min); }
        return ans;


    }
}
