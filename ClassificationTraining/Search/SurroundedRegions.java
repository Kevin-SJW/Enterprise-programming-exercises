package ClassificationTraining.Search;

/**
 * @Classname SurroundedRegions
 * @Description TODO
 * @Date 2020/8/11 0:50
 * @Created by Administrator
 */
public class SurroundedRegions {
    public static void main(String[] args) {
        char[][] board = {
                {'X', 'X', 'X', 'X'},
                {'X', '0', '0', 'X'},
                {'X', 'X', '0', 'X'},
                {'X', '0', 'X', 'X'}};
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println(); } }
    private int[][] dirArr = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    public void solve(char[][] board) {
        if (board == null || board.length < 1) {
            return;
        }
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[0].length; c++) {
                if ((r == 0 || r == board.length - 1
                        || c == 0 || c == board[0].length - 1) && board[r][c] == 'O') {
                    dfs(board, r, c); } }
        }
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[0].length; c++) {
                board[r][c] = board[r][c] == '#' ? 'O' : 'X'; } }
    }
    private void dfs(char[][] board, int r, int c) {
        if (inArea(board, r, c) && board[r][c] == 'O') {
            board[r][c] = '#';
            for (int[] dir : dirArr) {
                dfs(board, r + dir[0], c + dir[1]); } }
    }
    private boolean inArea(char[][] board, int r, int c) {
        return r >= 0 && r < board.length && c >= 0 && c < board[0].length;
    }

}
