package AutumnRecruitment.chap1_4;

import java.util.Scanner;

/**
 * @Classname ThreeSum
 * @Description TODO
 * @Date 2019/10/2 16:03
 * @Created by 14241
 */
public class ThreeSum {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int[] a=new int[10];
        for(int i=0;i<10;i++){
            a[i]=sc.nextInt();
        }

        System.out.println(count(a));

    }
    public static int count(int[] a){
        int N=a.length;
        int cnt=0;
        for(int i=0;i<N;i++){
            for(int j=i+1;j<N-1;j++){
                for(int k=j+1;j<N-2;j++){
                    if(a[i]+a[j]+a[k]==10){
                        cnt++;
                    }
                }
            }
        }
        return cnt;
    }
}
