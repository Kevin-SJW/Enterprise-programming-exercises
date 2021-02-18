package ClassificationTraining.huaweiSimple;

/**
 * @Classname ReverseString
 * @Description TODO
 * @Date 2020/8/22 0:32
 * @Created by Administrator
 */
public class ReverseString {

    public static void reverseString(char[] s) {
        int left = 0, right = s.length - 1;
        while (left < right) {
            char tmp = s[left];
            s[left++] = s[right];
            s[right--] = tmp;

        }
    }
}
