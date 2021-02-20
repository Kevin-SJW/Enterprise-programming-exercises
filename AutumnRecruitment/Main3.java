package AutumnRecruitment;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Classname Main3
 * @Description TODO
 * @Date 2019/9/29 21:57
 * @Created by 14241
 */
public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        //可以替换大部分空白字符，不限于空格
        String content = line.replaceAll("\\s", "");
        //汉字数量
        int hzCount = 0;
        //数字数量
        int szCount = 0;
        //字母数量
        int zmCount = 0;
        //标点符号数量
        int fhCount = 0;

        for (int i = 0; i < content.length(); i++) {
            char c = content.charAt(i);
            if (c >= '0' && c <= '9') {
                szCount++;

            } else if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')) {
                zmCount++;

            } else if (Character.toString(c).matches("[\\u4E00-\\u9FA5]+")) {
                hzCount++;

            } else {
                fhCount++;

            }


        }
        System.out.println("汉字：" + hzCount + ",字母：" + zmCount + "，数字" + szCount + "，其他：" + fhCount);

    }
}
