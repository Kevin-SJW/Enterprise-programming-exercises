package ClassificationTraining.huaweiMiddle;

/**
 * 具体来说，要找到字典序最大的字符串，你需要经历两个阶段：
 * 将所有字符串连接成一个循环字符串，你可以选择是否翻转某些字符串，并按照给定的顺序连接它们。
 * 在循环字符串的某个位置分割它，这将使循环字符串从分割点变成一个常规的字符串。
 * 你的工作是在所有可能的常规字符串中找到字典序最大的一个。
 * 输入: "abc", "xyz"
 * 输出: "zyxcba"
 * 解释: 你可以得到循环字符串 "-abcxyz-", "-abczyx-", "-cbaxyz-", "-cbazyx-"，
 * 其中 '-' 代表循环状态。
 * 答案字符串来自第四个循环字符串，
 * 你可以从中间字符 'a' 分割开然后得到 "zyxcba"。
 */
public class SplitLoopedString {
    private static String ans = "";

    public static void main(String[] args) {
        String[] str = {"abc", "xyz"};
        System.out.println(splitLoopedString(str));
    }

    public static String splitLoopedString(String[] strs) {
        for (int i = 0; i != strs.length; ++i) {
            String str = strs[i];
            String rev = new StringBuffer(str).reverse().toString();
            if (rev.compareTo(str) > 0)
                strs[i] = rev;
        }
        String ans = "";
        for (int i = 0; i != strs.length; ++i) {
            String str = strs[i];
            String rev = new StringBuffer(str).reverse().toString();
            String other = "";
            for (int j = i + 1; j != strs.length; ++j)
                other += strs[j];
            for (int j = 0; j != i; ++j)
                other += strs[j];
            for (int j = 0; j != str.length(); ++j) {
                String cur = str.substring(j) + other + str.substring(0, j);
                if (cur.compareTo(ans) > 0)
                    ans = cur;
            }
            for (int j = 0; j != str.length(); ++j) {
                String cur = rev.substring(j) + other + rev.substring(0, j);
                if (cur.compareTo(ans) > 0)
                    ans = cur;
            }
        }
        return ans;
    }


    public static String splitLoopedString2(String[] strs) {
        dfs("", strs, 0);
        return ans;
    }

    public static void dfs(String prefix, String[] strs, int cur_index) {
        if (cur_index == strs.length) {
            for (int i = 0; i != prefix.length(); ++i) {
                String cur = prefix.substring(i) + prefix.substring(0, i);
                if (cur.compareTo(ans) > 0) {
                    ans = cur;
                }
            }
        } else {
            String cur_str = strs[cur_index];
            String next_prefix = prefix + cur_str;
            dfs(next_prefix, strs, cur_index + 1);
            next_prefix = prefix + new StringBuffer(cur_str).reverse().toString();
            dfs(next_prefix, strs, cur_index + 1);
        }
    }
}
