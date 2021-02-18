package ClassificationTraining.huaweiSimple;

/**
 * @Classname CountCharacters
 * @Description TODO
 * @Date 2020/8/25 1:01
 * @Created by Administrator
 */
public class CountCharacters {
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
        int[] value = getChars(chars);
        for (String word : words) {
            int[] cur = getChars(word);
            int len = word.length();
            if (cmp(cur, value)) {
                ans += len;
            }
        }
        return ans;
    }

    //String 2 Integer array
    public static int[] getChars(String s) {
        int[] value = new int[26];
        for (int i = 0; i < s.length(); i++) {
            value[s.charAt(i) - 'a']++;

        }
        return value;
    }

    public static boolean cmp(int[] cur, int[] value) {
        for (int i = 0; i < cur.length; i++) {
            if (cur[i] > value[i]) {
                return false;
            }
        }
        return true;
    }
}
