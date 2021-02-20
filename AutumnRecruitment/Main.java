package AutumnRecruitment;

/**
 * @Classname Main
 * @Description TODO
 * @Date 2019/9/29 21:11
 * @Created by 14241
 */

import java.util.*;

public class Main {
    private static int count;
    public static void Show(int q,char w,char e)
    {
        System.out.printf("Move disk %d from %c to %c\n",q, w,e);
    }
    public static void Move(int n,char a,char b,char c)
    {
        if(n==1){
//            Show(1,a,c);
        }

        else
        {
            Move(n-1,a,c,b);///将剩下的n-1个利用c盘从a盘移动到b盘；
            count++;
//            Show(n,a,c);
            Move(n-1,b,a,c);///同理；
            count++;
            //n--;
        }
    }

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int n=cin.nextInt();
        Move(n,'A','B','C');
        System.out.println(count+1);
    }
}

