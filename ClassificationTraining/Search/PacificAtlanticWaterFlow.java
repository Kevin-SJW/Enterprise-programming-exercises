package ClassificationTraining.Search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Classname PacificAtlanticWaterFlow
 * @Description TODO
 * @Date 2020/8/11 23:59
 * @Created by Administratora
 * //太平洋大西洋水流问题
 */
public class PacificAtlanticWaterFlow {
    int n, m;

    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        n = matrix.length;
        if (n == 0) return new ArrayList<>();
        m = matrix[0].length;
        boolean[][] pac = new boolean[n][m];
        boolean[][] atl = new boolean[n][m];

        for (int j = 0; j < m; j++) dfs(0, j, matrix, pac);
        for (int i = 0; i < n; i++) dfs(i, 0, matrix, pac);
        for (int j = 0; j < m; j++) dfs(n - 1, j, matrix, atl);
        for (int i = 0; i < n; i++) dfs(i, m - 1, matrix, atl);

        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                if (pac[i][j] && atl[i][j])
                    res.add(Arrays.asList(i, j));
        return res;
    }

    int[] dx = new int[]{0, 1, 0, -1}, dy = new int[]{1, 0, -1, 0};

    private void dfs(int x, int y, int[][] mat, boolean[][] used) {
        used[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int a = x + dx[i];
            int b = y + dy[i];
            if (a >= 0 && a < n && b >= 0 && b < m && mat[a][b] >= mat[x][y] && !used[a][b])
                dfs(a, b, mat, used);
        }
    }
}
