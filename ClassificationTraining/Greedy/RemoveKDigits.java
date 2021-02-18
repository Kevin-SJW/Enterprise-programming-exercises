package ClassificationTraining.Greedy;

/**
 * @Classname RemoveKDigits
 * @Description TODO
 * @Date 2020/8/5 0:02
 * @Created by Administrator
 * Given a non-negative integer num represented as a string,
 * remove k digits from the number so that the new number is the smallest possible.
 * The length of num is less than 10002 and will be ≥ k.
 * The given num does not contain any leading zero.
 */
public class RemoveKDigits {
    public static void main(String[] args) {
        String num = "1432219";
        int k = 3;
        System.out.println(removeKdigits2(num, k));
    }

    public static String removeKdigit(String num, int k) {
        if (k == 0) {
            return num;
        }
        if (k > num.length()) {
            return null;
        }
        StringBuilder sb = new StringBuilder(num);
        for (int i = 0; i < k; i++) {
            boolean mark = false;
            for (int j = 0; j < num.length() - 1; j++) {
                if (num.charAt(j) > num.charAt(j + 1)) {
                    sb.deleteCharAt(j);
                    mark = true;
                    break;
                }
            }
            if (!mark) {
                sb.deleteCharAt(sb.length() - 1);
            }
            while (sb.length() > 1 && sb.charAt(0) == '0') {
                sb.deleteCharAt(0);
            }
        }
        return sb.toString();
    }

    public static String removeKdigits2(String num, int k) {
        if (k == 0) {
            return num;
        }
        if (k > num.length()) {
            return null;
        }
        StringBuilder sb = new StringBuilder(num);
        for (int i = 0; i < k; i++) {
            boolean mark = false;
            for (int j = 0; j < num.length()-1; j++) {
                if (num.charAt(j) > num.charAt(i + 1)) {
                    sb.deleteCharAt(j);
                    mark = true;
                    break;
                }
            }
            if (!mark) {
                sb.deleteCharAt(sb.length() - 1);
            }
            while (sb.length() > 1 && sb.charAt(0) == '0') {
                sb.deleteCharAt(0);
            }
        }
        return sb.toString();
    }
}
