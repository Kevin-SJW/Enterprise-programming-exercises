package ClassificationTraining.huaweiMiddle;

/**
 * @Classname RegionsCutBySlashes
 * @Description TODO
 * @Date 2020/9/6 8:48
 * @Created by Administrator
 */
public class RegionsCutBySlashes {
    public static void main(String[] args) {
        String[] grid = {" /", "/ "};
        System.out.println(regionsBySlashes(grid));

    }
    public static int regionsBySlashes(String[] grid) {

        if (grid.length == 0) return 0;
        int nr = grid.length;
        int nc = grid[0].length();
        int[][] g = new int[3 * nr][3 * nc];
        for (int i = 0; i < nr; i++) {
            for (int j = 0; j < nc; j++) {
                if (grid[i].charAt(j) == '\\') {
                    g[3 * i][3 * j] = 1;
                    g[3 * i + 1][3 * j + 1] = 1;
                    g[3 * i + 2][3 * j + 2] = 1;
                } else if (grid[i].charAt(j) == '/') {
                    g[3 * i][3 * j + 2] = 1;
                    g[3 * i + 1][3 * j + 1] = 1;
                    g[3 * i + 2][3 * j] = 1;
                }
            }
        }
        int count = 0;
        for (int i = 0; i < g.length; i++) {
            for (int j = 0; j < g[0].length; j++) {
                if (g[i][j] == 0) {
                    dfs(g, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    private static void dfs(int[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length) {
            return;
        }
        if (grid[i][j] == 1) return;
        if (grid[i][j] == 2) return;
        grid[i][j] = 2;// 表示已经visited
        dfs(grid, i - 1, j);
        dfs(grid, i + 1, j);
        dfs(grid, i, j - 1);
        dfs(grid, i, j + 1);
    }


    // 这两个dfs是相同的哦
    private static void dfs(int x, int y, int[][] regions) {
        if (x >= 0 && x < regions.length && y >= 0 && y < regions.length && regions[x][y] == 0) {
            regions[x][y] = 1;
            dfs(x + 1, y, regions);
            dfs(x - 1, y, regions);
            dfs(x, y + 1, regions);
            dfs(x, y - 1, regions);
        }
    }


}
