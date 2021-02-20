package AutumnRecruitment;

import java.util.Scanner;

/**
 * @Classname InversePairSum
 * @Description TODO
 * @Date 2019/9/21 15:50
 * @Created by 14241
 */

public class InversePairSum {

    public static void count(int[] a) {
        long sum = 0;
        for (int i = 1; i < a.length; i++) {
            int j = i;
            while (j > 0) {
                if (a[j - 1] > a[i]) {
                    sum++;
                }
                j--;
            }
        }
        System.out.println(sum);
    }

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        while (cin.hasNext()) {
            int n = cin.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = cin.nextInt();
            }
            count(a);
        }
    }
}
