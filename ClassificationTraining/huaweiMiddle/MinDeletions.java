package ClassificationTraining.huaweiMiddle;

/**
 * @Classname MinDeletions
 * @Description TODO
 * @Date 2020/11/22 12:08
 * @Created by Administrator
 * 给你一个字符串 s ，它仅包含字符 'a' 和 'b'​​​​ 。
 * 你可以删除 s 中任意数目的字符，使得 s 平衡 。我们称 s 平衡的
 * 当不存在下标对 (i,j) 满足 i < j 且 s[i] = 'b' 同时 s[j]= 'a' 。
 * 请你返回使 s 平衡 的 最少 删除次数。
 * 输入：s = "aababbab"
 * 输出：2
 * 解释：你可以选择以下任意一种方案：
 * 下标从 0 开始，删除第 2 和第 6 个字符（"aababbab" -> "aaabbb"），
 * 下标从 0 开始，删除第 3 和第 6 个字符（"aababbab" -> "aabbbb"）。
 */
public class MinDeletions {
    public static void main(String[] args) {
        String s = "aababbab";
        System.out.println(minimumDeletions(s));
    }

    public static int minimumDeletions(String s) {
        int n = s.length();
        int[] sa = new int[n + 1];
        int[] sb = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            sa[i] = sa[i - 1];
            sb[i] = sb[i - 1];
            if (s.charAt(i - 1) == 'a') {
                sa[i]++;
            } else {
                sb[i]++;
            }
        }
        int res = Integer.MAX_VALUE;
        for (int i = 0; i <= n; i++) {
            res = Math.min(res, sb[i] + sa[n] - sa[i]);
        }
        return res;

    }

    public static int minimumDeletions2(String s) {
        int n = s.length();
        int[] sa = new int[n + 1];
        int[] sb = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            sa[i] = sa[i - 1];
            sb[i] = sb[i - 1];
            if (s.charAt(i - 1) == 'a') {
                sa[i]++;
            } else {
                sb[i]++;
            }
        }
        int res = Integer.MAX_VALUE;
        for (int i = 0; i <= n; i++) {
            res = Math.min(res, sb[i] + sa[n] - sa[i]);
        }
        return res;
    }
}
