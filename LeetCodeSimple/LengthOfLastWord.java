package LeetCodeSimple;

/**
 * @Classname LengthOfLastWord
 * @Description TODO
 * @Date 2020/6/26 16:04
 * @Created by Administrator
 * Input: "Hello World"
 * Output: 5
 */
public class LengthOfLastWord {
    public static void main(String[] args) {
        String s = "Hello World";
        System.out.println(lengthOfLastWord(s));

    }

    public static int lengthOfLastWord(String s) {
        int count = 0;
        int i = s.length() - 1;
        while (i >= 0 && s.charAt(i) == ' ') {
            i--;
        }
        while (i >= 0 && s.charAt(i) != ' ') {
            count++;
            i--;
        }
        return count;

    }


}
