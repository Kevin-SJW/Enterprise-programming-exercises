package AutumnRecruitment.chap2;

import java.util.Scanner;

/**
 * @Classname Ex07
 * @Description TODO
 * @Date 2019/9/28 18:35
 * @Created by 14241
 */
public class Ex07 {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        System.out.println(mystery(s));
    }

    public static String mystery(String s){
        int N=s.length();
        if(N<=1){
            return s;
        }
        String a=s.substring(0,N/2);
        String b=s.substring(N/2,N);
        assert a.equals(b) ?true:false;
        return mystery(b)+mystery(a);
    }
}
