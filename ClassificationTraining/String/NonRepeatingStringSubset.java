package ClassificationTraining.String;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Classname NonRepeatingStringSubset
 * @Description TODO
 * @Date 2020/9/29 1:06
 * @Created by Administrator
 */
public class NonRepeatingStringSubset {
    public static void main(String[] args) {
        String s = "aba";
        System.out.println(nonRepeatingStringSubSet(s));

    }

    public static int nonRepeatingStringSubSet(String s) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            for (int j = i+1; j <= s.length(); j++) {
                res.add(s.substring(i, j));
            }
        }
        return countNumber(res);

    }

    public static int countNumber(List<String> list) {
        int count = 0;
        for (String str : list) {
            if (!isRepeating(str)) {
                count++;
            }
        }
        return count;

    }

    public static boolean isRepeating(String s) {
        Set<Character> set = new HashSet<>();
        if (s.length() == 0) {
            return false;
        }
        if (s.length() == 1) {
            return false;
        }
        for (int i = 0; i < s.length(); i++) {
            set.add(s.charAt(i));
        }
        if (set.size() == s.length()) {
            return false;
        }
        return true;
    }
}
