package ClassificationTraining.huaweiSimple;

/**
 * 对于字符串 S 和 T，只有在 S = T + ... + T（T 与自身连接 1 次或多次）时，
 * 我们才认定 “T 能除尽 S”。
 * 返回最长字符串 X，要求满足 X 能除尽 str1 且 X 能除尽 str2。
 * 输入：str1 = "ABCABC", str2 = "ABC"
 * 输出："ABC"
 */
public class GetcdOfStrings {
    public static void main(String[] args) {
        String str1 = "ABCABC", str2 = "ABC";
        System.out.println(gcdOfStrings(str1, str2));

    }

    public static String gcdOfStrings(String str1, String str2) {
        if (!(str1 + str2).equals(str2 + str1)) {
            return "";
        }
        return str1.substring(0, getGcd(str1.length(), str2.length()));

    }

    //辗转相除法
    public static int getGcd(int a, int b) {
        return b == 0 ? a : getGcd(b, a % b);
    }

    public static String getGcdOfStrings2(String str1, String str2) {
        if (!(str1 + str2).equals(str2 + str1)) {
            return " ";
        }
        return str1.substring(0, getGcd2(str1.length(), str2.length()));
    }

    public static int getGcd2(int a, int b) {
        return b == 0 ? a : getGcd2(b, a % b);
    }
}
