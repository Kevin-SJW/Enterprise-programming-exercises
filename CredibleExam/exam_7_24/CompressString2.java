package CredibleExam.exam_7_24;

/**
 * @Classname CompressString2
 * @Description TODO
 * @Date 2020/8/1 8:41
 * @Created by Administrator
 * 字符串压缩。利用字符重复出现的次数，编写一种方法，实现基本的字符串压缩功能。
 * 比如，字符串aabcccccaaa会变为a2b1c5a3。若“压缩”后的字符串没有变短，
 * 则返回原先的字符串。你可以假设字符串中只包含大小写英文字母（a至z）。
 * <p>
 * 示例1:
 * <p>
 * 输入："aabcccccaaa"
 * 输出："a2b1c5a3"
 */
public class CompressString2 {
    public static void main(String[] args) {
        String s = "aabcccccaaa";
        System.out.println(compressString(s));

    }

    public static String compressString(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        char pre = s.charAt(0);
        int count = 1;
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < s.length(); i++) {
            char cur = s.charAt(i);

            if (pre == cur) {
                count++;
            } else {
                sb.append(pre).append(count);
                pre = cur;
                count = 1;
            }
        }
        sb.append(pre).append(count);
        if (sb.length() >= s.length()) {
            return s;
        }
        return sb.toString();

    }

    public static String compressString2(String s) {
        if (s == null || s.length() == 0) {
            return null;
        }
        int count = 1;
        char pre = s.charAt(0);
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < s.length(); i++) {
            char cur = s.charAt(i);
            if (pre == cur) {
                count++;
            } else {
                sb.append(pre).append(count);
                pre = cur;
                count = 1;
            }
        }
        sb.append(pre).append(count);


        if (sb.length() >= s.length()) {
            return s;
        }
        return sb.toString();

    }
}
