package ClassificationTraining.SpringSprint;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给定两个由小写字母构成的字符串 A 和 B ，只要我们可以通过交换 A 中的两个字母得到与 B 相等的结果，
 * 就返回 true ；否则返回 false 。
 * 交换字母的定义是取两个下标 i 和 j （下标从 0 开始），只要 i!=j 就交换 A[i] 和 A[j] 处的字符。
 * 输入： A = "ab", B = "ba"
 * 输出： true
 * 解释： 你可以交换 A[0] = 'a' 和 A[1] = 'b' 生成 "ba"，此时 A 和 B 相等。
 */
public class BuddyString {
    public static void main(String[] args) {
        String a = "ab", b = "ba";
        System.out.println(buddyStrings(a, b));
    }
    public static boolean buddyStrings(String a, String b) {
        if (a.length() != b.length()) {
            return false;
        }
        if (a.equals(b)) {
            if (a.isEmpty()) {
                return false;
            }
            Map<Character, Integer> map = new HashMap<>();
            for (int i = 0; i < a.length(); i++) {
                map.put(a.charAt(i), map.getOrDefault(a.charAt(i), 0) + 1);
            }
            int maxCount = 0;
            for(int count :map.values()) {
                maxCount = Math.max(maxCount, count);
            }
            return maxCount > 1; }
        //只交换一次
        char[] aChs = a.toCharArray();
        char[] bChs = b.toCharArray();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < aChs.length; i++) {
            if (aChs[i] != bChs[i]) {
                list.add(i); } }
        if (list.size() != 2) {
            return false;
        }
        int index1 = list.get(0);
        int index2 = list.get(1);
        return aChs[index1] == bChs[index2] && aChs[index2] == bChs[index1];
    }
}
