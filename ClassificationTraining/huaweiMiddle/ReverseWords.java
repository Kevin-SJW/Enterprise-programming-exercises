package ClassificationTraining.huaweiMiddle;

/**
 * @Classname ReverseWords
 * @Description TODO
 * @Date 2020/10/3 14:48
 * @Created by Administrator
 */
public class ReverseWords {
    public static void main(String[] args) {
        char[] s = {'t', 'h', 'e', ' ', 's', 'k', 'y', ' ', 'i', 's', ' ', 'b', 'l', 'u', 'e'};
        for (int i = 0; i < s.length; i++) {
            System.out.print(s[i]);
        }
        reverseWords(s);
        System.out.println();
        for (int i = 0; i < s.length; i++) {
            System.out.print(s[i]);
        }

    }

    public static void reverseWords(char[] s) {
        int len = s.length;
        if (s == null) {
            return;
        }
        //整体翻转
        reverse(s, 0, len - 1);

        int index = 0;
        //局部翻转
        for (int i = 0; i < s.length; i++) {
            if (s[i] == ' ') {
                reverse(s, index, i - 1);
                index = i + 1;
            }
        }
//        System.out.println();
//        for (int i = 0; i < s.length; i++) {
//            System.out.print(s[i]);
//        }
//        //翻转最后一个单词
        reverse(s, index, len - 1);
    }

    public static void reverseWords2(char[] s) {
        if (s == null) {
            return;
        }
        int len = s.length;
        reverse(s, 0, len - 1);
        int index = 0;
        for (int i = 0; i < s.length; i++) {
            if (s[i] == ' ') {
                reverse(s, index, i - 1);
                index = i + 1;
            }
        }
        reverse(s,index,len-1);

    }

    public static void reverse(char[] ch, int start, int end) {
        while (start < end) {
            char t = ch[end];
            ch[end] = ch[start];
            ch[start] = t;
            start++;
            end--;
        }
    }
}
