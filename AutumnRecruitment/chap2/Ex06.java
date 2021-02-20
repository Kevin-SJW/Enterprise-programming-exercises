package AutumnRecruitment.chap2;

import java.util.Scanner;

/**
 * @Classname Ex06
 * @Description 基因测序
 * @Date 2019/9/28 18:26
 * @Created by 14241
 */
public class Ex06 {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("s:");
        String s=sc.nextLine();
        System.out.println("t:");
        String t=sc.nextLine();
        if((s.length()==t.length())&&(s.concat(s).indexOf(t)>=0)){
            System.out.println("cicular rotation");
        }else{
            System.out.println("not cicular rotation");
        }

    }
}
