package AutumnRecruitment.chap6;

import AutumnRecruitment.StdIn;
import AutumnRecruitment.StdOut;
import AutumnRecruitment.chap3_5.In;

/**
 * @Classname KWIC
 * @Description TODO
 * @Date 2020/1/17 23:23
 * @Created by 14241
 */
public class KWIC {
    public static void main(String[] args) {
        In in = new In(args[0]);
        int context = Integer.parseInt(args[1]);

        String text = in.readAll().replaceAll("\\s+", " ");
        int N = text.length();
        SuffixArray sa = new SuffixArray(text);

        while (StdIn.hasNextLine()) {
            String q = StdIn.readLine();
            for (int i = sa.rank(q); i < N && sa.select(i).startsWith(q); i++) {
                int from = Math.max(0, sa.index(i) - context);
                int to = Math.min(N - 1, from + q.length() + 2 * context);
                StdOut.println(text.substring(from, to));
            }
            StdOut.println();
        }
    }
}
