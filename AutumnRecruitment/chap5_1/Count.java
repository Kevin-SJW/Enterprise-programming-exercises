package AutumnRecruitment.chap5_1;

import AutumnRecruitment.StdIn;
import AutumnRecruitment.StdOut;
import AutumnRecruitment.chap5_5.Alphabet;

/**
 * @Classname Count
 * @Description TODO
 * @Date 2020/1/17 22:13
 * @Created by 14241
 */
public class Count {
    public static void main(String[] args) {
        Alphabet alpha = new Alphabet(args[0]);
        int R = alpha.radix();
        int[] count = new int[R];

        String s = StdIn.readAll();
        int N = s.length();
        for (int i = 0; i < N; i++) {
            if (alpha.contains(s.charAt(i))) {
                count[alpha.toIndex(s.charAt(i))]++;
            }
        }

        for (int c = 0; c < R; c++) {
            StdOut.println(alpha.toChar(c) + " " + count[c]);
        }
    }
}
