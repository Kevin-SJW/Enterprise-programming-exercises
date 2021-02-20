package AutumnRecruitment.chap6;

import AutumnRecruitment.StdIn;
import AutumnRecruitment.StdOut;

/**
 * @Classname LRS
 * @Description TODO
 * @Date 2020/1/17 23:23
 * @Created by 14241
 */
public class LRS {
    public static void main(String[] args) {
        String text = StdIn.readAll();
        int N = text.length();
        SuffixArray sa = new SuffixArray(text);
        String lrs = "";
        for (int i = 1; i < N; i++) {
            int length = sa.lcp(i);
            if (length > lrs.length()) {
                lrs = sa.select(i).substring(0, length);
            }
        }
        StdOut.println(lrs);
    }
}
