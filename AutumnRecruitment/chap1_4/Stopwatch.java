package AutumnRecruitment.chap1_4;

import AutumnRecruitment.StdOut;
import AutumnRecruitment.chap1.StdRandom;

import java.util.Random;

/**
 * @Classname StopWatch
 * @Description TODO
 * @Date 2019/10/2 17:28
 * @Created by 14241
 */
public class Stopwatch {
    private final long start;

    public Stopwatch() {
        start = System.currentTimeMillis();
    }

    public double elapsedTime() {
        long now = System.currentTimeMillis();
        return (now - start) / 1000.0;
    }

    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        int[] a = new int[N];
        for (int i = 0; i < N; i++) {
            a[i] = StdRandom.uniform(-1000000, 1000000);
        }
        Stopwatch timer = new Stopwatch();
        int cnt = ThreeSum.count(a);
        double time = timer.elapsedTime();
        StdOut.println(cnt + " triples " + time + " seconds");
    }
}
