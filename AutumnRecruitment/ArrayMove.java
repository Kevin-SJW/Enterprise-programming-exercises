package AutumnRecruitment;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Classname ArrayMove
 * @Description TODO
 * @Date 2019/9/11 20:02
 * @Created by 14241
 * <p>
 * 给定一个数列，每一次移动可以将数列某个数移动到某个位置上，移动多次后，形成新的数列。
 * 定义数列中相邻两两之间的差的绝对值为“移动距离”，定义所有移动距离的总和为“总移动距离”。
 * 希望计算出最少的移动次数，使得新数列的“总移动距离”最小。 例如原数列为[4,2,7,6]，
 * 总移动距离为2+5+1=8。将6移动到7之前，会变成[4,2,6,7]，总移动距离变成2+4+1=7。
 * <p>
 * 需要编写一个函数，输入为一个int数组表示数列内容，输出为一个int数字，表示最小移动次数
 * <p>
 * 输入
 * 第一行输入为数组大小，然后依次输入数组元素，如数组[4, 2, 7, 6]
 * <p>
 * 输出
 * 总移动距离最小的数列之一为[2,4,6,7]
 * <p>
 * 最少移动次数：2
 * <p>
 * <p>
 * 样例输入
 * 4
 * 4
 * 2
 * 7
 * 6
 * 样例输出
 * 2
 */
public class ArrayMove {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int[] arr = new int[num];
        for (int i = 0; i < num; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(solution(arr));
    }

    public static int solution(int[] arr) {
        int chg = 0;
        for (int i = 0; i < arr.length-1; i++) {
            for (int j = 0; j < arr.length-1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    chg++;
                    int t = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = t;

                }
            }
        }
        return chg;

    }
}