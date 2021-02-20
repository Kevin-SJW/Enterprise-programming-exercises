package AutumnRecruitment.chap3_5;

import AutumnRecruitment.StdIn;
import AutumnRecruitment.StdOut;



/**
 * @Classname DeDup
 * @Description TODO
 * @Date 2019/12/10 16:41
 * @Created by 14241
 */
public class DeDup {

    public static void main(String[] args) {
        SET<String> set = new SET<String>();
        while (!StdIn.isEmpty()) {
            String key = StdIn.readString();
            if (!set.contains(key)) {
                set.add(key);
                StdOut.print(key + " ");
            }
        }
    }
}
