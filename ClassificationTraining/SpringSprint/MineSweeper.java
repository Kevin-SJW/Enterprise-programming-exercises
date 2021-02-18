package ClassificationTraining.SpringSprint;

import java.util.Arrays;

/**
 * 给定一个代表游戏板的二维字符矩阵。 
 * 'M' 代表一个未挖出的地雷，
 * 'E' 代表一个未挖出的空方块，
 * 'B' 代表没有相邻（上，下，左，右，和所有4个对角线）地雷的已挖出的空白方块，
 * 数字（'1' 到 '8'）表示有多少地雷与这块已挖出的方块相邻，
 * 'X' 则表示一个已挖出的地雷。
 * 现在给出在所有未挖出的方块中（'M'或者'E'）的下一个点击位置（行和列索引），根据以下规则，
 * 返回相应位置被点击后对应的面板：
 * 如果一个地雷（'M'）被挖出，游戏就结束了- 把它改为 'X'。
 * 如果一个没有相邻地雷的空方块（'E'）被挖出，修改它为（'B'），并且所有和其相邻的未挖出方块都应该被递归地揭露。
 * 如果一个至少与一个地雷相邻的空方块（'E'）被挖出，修改它为数字（'1'到'8'），表示相邻地雷的数量。
 * 如果在此次点击中，若无更多方块可被揭露，则返回面板。
 * [['E', 'E', 'E', 'E', 'E'],
 * ['E', 'E', 'M', 'E', 'E'],
 * ['E', 'E', 'E', 'E', 'E'],
 * ['E', 'E', 'E', 'E', 'E']]
 * Click : [3,0]
 */
public class MineSweeper {
    public static void main(String[] args) {
        char[][] boadr = {{'E', 'E', 'E', 'E', 'E'},
                {'E', 'E', 'M', 'E', 'E'},
                {'E', 'E', 'E', 'E', 'E'},
                {'E', 'E', 'E', 'E', 'E'}};
        int[] click = {3, 0};
        System.out.println(Arrays.deepToString(updateBoard(boadr, click)));
    }
    static int R, C;
    static int[][] dirs = new int[][]{{-1, -1}, {-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}};
    public static char[][] updateBoard(char[][] board, int[] click) {
        R = board.length;
        C = board[0].length;
        dfs(board, click[0], click[1]);
        return board;

    }
    public static void dfs(char[][] board, int r, int c) {
        if (!inArea(r, c)) {
            return;
        }
        if (board[r][c] == 'M') {
            board[r][c] = 'X';
            return;
        }
        if (board[r][c] == 'E') {
            detect(board, r, c);
            if (board[r][c] == 'B') {
                for (int[] d : dirs) {
                    int nr = d[0]+r, nc = d[1]+c;
                    dfs(board, nr, nc); } } } }
    public static void detect(char[][] board, int r, int c) {
        int bomb = 0;
        for (int[] d : dirs) {
            int nr = d[0] + r, nc = d[1] + c;
            if (inArea(nr, nc) && board[nr][nc] == 'M') {
                bomb++; } }
        board[r][c] = bomb > 0 ? (char) (bomb + '0') : 'B';
    }
    public static boolean inArea(int r, int c) {
        return r >= 0 && r < R && c >= 0 && c < C;
    }
}
