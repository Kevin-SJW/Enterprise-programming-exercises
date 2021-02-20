package CredibleExam.exam_7_24;

import java.util.*;

/**
 * @Classname CompressStringLCCI
 * @Description TODO
 * @Date 2020/8/1 7:59
 * @Created by Administrator
 */
public class CompressStringLCCI {
    public static void main(String[] args) {
        String s = "aabcccccaaa";
        System.out.println(compressString(s));

    }

    public static String compressString(String s) {
        int len = s.length();
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }

        StringBuilder sb = new StringBuilder();

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            sb.append(entry.getKey()).append(entry.getValue());
        }
        String res = sb.toString();
        if (res.length() > len) {
            return s;
        } else {
            return res;
        }
    }
}
