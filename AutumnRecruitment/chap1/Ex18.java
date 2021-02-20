package AutumnRecruitment.chap1;

import java.util.Scanner;

/**
 * @Classname Ex18
 * @Description TODO
 * @Date 2019/9/21 11:00
 * @Created by 14241
 */
public class Ex18 {
    public static int mystery(int a, int b) {
        if (b == 0) {
            return 0;
        }
        if (b % 2 == 0) {
            return mystery(a + a, b / 2);
        }
        return mystery(a + a, b / 2) + a;
    }

    public static int mystery2(int a, int b) {
        if (b == 0) {
            return 1;
        }
        if (b % 2 == 0) {
            return mystery2(a * a, b / 2);
        }
        return mystery2(a * a, b / 2) * a;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        System.out.println(mystery(2, 25));
        System.out.println(mystery(3, 11));
        System.out.println(mystery(a, b) == a * b);

        System.out.println(mystery2(2, 25));
        System.out.println(mystery2(3, 11));
        System.out.println(mystery2(a, b) == Math.pow(a, b));
    }
}
