package ClassificationTraining.huaweiMiddle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 你有一个用于表示一片土地的整数矩阵land，该矩阵中每个点的值代表对应地点的海拔高度。
 * 若值为0则表示水域。由垂直、水平或对角连接的水域为池塘。池塘的大小是指相连接的水域的个数。
 * 编写一个方法来计算矩阵中所有池塘的大小，返回值需要从小到大排序。
 */
public class PondSizes {
    public static void main(String[] args) {
        int[][] land = {{0, 2, 1, 0}, {0, 1, 0, 1}, {1, 1, 0, 1}, {0, 1, 0, 1}};
        System.out.println(Arrays.toString(pondSizes(land)));
    }
    public static int[] pondSizes(int[][] land) {
        int m = land.length;
        int n = land[0].length;
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int temp = helper(land, i, j);
                if (temp != 0) {
                    res.add(temp); } } }
        int[] ans = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            ans[i] = res.get(i); }
        Arrays.sort(ans);
        return ans; }
    // dfs搜索
    private static int helper(int[][] land, int i, int j) {
        // 边界条件
        if (i < 0 || i >= land.length || j < 0 || j >= land[0].length || land[i][j] != 0) {
            return 0;
        }// 做一些处理
        land[i][j] = 1;
        int size = helper(land, i - 1, j - 1) + helper(land, i - 1, j) +
                helper(land, i - 1, j + 1) +
                helper(land, i, j - 1) +
                helper(land, i, j + 1) +
                helper(land, i + 1, j - 1) +
                helper(land, i + 1, j) +
                helper(land, i + 1, j + 1) + 1;
        return size;
    }

}
