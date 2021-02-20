package AutumnRecruitment;

import java.util.Scanner;

/**
 * @Classname Str
 * @Description TODO
 * @Date 2019/9/29 21:50
 * @Created by 14241
 */
public class Str {
    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        String str=sc.nextLine();
        int unicodeCount = 0;
        int szCount = 0;
        int zmCount = 0;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c >= '0' && c <= '9') {
                szCount++;
            }else if((c >= 'a' && c<='z') || (c >= 'A' && c<='Z')){
                zmCount++;
            }else{
                unicodeCount++;
            }
        }
        System.out.println("汉字："+unicodeCount+"字母："+zmCount+"数字："+szCount);

    }
}
