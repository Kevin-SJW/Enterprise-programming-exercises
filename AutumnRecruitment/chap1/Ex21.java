package AutumnRecruitment.chap1;

import java.util.Scanner;

/**
 * @Classname Ex21
 * @Description TODO
 * @Date 2019/9/21 11:26
 * @Created by 14241
 */
public class Ex21 {
    public static void main(String[] args) {
        System.out.print("Please input count:");
        Scanner sc=new Scanner(System.in);
        int n = sc.nextInt();
        String[] nameArray = new String[n];
        int[] integerArray1 = new int[n];
        int[] integerArray2 = new int[n];
        for (int i = 0; i < n; i++) {
            nameArray[i] = sc.nextLine();
            integerArray1[i] = sc.nextInt();
            integerArray2[i] = sc.nextInt();
        }
        System.out.println("庚----房----房----房------庖");
        for (int i = 0; i < n; i++) {
            System.out.printf("|%4s|%4d|%4d|%6.3f|\n", nameArray[i], integerArray1[i], integerArray2[i],
                    (float) integerArray1[i] / integerArray2[i]);
            if (i != n - 1) {
                System.out.println("念----拈----拈----拈------怕");
            }
        }
        System.out.println("弩----拂----拂----拂------彼");
    }
}
