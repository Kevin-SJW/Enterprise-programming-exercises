package ClassificationTraining.huaweiMiddle;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 给定一个字符串S，检查是否能重新排布其中的字母，使得两相邻的字符不同。
 * 若可行，输出任意可行的结果。若不可行，返回空字符串。
 * 输入: S = "aab"
 * 输出: "aba"
 */
public class ReOrganizeString {
    public static void main(String[] args) {
        String s = "aab";
        System.out.println(reorganizeString(s));
    }

    public static String reorganizeString(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        PriorityQueue<Map.Entry<Character, Integer>> maxHeap
                = new PriorityQueue<>((o1, o2) -> o2.getValue() - o1.getValue());
        maxHeap.addAll(map.entrySet());

        Map.Entry<Character, Integer> pre = null;
        StringBuilder result = new StringBuilder(s.length());
        while (!maxHeap.isEmpty()) {
            Map.Entry<Character, Integer> cur = maxHeap.poll();
            if (pre != null && pre.getValue() > 0) {
                maxHeap.offer(pre);
            }
            result.append(cur.getKey());
            cur.setValue(cur.getValue() - 1);
            pre = cur;
        }
        return result.length() == s.length() ? result.toString() : "";
    }
}
