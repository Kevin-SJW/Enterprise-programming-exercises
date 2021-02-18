package ClassificationTraining.huaweiMiddle;

/**
 * 给定两个字符串 a 和 b，寻找重复叠加字符串 a 的最小次数，使得字符串 b 成为叠加后的字符串 a 的子串，
 * 如果不存在则返回 -1。
 * 注意：字符串 "abc" 重复叠加 0 次是 ""，重复叠加 1 次是 "abc"，重复叠加 2 次是 "abcabc"。
 * 输入：a = "abcd", b = "cdabcdab"
 * 输出：3
 * 解释：a 重复叠加三遍后为 "abcdabcdabcd", 此时 b 是其子串。
 */
public class RepeatedStringMatch {
    public static void main(String[] args) {
        String a = "abcd", b = "cdabcdab";
        System.out.println(repeatedStringMatch2(a, b));
    }

    public static int repeatedStringMatch(String a, String b) {
        int count = 1;
        String temp = a;
        while (!temp.contains(b)) {
            if (temp.length() - b.length() >= a.length()) {//已经找不到B了
                return -1;
            }
            count++;
            temp += a;
        }
        return count;
    }

    public static int repeatedStringMatch2(String a, String b) {
        if (a.equals("") && !b.equals("")) {
            return -1;
        }
        int res = 0;
        int k = 1;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < k; i++) {
            sb.append(a);

            if (sb.toString().contains(b)) {
                res = k;
            } else {
                k++;
            }
        }
        return res;
    }
}
