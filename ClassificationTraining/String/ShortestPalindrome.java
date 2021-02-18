package ClassificationTraining.String;

/**
 * @Classname ShortestPalindrome
 * @Description TODO
 * @Date 2020/4/1 15:59
 * @Created by 14241
 * Given a string s, you are allowed to convert it to a palindrome
 * by adding characters in front of it.
 * Find and return the shortest palindrome you can find by performing this transformation.
 */
public class ShortestPalindrome {
    public static void main(String[] args) {
        String s = "aacecaaa";
        System.out.println(shortestPalindrome(s));

    }

    public static String shortestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return null;
        }
        String recv = new StringBuilder(s).reverse().toString();
        int n = s.length();
        for (int i = 0; i < n; i++) {
            if (s.substring(0, n - i).equals(recv.substring(i))) {
                return recv.substring(0, i) + s;
            }
        }
        return recv + s;
    }

    public static String shortestPalindrome2(String s) {
        if (s == null || s.length() == 0) {
            return null;
        }
        String recv = new StringBuilder(s).reverse().toString();
        int n = s.length();
        for (int i = 0; i < s.length(); i++) {
            if (s.substring(0, n - i).equals(recv.substring(i))) {
                return recv.substring(0,i)+s;
            }
        }
        return recv + s;
    }
}
