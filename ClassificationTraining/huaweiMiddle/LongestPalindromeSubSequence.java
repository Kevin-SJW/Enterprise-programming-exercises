package ClassificationTraining.huaweiMiddle;

/**
 * @Classname LongestPalindromeSubSequence
 * @Description TODO
 * @Date 2020/12/30 23:40
 * @Created by Administrator
 * 给定一个字符串 s ，找到其中最长的回文子序列，并返回该序列的长度。可以假设 s 的最大长度为 1000 。
 * "bbbab"
 * 4
 * 一个可能的最长回文子序列为 "bbbb"。
 */
public class LongestPalindromeSubSequence {
    public static void main(String[] args) {
        String s = "bbbab";
        System.out.println(longestPalindromeSubseq(s));
    }
    public static int longestPalindromeSubseq(String s) {
        if(s == null){
            return 0;
        }
        int[][] dp = new int[s.length()][s.length()];
        int n = s.length();
        for(int i = 0; i<n; i++){
            dp[i][i] = 1;
        }
        //从下往上遍历
        for(int i = n-1; i>=0; i--){
            for(int j = i+1; j<n; j++){
                //那么就说明在原先的基础上又增加了回文子序列的长度
                if(s.charAt(i) == s.charAt(j)){
                    dp[i][j] = dp[i+1][j-1] + 2;
                }
                //表明这时dp[i][j]只需取两者之间的最大值即可
                else{
                    dp[i][j] = Math.max(dp[i+1][j],dp[i][j-1]);
                }
            }
        }
        return dp[0][n-1];
    }

    public static boolean isPalindrome(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != s.charAt(s.length() - i - 1)) {
                return false;
            }
        }
        return true;
    }
}
