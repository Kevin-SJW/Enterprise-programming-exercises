package coding; /**
 * @Classname JumpSteps
 * @Description TODO
 * @Date 2019/4/12 18:51
 * @Created by 14241
 */
/**现在有一个真人游戏跳一跳，说是在一个n行n列的方阵,每个位置都有一个可以升降且高度不同的方块，
 * 高度是已知的，当人跳上去之后可以自己控制升降，每个方块的升降速度是每1单位时间能升高1单位高度，
 * 要求玩家以最快的速度从(0,0)到达(n-1,n-1)的方块，从一个方块跳跃到另外一个方块，
 * 只能在高度相同或者从高的往低的移动，如果一个方块的高度比周围的低，
 * 那么需要等待方块高度与周围方块任意一个相同时才能移动，请计算等待的最短时间
 *
 * 输入:
 * 输入n*n的高度，参数是一个二维数组
 * 输入数据包含一行，
 * 行之间用分号隔开
 * 列之前用逗号分割
 * 输出:
 * 返回需要等待的时间
 * 输入范例:
 * 输入 0,5;6,3
 * 最终转换成 [[0,5],[6,3]]
 * 输出范例:
 * 5
 */

import java.util.Scanner;

public class JumpSteps {

/** 请完成下面这个函数，实现题目要求的功能 **/
    /** 当然，你也可以不按照这个模板来作答，完全按照自己的想法来 ^-^  **/

    /*现要求参赛选手以最短的等待时间从(0,0)到达(n-1,n-1)。在升降杆之间移动时可以选择相邻的上、下、左、右四个方向的升降杆，
    但是只能平移或下滑，即在高度相同的两个升降杆之间移动或从高处移到低处，如果一个升降杆的高度比其他四个方向上的升降杆的低，
    则必须等待升降杆提升至高度于其他相邻任意之一相同时才能移动，升降杆提升速度是每1单位时间能升高1单位高度。*/

    /**
     * 动态规划就是利用分治思想和解决冗余的办法来处理问题，所以必然会有dp数组来实现记忆搜索，
     * 从而解决冗余，而分治思想就是递归的思想，总的问题可以分为若干相同的子问题，所有子问题的解合并即是该问题的解。
     * 递归解决问题是一个自顶向下的思路，一直从最大的问题（顶）递归至小问题（下，底），
     * 只有小问题解决了，一层一层地返回，便可以得到最终的结果。
     * 动态规划解决问题是一个自底而上的思路，从小问题（下）开始，把小问题的计算结果保存至dp数组中，
     * 计算更大的问题时会用到小问题的结果，直接调用而不必重新计算，直到最大问题。

     */


    private static int dump(int[][] grid) {

        int[][] time = new int[grid.length][grid[0].length];


        for (int i = 1; i < time.length; i++) {
            time[i][0] = time[i - 1][0];
            if (grid[i - 1][0] < grid[i][0]) {
                time[i][0] += grid[i][0] - grid[i - 1][0];
            }
        }
        for (int i = 0; i < time.length; i++) {
            for (int j = 1; j < time[i].length; j++) {
                time[i][j] = time[i][j - 1];
                if (grid[i][j - 1] < grid[i][j]) {
                    time[i][j] += grid[i][j] - grid[i][j - 1];
                }
            }
        }


        work(grid, time);
        work(grid, time);
        work(grid, time);

        return time[grid.length-1][grid[0].length-1];


    }


    private static void work(int[][] grid, int[][] time) {


        for (int i = 1; i < time.length; i++) {
            for (int j = 0; j < time[i].length; j++) {
                int tmp = time[i - 1][j];
                if (grid[i - 1][j] < grid[i][j]) {
                    tmp += grid[i][j] - grid[i - 1][j];
                }
                if (time[i][j] > tmp) {
                    time[i][j] = tmp;
                }
            }
        }


        for (int i = 0; i < time.length; i++) {
            for (int j = 1; j < time[i].length; j++) {
                int tmp = time[i][j - 1];
                if (grid[i][j - 1] < grid[i][j]) {
                    tmp += grid[i][j] - grid[i][j - 1];
                }
                if (time[i][j] > tmp) {
                    time[i][j] = tmp;
                }
            }
        }


        for (int i = time.length - 2; i >= 0; i--) {
            for (int j = 0; j < time[i].length; j++) {
                int tmp = time[i + 1][j];
                if (grid[i][j] > grid[i + 1][j]) {
                    tmp += grid[i][j] - grid[i + 1][j];
                }
                if (time[i][j] > tmp) {
                    time[i][j] = tmp;
                }
            }
        }


        for (int i = 0; i < time.length; i++) {
            for (int j = time[i].length - 2; j >= 0; j--) {
                int tmp = time[i][j + 1];
                if (grid[i][j + 1] < grid[i][j]) {
                    tmp += grid[i][j] - grid[i][j + 1];
                }
                if (time[i][j] > tmp) {
                    time[i][j] = tmp;
                }
            }
        }


    }

    public static void main(String[] args){
//这里的转换已经写好，按照输入描述输入即可,main方法代码不用修改 ，
//重点在实现dump方法
        Scanner in = new Scanner(System.in);
        String s  = in.nextLine().trim();
        String[] array = s.split(";");
        int[][] grid = new int[array.length][array[0].split(",").length];
        for(int i=0;i<array.length;i++){
            String[] l= array[i].split(",");
            for(int k=0;k<l.length;k++){
                grid[i][k] =Integer.parseInt(l[k]);
            }
        }
        int res =dump(grid);
        System.out.println(String.valueOf(res));
    }
}
