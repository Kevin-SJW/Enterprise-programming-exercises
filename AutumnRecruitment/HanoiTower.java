package AutumnRecruitment;

/**
 * @Classname HanoiTower
 * @Description TODO
 * @Date 2019/9/29 21:06
 * @Created by 14241
 */

import java.util.*;

public class HanoiTower {

    Scanner in = new Scanner(System.in);
    int step, n;	// step移动的步数，n盘子个数

    public HanoiTower() {
        while(in.hasNext()){
            step = 1;	// 每次都重置为第一步
            n = in.nextInt();	// 输入盘子个数
            hanoi(n, 'A', 'B', 'C');	// 将n个盘子从A柱子移动到C柱子
            System.out.println(step);
            System.out.println();	// 每组数据空一行
        }
    }

    public static void main(String[] args) {
        new HanoiTower();
    }

    /**
     * n 盘子个数
     * A 当前状态的第一根柱子
     * B 当前状态的第二根柱子
     * C 当前状态的第三根柱子
     */
    public void hanoi(int n, char A, char B, char C) {
        if(1 == n) {	// 只有一个盘子直接从A柱子移动到C柱子
            move(A, C);
        } else {
            hanoi(n - 1, A, C, B);	// 将上面n-1个盘子从A柱子移动到B柱子
            move(A, C);	// 将最下面的盘子从A柱子移动到C柱子
            hanoi(n - 1, B, A, C);	// 将B柱子上的n-1个盘子移动到C柱子
        }
    }

    /**
     * 将盘子从x柱子移到y柱子，步数加1
     * x 第一根柱子
     * y 第二根柱子
     */
    public void move(char x, char y) {
        System.out.println("Case #" + step + ": from " + x + " to " + y + ".");
        step++;
    }

}