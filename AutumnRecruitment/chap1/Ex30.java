package AutumnRecruitment.chap1;

import java.util.Scanner;

/**
 * @Classname Ex30
 * @Description 互质
 * @Date 2019/9/21 14:49
 * @Created by 14241
 */
public class Ex30 {
    public static int euclid(int p, int q) {
        if (p < q) {
            int t = p;
            p = q;
            q = t;
        }
        if (q == 0) {
            return p;
        } else {
            return euclid(q, p % q);
        }
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int N = sc.nextInt();
        boolean[][] a = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                //当i，j互质时（无相同因子）
                a[i][j] = euclid(i, j) == 1;
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
    }
}
