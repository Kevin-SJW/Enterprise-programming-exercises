package AutumnRecruitment;

import java.util.Scanner;

/**
 * @Classname MainClass
 * @Description TODO
 * @Date 2019/9/29 20:58
 * @Created by 14241
 */
public class MainClass {
    private static int count;

    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        int nDisks=sc.nextInt();

        doTowers(nDisks, 'A', 'B', 'C');

    }
    public static void doTowers(int topN, char from, char inter, char to) {

        if (topN == 1){
            System.out.println("Disk 1 from "
                    + from + " to " + to);
        }else {
            doTowers(topN - 1, from, to, inter);
            System.out.println("Disk "
                    + topN + " from " + from + " to " + to);
            count++;
            System.out.println(count);
            doTowers(topN - 1, inter, from, to);

        }
    }
}
