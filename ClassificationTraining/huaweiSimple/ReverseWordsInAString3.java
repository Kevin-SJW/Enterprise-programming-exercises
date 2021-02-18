package ClassificationTraining.huaweiSimple;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Classname ReverseWordsInAString3
 * @Description TODO
 * @Date 2020/8/23 17:29
 * @Created by Administrator
 * Input: "Let's take LeetCode contest"
 * Output: "s'teL ekat edoCteeL tsetnoc"
 */
public class ReverseWordsInAString3 {
    public static void main(String[] args) {
        String s="Let's take LeetCode contest";
        System.out.println(reverseWords(s));
    }
    public static String reverseWords(String s) {
        s=s.trim();
        List<String> wordList= Arrays.asList(s.split("\\s+"));
        List<String> list=new ArrayList<>();
        for(String word:wordList){
            list.add(reverseWord(word));
        }
        return String.join(" ",list);

    }

    public static String reverseWord(String s){
        StringBuilder sb=new StringBuilder();
        for(int i=s.length()-1;i>=0;i--){
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }
}
