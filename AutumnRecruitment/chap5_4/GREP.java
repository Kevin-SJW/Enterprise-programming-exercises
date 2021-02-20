package AutumnRecruitment.chap5_4;

import AutumnRecruitment.StdIn;
import AutumnRecruitment.StdOut;

/**
 * @Classname GREP
 * @Description TODO
 * @Date 2020/1/17 22:51
 * @Created by 14241
 */
public class GREP {
    public static void main(String[] args) {
        String regexp = "(.*" + args[0] + ".*)";
        NFA nfa = new NFA(regexp);
        while (StdIn.hasNextLine()) {
            String txt = StdIn.readLine();
            if (nfa.recognizes(txt)) {
                StdOut.println(txt);
            }
        }
    }
}
