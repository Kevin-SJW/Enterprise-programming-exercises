package AutumnRecruitment;

import java.util.Scanner;

/**
 * @Classname MinDigitSum
 * @Description TODO
 * @Date 2019/9/21 16:06
 * @Created by 14241
 */
public class MinDigitSum {

    public static void main(String[] arg){

        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }int m=0;
        for(int x:arr){
            System.out.println(x);
//                return m;


        }
    }

    public static int getDigitsSum(int n){
        int sum=0;
        if(n==0){
            return -1;
        }
        do{
            sum+=n%10;
            n=n/10;
        }while(n!=0);
        return sum;
    }
}
