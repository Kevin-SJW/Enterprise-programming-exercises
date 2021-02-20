package CredibleExam.exam_7_24;

/**
 * @Classname WordCompression
 * @Description TODO
 * @Date 2020/8/1 15:01
 * @Created by Administrator
 * 1.压缩字符串为dic[i]的子序列，2.dic[i]为原始字符串的子序列
 */
public class WordCompression {
    public static void main(String[] args) {
        String s = "beeetteerr";
        String[] dic = {"bet", "beeter", "bbeter", "better", "breter", "sbret"};
        System.out.println(wordCompression(s, dic));
    }
    public static int wordCompression(String s, String[] dic) {
        int count = 0;
        String compressedStr = wordCompression(s);
        for (String str : dic) {
            if (isSubSequence(str, s) && isSubSequence(compressedStr, str)) {
                count++;
            }
        }
        return count;
    }
    //求压缩字符串
    public static String wordCompression(String s) {
        StringBuilder res = new StringBuilder();
        res.append(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                continue;
            } else {
                res.append(s.charAt(i));
            }
        }
        return res.toString();
    }
    //判断子序列
    public static boolean isSubSequence(String s, String t) {
        int index = -1;
        for (char c : s.toCharArray()) {
            index = t.indexOf(c, index + 1);
            if (index == -1) {
                return false;
            }
        }
        return true;
    }

}
