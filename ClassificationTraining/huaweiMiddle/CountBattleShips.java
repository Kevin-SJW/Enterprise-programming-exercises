package ClassificationTraining.huaweiMiddle;

/**
 * @Classname CountBattleShips
 * @Description TODO
 * @Date 2020/10/4 11:41
 * @Created by Administrator
 * 给定一个二维的甲板， 请计算其中有多少艘战舰。 战舰用 'X'表示，空位用 '.'表示。 你需要遵守以下规则：
 * 给你一个有效的甲板，仅由战舰或者空位组成。
 * 战舰只能水平或者垂直放置。换句话说,战舰只能由 1xN (1 行, N 列)组成，
 * 或者 Nx1 (N 行, 1 列)组成，其中N可以是任意大小。
 * 两艘战舰之间至少有一个水平或垂直的空位分隔 - 即没有相邻的战舰。
 * X..X
 * ...X
 * ...X
 * 我们可以通过战舰的头来判断个数，当一个点上面或者左面试X说明它战舰中间部分，跳过即可！
 */


public class CountBattleShips {

    public static int countBattleships(char[][] board) {
        int ans = 0;
        if (board.length == 0) {
            return 0;
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] != 'X') {
                    continue;
                }
                if (i > 0 && board[i - 1][j] == 'X') {
                    continue;
                }
                if (j > 0 && board[i][j - 1] == 'X') {
                    continue;
                }
                ans++;
            }
        }
        return ans;
    }
}
