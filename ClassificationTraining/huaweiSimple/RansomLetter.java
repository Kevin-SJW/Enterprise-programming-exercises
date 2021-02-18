package ClassificationTraining.huaweiSimple;

/**
 * @Classname RansomLetter
 * @Description TODO
 * @Date 2020/10/3 19:14
 * @Created by Administrator
 */
public class RansomLetter {
    public static void main(String[] args) {
        String ransomNote = "aa", magazine = "aab";
        System.out.println(canConstruct(ransomNote, magazine));

    }

    public static boolean canConstruct(String ransomNote, String magazine) {
        int[] map = new int[26];
        for (int i = 0; i < magazine.length(); i++) {
            map[magazine.charAt(i) - 'a']++;
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            if (map[ransomNote.charAt(i) - 'a'] > 0) {
                map[ransomNote.charAt(i) - 'a']--;
            } else {
                return false;
            }
        }
        return true;
    }
}
