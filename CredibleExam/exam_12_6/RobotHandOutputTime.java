package CredibleExam.exam_12_6;

import java.util.HashSet;
import java.util.Set;

/**
 * @Classname RobotHandOutputTime
 * @Description TODO
 * @Date 2020/7/11 19:59
 * @Created by Administrator
 */
public class RobotHandOutputTime {
    public static void main(String[] args) {
        String s = "zyxwvutsrqponmlkjihgfedcba";
        String word = "xyz";
        System.out.println(getRobotHandOutputTime2(s, word));

    }

    public static int getRobotHandOutputTime(String s, String word) {

        int time = 0;
        int index = 0;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < word.length(); i++) {
            for (int j = 0; j < s.length(); j++) {
                if (word.charAt(i) == s.charAt(j)) {
                    if (!set.contains(j)) {
                        time += Math.abs(j - index);
                        index = j;
                    }
                }
            }
        }
        return time;
    }

    public static int getRobotHandOutputTime2(String s, String word) {
        int pre = 0;
        int time = 0;
        for (char c : word.toCharArray()) {
            int index = s.indexOf(c);
            time += Math.abs(index - pre);
            pre = index;
        }
        return time;
    }
}
