package CredibleExam.exam_11_22;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname WordStringReverse
 * @Description TODO
 * @Date 2020/7/11 22:02
 * @Created by Administrator
 *
 * yMemaNsImoT
 */
public class WordStringReverse {
    public static void main(String[] args) {
        String s = "MyNameIsTom";
        System.out.println(wordStringReverse(s));

    }

    public static String wordStringReverse(String s) {
        if (s == null || s.length() == 0) {
            return null;
        }
        List<String> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        int index = 0;
        for (int i = 1; i <s.length(); i++) {
            if (Character.isUpperCase(s.charAt(i))) {

                list.add(s.substring(index, i));
                index = i;
            }

        }
        list.add(s.substring(index));
        for (String str : list) {
            sb.append(new StringBuilder(str).reverse());

        }

        return sb.toString();
    }
}
