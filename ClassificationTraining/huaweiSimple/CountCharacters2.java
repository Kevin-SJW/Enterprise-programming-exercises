package ClassificationTraining.huaweiSimple;

/**
 * @Classname CountCharacters2
 * @Description TODO
 * @Date 2020/10/7 20:28
 * @Created by Administrator
 */
public class CountCharacters2 {
    public static void main(String[] args) {
        String[] words = {"cat", "bt", "hat", "tree"};
        String chars = "atach";
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
        char[] value = getChars(chars);
        for (String word : words) {
            char[] cur = getChars(word);
            int len = word.length();
            if (cmp(cur, value)) {
                ans += len;
            }
        }
        return ans;

    }

    //string 2 array
    public static char[] getChars(String s) {
        char[] value = new char[26];
        for (int i = 0; i < s.length(); i++) {
            value[s.charAt(i) - 'a']++;

        }
        return value;
    }

    public static boolean cmp(char[] cur, char[] values) {
        for (int i = 0; i < cur.length; i++) {
            if (cur[i] > values[i]) {
                return false;
            }
        }
        return true;
    }
}
