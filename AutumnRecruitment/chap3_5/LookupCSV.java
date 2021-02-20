package AutumnRecruitment.chap3_5;

import AutumnRecruitment.StdIn;
import AutumnRecruitment.StdOut;

/**
 * @Classname LookupCSV
 * @Description TODO
 * @Date 2019/12/10 16:52
 * @Created by 14241
 */
public class LookupCSV {

    public static void main(String[] args) {
        In in = new In(args[0]);
        int keyField = Integer.parseInt(args[1]);
        int valField = Integer.parseInt(args[2]);
        ST<String, String> st = new ST<String, String>();
        while (in.hasNextLine()) {
            String line = in.readLine();
            String[] tokens = line.split(",");
            String key = tokens[keyField];
            String val = tokens[valField];
            st.put(key, val);
        }
        while (!StdIn.isEmpty()) {
            String query = StdIn.readString();
            if (st.contains(query)) {
                StdOut.println(st.get(query));
            }
        }
    }
}
