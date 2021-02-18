package ClassificationTraining.huaweiMiddle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Classname PartitionLabels
 * @Description TODO
 * @Date 2020/10/2 16:49
 * @Created by Administrator
 */
public class PartitionLabels {
    public static void main(String[] args) {
        String s = "ababcbacadefegdehijhklij";
        partitionLabels2(s).stream().forEach(t -> System.out.print(t + " "));

    }

    public static List<Integer> partitionLabels(String s) {
        List<Integer> res = new ArrayList<>();
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), i);
        }
        int index = 0;
        int right = 0;
        for (int j = index; j < s.length(); j++) {
            right = Math.max(map.get(s.charAt(j)), right);
            if (j == right) {
                res.add(j - index + 1);
                index = j + 1;
            }
        }
        return res;
    }

    public static List<Integer> partitionLabels2(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), i);
        }
        int index = 0;
        int right = 0;
        List<Integer> ans = new ArrayList<>();
        for (int j = index; j < s.length(); j++) {
            right = Math.max(map.get(s.charAt(j)), right);
                if (right == j) {
                    ans.add(j - index + 1);
                    index = j + 1;
                }

        }
        return ans;
    }
}
