package ClassificationTraining.huaweiSimple;

/**
 * @Classname LengthOfLastWord
 * @Description TODO
 * @Date 2020/8/23 16:36
 * @Created by Administrator
 */
public class LengthOfLastWord {
    public int lengthOfLastWord(String s) {
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
