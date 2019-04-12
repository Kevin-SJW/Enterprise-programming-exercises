/**
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

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class JumpSteps {

/** 请完成下面这个函数，实现题目要求的功能 **/
    /** 当然，你也可以不按照这个模板来作答，完全按照自己的想法来 ^-^  **/


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
