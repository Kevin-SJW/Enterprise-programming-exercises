package ClassificationTraining.String;

/**
 * @Classname isSubSequence
 * @Description TODO
 * @Date 2020/8/1 9:19
 * @Created by Administrator
 */
public class isSubSequence {
    public static void main(String[] args) {
        String s = "abc", t = "ahbgdc";
        System.out.print(isSubsequence2(s, t));
    }

    public static boolean isSubsequence(String s, String t) {
        int index = -1;
        for (char c : s.toCharArray()) {
            index = t.indexOf(c, index + 1);
            if (index == -1) return false;
        }
        return true;
    }

    public static boolean isSubsequence2(String s, String t) {
        int index = -1;
        for (char c : s.toCharArray()) {
            index = t.indexOf(c, index + 1);
            if (index != -1) {
                return true;
            }
        }
        return false;
    }
}
