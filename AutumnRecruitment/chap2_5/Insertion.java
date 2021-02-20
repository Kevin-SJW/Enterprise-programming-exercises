package AutumnRecruitment.chap2_5;

import java.util.Comparator;

/**
 * @Classname Insertion
 * @Description TODO
 * @Date 2019/12/5 17:00
 * @Created by 14241
 */
public class Insertion {
    public static void sort(Object[] a, Comparator c) {
        int N = a.length;
        for (int i = 0; i < N; i++) {
            for (int j = i; j > 0 && less(c, a[j], a[j - 1]); j--) {
                exch(a, j, j - 1);
            }
        }
    }

    private static boolean less(Comparator c, Object v, Object w) {
        return c.compare(v, w) < 0;
    }

    private static void exch(Object[] a, int i, int j) {
        Object t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
}
