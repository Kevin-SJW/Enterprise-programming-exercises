package AutumnRecruitment.chap2_5;

import AutumnRecruitment.StdIn;

import java.util.Arrays;

/**
 * @Classname Frequency
 * @Description TODO
 * @Date 2019/12/5 16:52
 * @Created by 14241
 */
public class Frequency {
    public static void main(String[] args) {
        String[] a = StdIn.readAllStrings();
        Arrays.sort(a);
        Record[] records = new Record[a.length];
        records[0] = new Record(a[0]);
        int n = 0;
        for (int i = 1; i < a.length; i++) {
            if (records[n].getWord().equals(a[i])) {
                records[n].addFreq();
            } else {
                records[++n] = new Record(a[i]);
            }
        }
        Arrays.sort(records, 0, n);
        for (int i = 0; i <= n; i++) {
            Record record = records[i];
            System.out.println(record.getWord() + ": " + record.getFreq());
        }
    }
}
