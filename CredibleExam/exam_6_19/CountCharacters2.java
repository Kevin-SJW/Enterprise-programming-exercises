package CredibleExam.exam_6_19;

/**
 * @Classname CountCharacters2
 * @Description TODO
 * @Date 2020/8/2 19:43
 * @Created by Administrator
 * 给定一个子串数组words和字符数组chars，求出可以被chars中字母组成的单词的数目，
 * 组成单词用到的字母不能多于chars数组中的字母
 */
public class CountCharacters2 {
    public static void main(String[] args) {
        String[] words = new String[]{"cat", "bt", "hat", "tree"};
        String chars = "atach";
//        Arrays.stream(getChars(chars)).forEach(t-> System.out.print(t+" "));
        System.out.println(countCharacters(words, chars));
    }

    public static int countCharacters(String[] words, String chars) {
        if (words == null || words.length == 0) {
            return 0;
        }
        if (chars == null || chars.length() == 0) {
            return 0;
        }
        int ans = 0;
        int[] value = getChars(chars);
        for (String word : words) {
            int[] cur = getChars(word);
            int len = word.length();
            for (int i = 0; i < len; i++) {
                if (isValid(value, cur)) {
                    ans += len;
                }
            }
        }
        return ans;
    }

    //string to int array
    public static int[] getChars(String str) {
        int[] value = new int[26];
        for (int i = 0; i < str.length(); i++) {
            value[str.charAt(i) - 'a']++;
        }
        return value;
    }

    public static boolean isValid(int[] value, int[] cur) {
        for (int i = 0; i < cur.length; i++) {
            if (value[i] < cur[i]) {
                return false;
            }
        }
        return true;
    }
}
