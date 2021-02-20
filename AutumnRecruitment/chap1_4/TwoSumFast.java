package AutumnRecruitment.chap1_4;

import AutumnRecruitment.StdOut;

import java.util.Arrays;


/**
 * @Classname TwoSumFast
 * @Description TODO
 * @Date 2019/11/14 16:05
 * @Created by 14241
 */
public class TwoSumFast {
    public static int count(int[] a) {
        Arrays.sort(a);
        int N = a.length;
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            if (BinarySearch.rank(-a[i], a) > i) {
                cnt++;
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        int[] a = {1,2,3,5,8};
        StdOut.println(count(a));
    }
}
