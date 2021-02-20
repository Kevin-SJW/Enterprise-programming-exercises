package AutumnRecruitment.chap1_4;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Classname test
 * @Description TODO
 * @Date 2019/10/2 16:31
 * @Created by 14241
 */
public class test {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int[] a=new int[10];
        for(int i=0;i<10;i++){
            a[i]=sc.nextInt();
        }
//        System.out.println(a.toString());
        Arrays.stream(a).forEach(item-> System.out.print(item+" "));
    }
}
