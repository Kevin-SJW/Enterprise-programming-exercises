package AutumnRecruitment;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Classname MinNotZero
 * @Description TODO
 * @Date 2019/9/20 20:46
 * @Created by 14241
 */
public class MinNotZero {

    private static List<Integer> arr;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int k = input.nextInt();
        input.nextLine();
        arr = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            int temp = input.nextInt();
            if (temp != 0) {
                arr.add(temp);
            }
        }
        for (int i = 0; i < k; i++) {
            System.out.println(helper());
        }
    }

    private static int helper() {
        if (arr.size() == 0) {
            return 0;
        }
        int min = Integer.MAX_VALUE;
        List<Integer> newList = new ArrayList<>(arr.size());
        for (int i : arr) {
            min = i < min ? i : min;
        }
        for (int i = 0; i < arr.size(); i++) {
            int temp = arr.get(i) - min;
            if (temp != 0) {
                newList.add(temp);
            }
        }

        arr = newList;
        return min;
    }

}
