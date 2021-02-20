package AutumnRecruitment.chap2_3;

import AutumnRecruitment.StdOut;

/**
 * @Classname Ex05
 * @Description 只有两种主键值的数值排序
 * @Date 2019/12/2 20:13
 * @Created by 14241
 */
public class Ex05 {
    public static void sort(Comparable[] a) {
        for (int i = 1, lo = 0, hi = a.length - 1; i <= hi;) {
            int comp = a[i].compareTo(a[lo]);
            if (comp < 0) {
                exch(a, lo++, i++);
            } else if (comp > 0) {
                exch(a, i, hi--);
            } else {
                i++;
            }
        }
    }

    private static void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    private static void show(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            StdOut.print(a[i] + " ");
        }
        StdOut.println();
    }

    public static void main(String[] args) {
        String[] a = {"1","2","3"};
        sort(a);
        show(a);
    }
}
