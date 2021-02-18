package ClassificationTraining.huaweiSimple;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @Classname ReverseWordsInAString
 * @Description TODO
 * @Date 2020/8/23 17:14
 * @Created by Administrator
 */
public class ReverseWordsInAString {
    public static void main(String[] args) {
        String s = "the sky is blue";
        System.out.println(reverseWords(s));

    }
    public static String reverseWords(String s) {
        s=s.trim();
        List<String> list= Arrays.asList(s.split("\\s+"));
        Collections.reverse(list);
        return String.join(" ",list);

    }
}
