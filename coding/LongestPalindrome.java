package coding;

/*Longest Palindromic Substring
问题描述
给定一个字符串s，找到s中的最长回文子串。假设s的最大长度是1000。
例1：
输入： “babad”
输出： “bab”
注意： “aba”也是一个有效的答案。

例2：
输入： “cbbd”
输出： “bb”*/

public class LongestPalindrome {

    public static void main(String[] args) {
        System.out.println(longestPalindrome("cbbd"));
    }

    public static String longestPalindrome(String s) {
        int n = s.length();
        String res = null;
        boolean[][] dp = new boolean[n][n];
		/*依次从最后面进行迭代，前一轮迭代为可能的回文的第一个字符，
		然后依次进行比对是否与第一个字符相等，如果不等则直接为False，
		然后进行后续比对，如果找到相同的字符，则比对左斜下的子字符的回文信息，
		由于i+1，j-1，所以开始比对的是第i-1和第j-1字符是否相等，依次向里面靠拢，直到相遇。*/
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                /*dp[i+1][j-1]是一个左斜下的小回文*/
                /*j-i<3是在只有三个字符或四个字符为回文时的快速判断，不需要获取左斜下对角的值*/
                dp[i][j] = s.charAt(i) == s.charAt(j) && (j - i < 3 || dp[i + 1][j - 1]);

                /*找出比之前更长的回文，则更新字符串*/
                if (dp[i][j] && (res == null || j - i + 1 > res.length())) {
                    res = s.substring(i, j + 1);

                }

            }
        }
        return res;
    }


}
