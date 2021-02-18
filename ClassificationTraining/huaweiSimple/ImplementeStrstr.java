package ClassificationTraining.huaweiSimple;

/**
 * Return the index of the first occurrence of needle in haystack,
 * or -1 if needle is not part of haystack.
 */
public class ImplementeStrstr {
    public static void main(String[] args) {
        String haystack = "hello", needle = "ll";
        System.out.println(strStr(haystack, needle));
    }

    public static int strStr(String haystack, String needle) {
        char[] a1 = haystack.toCharArray();
        char[] a2 = needle.toCharArray();
        if (a2.length == 0) {
            return 0;
        }

        for (int i = 0; i < a1.length; i++) {
            boolean flag = true;
            for (int j = 0; j < a2.length; j++) {
                if (i + j > a1.length || a1[i + j] != a2[j]) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                return i;
            }
        }
        return -1;
    }

    public static int strStr2(String hayStack, String needle) {
        char[] a1 = hayStack.toCharArray();
        char[] a2 = needle.toCharArray();
        if (a2.length == 0) {
            return 0;
        }

        for (int i = 0; i < a1.length; i++) {
            boolean flag = true;
            for (int j = 0; j < a2.length; j++) {
                if (i + j > a1.length || a1[i + j] != a2[j]) {
                    flag = false;
                }
            }
            if (flag) {
                return i;
            }
        }
        return -1;
    }
}
