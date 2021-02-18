package ClassificationTraining.huaweiMiddle;

/**
 * @Classname GetMaxisumGold
 * @Description TODO
 * @Date 2020/10/1 18:19
 * @Created by Administrator
 * 你要开发一座金矿，地质勘测学家已经探明了这座金矿中的资源分布，并用大小为 m * n 的网格 grid 进行了标注。
 * 每个单元格中的整数就表示这一单元格中的黄金数量；如果该单元格是空的，那么就是 0。
 * 为了使收益最大化，矿工需要按以下规则来开采黄金：
 * 每当矿工进入一个单元，就会收集该单元格中的所有黄金。
 * 矿工每次可以从当前位置向上下左右四个方向走。
 * 每个单元格只能被开采（进入）一次。
 * 不得开采（进入）黄金数目为 0 的单元格。
 * 矿工可以从网格中 任意一个 有黄金的单元格出发或者是停止。
 */
public class GetMaxisumGold {
    private static int max = 0;

    public static void main(String[] args) {
        int[][] grid = {{0, 6, 0}, {5, 8, 7}, {0, 9, 0}};
        System.out.println(getMaximumGold(grid));

    }

    public static int getMaximumGold(int[][] grid) {
        boolean[][] vis = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] != 0) {
                    dfs(grid, i, j, 0, vis);
                }
            }
        }
        return max;
    }

    public static void dfs(int[][] grid, int x, int y, int gold, boolean[][] vis) {
        if ((x < 0 || x >= grid.length) || (y < 0 || y >=grid[0].length)
                || grid[x][y] == 0 || vis[x][y]) {
            max = Math.max(max, gold);
            return;
        }
        gold+=grid[x][y];
        vis[x][y] = true;
        dfs(grid, x + 1, y, gold, vis);
        dfs(grid, x - 1, y, gold, vis);
        dfs(grid, x, y + 1, gold, vis);
        dfs(grid, x, y - 1, gold, vis);
        vis[x][y] = false;
    }
}
