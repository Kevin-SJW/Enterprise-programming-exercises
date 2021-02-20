package CredibleExam.exam_6_19;

/**
 * @Classname CountCharacters
 * @Description TODO
 * @Date 2020/7/18 20:43
 * @Created by Administrator
 * 获取可以掌控的单词的数目(1160)
 * 给定一个字符串数组words和字符数组chars，求出可以被chars中字母组成的单词的数目，
 * 组成单词用到的字母不能多于chars数组中的字母
 */
public class CountCharacters {
    public static void main(String[] args) {
        String[] words=new String[]{"cat","bt","hat","tree"};
        String chars="atach";
        System.out.println(countCharacters(words,chars));
    }
    public static int countCharacters(String[] words, String chars) {
        if (words == null || words.length == 0) {
            return 0;
        }
        if (chars == null || chars.length() == 0) {
            return 0;
        }
        int[] value = getChars(chars);
        int ans = 0;
        for (String word : words) {
            int[] cur = getChars(word);
            int curLen = word.length();
            if (isValid(value, cur)) {
                ans += curLen;
            }
        }
        return ans;
    }
    //string to integer array
    private static int[] getChars(String str) {
        int[] value = new int[26];
        int len = str.length();
        for (int i = 0; i < len; i++) {
            value[str.charAt(i)-'a']++;
        }
        return value;
    }
    private static boolean isValid(int[] value, int[] cur) {
        for (int i = 0; i < cur.length; i++) {
            if (cur[i] > value[i]) {
                return false;
            }
        }
        return true;
    }
}
