package AutumnRecruitment.chap3_5;

import AutumnRecruitment.StdIn;
import AutumnRecruitment.StdOut;

/**
 * @Classname WhiteFilter
 * @Description TODO
 * @Date 2019/12/10 16:53
 * @Created by 14241
 */
public class WhiteFilter {

    public static void main(String[] args) {
        SET<String> set = new SET<String>();
        In in = new In(args[0]);
        while (!in.isEmpty()) {
            set.add(in.readString());
        }
        while (!StdIn.isEmpty()) {
            String word = StdIn.readString();
            if (set.contains(word)) {
                StdOut.print(word + " ");
            }
        }
    }
}
