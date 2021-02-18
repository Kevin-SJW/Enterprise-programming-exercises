package ClassificationTraining.String;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @Classname ReverseWords
 * @Description TODO
 * @Date 2020/8/8 0:06
 * @Created by Administrator
 */
public class ReverseWords {
    public static void main(String[] args) {
        String words="i LOVE you";
        System.out.println(reverseWord(words));
    }

    public static String reverseWord(String s){
        s=s.trim();
        List<String> str= Arrays.asList(s.split("\\s+"));
        Collections.reverse(str);
//        System.out.println(str);
        return String.join(" ",str);
    }
}
