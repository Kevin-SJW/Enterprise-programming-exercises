package AutumnRecruitment.chap5_5;

import AutumnRecruitment.StdOut;

/**
 * @Classname BinaryDump
 * @Description TODO
 * @Date 2020/1/17 22:53
 * @Created by 14241
 */
public class BinaryDump {
    public static void main(String[] args) {
        int width = Integer.parseInt(args[0]);
        int cnt;
        for (cnt = 0; !BinaryStdIn.isEmpty(); cnt++) {
            if (width == 0) {
                continue;
            }
            if (cnt != 0 && cnt % width == 0) {
                StdOut.println();
            }
            if (BinaryStdIn.readBoolean()) {
                StdOut.print("1");
            } else {
                StdOut.print("0");
            }
        }
        StdOut.println();
        StdOut.println(cnt + " bits");
    }
}
