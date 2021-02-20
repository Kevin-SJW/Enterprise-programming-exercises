package AutumnRecruitment.chap3_5;

import AutumnRecruitment.StdIn;

import static sun.java2d.cmm.ColorTransform.In;

/**
 * @Classname Concordance
 * @Description TODO
 * @Date 2019/12/10 16:40
 * @Created by 14241
 */
public class Concordance {
    private static final int CONTEXT = 5;

    public static void main(String[] args) {
        ST<String, SET<Integer>> st = new ST<>();
        In in = new In(args[0]);
        String[] words = in.readAllStrings();
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            if (!st.contains(word)) {
                st.put(word, new SET<Integer>());
            }
            st.get(word).add(i);
        }
        while (!StdIn.isEmpty()) {
            String query = StdIn.readString();
            if (st.contains(query)) {
                for (int pos : st.get(query)) {
                    for (int i = Math.max(0, pos - CONTEXT + 1); i < pos; i++) {
                        System.out.print(words[i] + " ");
                    }
                    System.out.print("\"" + words[pos] + "\"");
                    for (int i = pos + 1; i < Math.min(words.length, pos + CONTEXT); i++) {
                        System.out.print(" " + words[i]);
                    }
                    System.out.println();
                }
            }
        }
    }
}
