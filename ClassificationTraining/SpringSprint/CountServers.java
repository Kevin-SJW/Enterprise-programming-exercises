package ClassificationTraining.SpringSprint;

/**
 * @Classname CountServers
 * @Description TODO
 * @Date 2021/2/14 15:28
 * @Created by Administrator
 * 这里有一幅服务器分布图，服务器的位置标识在 m * n 的整数矩阵网格 grid 中，1 表示单元格上有服务器，0 表示没有。
 * 如果两台服务器位于同一行或者同一列，我们就认为它们之间可以进行通信。
 * 请你统计并返回能够与至少一台其他服务器进行通信的服务器的数量。
 */
public class CountServers {
    public static void main(String[] args) {
        int[][] grid = {{1, 0}, {1, 1}};
        int[][] grid2={{1,1,0,0},{0,0,1,0},{0,0,1,0},{0,0,0,1}};
        System.out.println(countServers(grid2));
    }

    public static int countServers(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[] cntOfRow = new int[m];
        int[] cntOfCol = new int[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    cntOfRow[i]++;
                    cntOfCol[j]++;
                }
            }
        }
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && (cntOfRow[i] > 1 || cntOfCol[j] > 1)) {
                    res++;
                }
            }
        }
        return res;
    }
}
