package ClassificationTraining.SpringSprint;

/**
 * @Classname LongestPalindrome
 * @Description TODO
 * @Date 2021/2/12 1:38
 * @Created by Administrator
 */
public class LongestPalindrome {
    public static void main(String[] args) {
        String s = "babad";
        System.out.println(longestPalindrome2(s));
    }


    public static String longestPalindrome(String s) {
        if (s == null || s.length() < 1) {
            return null;
        }
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }

        }
        return s.substring(start, end + 1);
    }

    private static int expandAroundCenter(String s, int left, int right) {
        int L = left, R = right;
        while (L > 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;
    }

    private static String longestPalindrome2(String s) {
        if (s == null || s.length() == 0) {
            return null;
        }
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter2(s, i, i);
            int len2 = expandAroundCenter2(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private static int expandAroundCenter2(String s, int left, int right) {
        int L = left, R = right;
        while (L > 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;
    }

    public static String longestPalindrome3(String s) {
        String res = "";
        for (int i = 0; i < s.length(); i++) {
            String s1 = palindrome3(s, i, i);
            String s2 = palindrome3(s, i, i + 1);
            res = res.length() > s1.length() ? res : s1;
            res = res.length() > s2.length() ? res : s2;

        }
        return res;
    }


    public static String palindrome3(String s, int l, int r) {
        //防止越界
        while (l > 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }
        return s.substring(l + 1, r - l - 1);
    }
}


