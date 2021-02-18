package ClassificationTraining.String;

/**
 * @Classname LongestPalindromeSubString
 * @Description TODO
 * @Date 2020/8/1 10:14
 * @Created by Administrator
 * Input: "babad"
 * Output: "bab"
 * Note: "aba" is also a valid answer.
 * 中心扩展法
 */
public class LongestPalindromeSubString {
    public static void main(String[] args) {
        String s = "babad";
        System.out.println(longestPalindrome(s));

    }
    public static String longestPalindrome(String s) {
        if (s == null || s.length() < 1) {
            return "";
        }
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len-1)/ 2 ;
                end = i + len / 2;
            }
        }
        return s.substring(start, end+1);

    }

    public static int expandAroundCenter(String s, int left, int right) {
        int L = left, R = right;
        while (L >= 0 && R < s.length()&& s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;
    }

//    public static String longestPalindrome(String s) {
//        String ans = "";
//        int max = 0;
//        for (int i = 0; i < s.length(); i++) {
//            for (int j = i + 1; j <= s.length(); j++) {
//                String test = s.substring(i, j);
//                if (isPalidrome(test) && test.length() > max) {
//                    ans = s.substring(i, j);
//                    max = Math.max(ans.length(), max);
//                }
//            }
//
//        }
//        return ans;
//
//
//    }
//
//    public static boolean isPalidrome(String s) {
//        for (int i = 0; i < s.length() / 2; i++) {
//            if (s.charAt(i) != s.charAt(s.length() - i - 1)) {
//                return false;
//            }
//        }
//        return true;
//    }
}
