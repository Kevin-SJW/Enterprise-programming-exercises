package CredibleExam.exam_3_20;

/**
 * @Classname StringIterator
 * @Description TODO
 * @Date 2020/7/22 0:22
 * @Created by Administrator
 * 逐一判断每个字符，遇到是数字的时候就循环前一个字符N次，
 * 注意数字有可能是大于10，即不一定是一位数
 */
public class StringIterator {

    private String compressedString;
    int c = 0;
    private int pos = 0;
    private char ch;

    public static void main(String[] args) {
        StringIterator iterator = new StringIterator("L1E2T1C1O1D1E");

    }

    public StringIterator(String compressedString) {
        this.compressedString = compressedString;
    }

    public char next() {
        if (c > 0) {
            c--;
            return ch;
        }
        if (pos >= compressedString.length()) {
            return ' ';
        }
        ch = compressedString.charAt(pos++);
        while (pos < compressedString.length()
                && isDigit(compressedString.charAt(pos))) {
            c = c * 10 + compressedString.charAt(pos++) - '0';
        }
        c--;
        return ch;
    }

    public boolean isDigit(char c) {
        return Character.isDigit(c);
    }

    public boolean hasNext() {
        return c > 0 || pos < compressedString.length();
    }

}
