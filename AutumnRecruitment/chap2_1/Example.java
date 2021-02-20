package AutumnRecruitment.chap2_1;

import AutumnRecruitment.StdOut;

/**
 * @Classname Example
 * @Description TODO
 * @Date 2019/11/14 16:44
 * @Created by 14241
 */
public class Example {
    public static void sort(Comparable[] a) {
    }

    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
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

    public static boolean isSorted(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            if (less(a[i], a[i - 1])) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String[] a = {"1","2","3"};
        sort(a);
        assert isSorted(a);
        show(a);
    }
}
