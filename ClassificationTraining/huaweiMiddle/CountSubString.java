package ClassificationTraining.huaweiMiddle;

/**
 * @Classname CountSubString
 * @Description TODO
 * @Date 2020/9/13 13:00
 * @Created by Administrator
 * 回文子串
 */
public class CountSubString {
    public static void main(String[] args) {
        String s = "aaa";
        System.out.println(countSubstrings(s));

    }

    public static int countSubstrings(String s) {
        if (s.length() == 0 || s.length() == 1) {
            return s.length();
        }
        //从两个字符，直到N个字符长度
        int count = s.length();
        for (int i = 2; i <= s.length(); i++) {
            for (int j = 0; j <= s.length() - i; j++) {
                if (isPalindrome(s.substring(j, j + i))) {
                    count++;
                }
            }
        }
        return count;

    }

    public static int countSubstrings2(String s) {
        if (s.length() == 0 || s.length() == 1) {

        }
        //从两个字符，直到N个字符长度
        int count = s.length();
        for (int i = 2; i <= s.length(); i++) {
            for (int j = 0; j <= s.length() - i; j++) {
                if (isPalindrome(s.substring(j, j + i))) {
                    count++;
                }
            }
        }
        return count;

    }

    public static boolean isPalindrome(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }
}
