package AutumnRecruitment;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


/**
 * @Classname TencentMain4
 * @Description TODO
 * @Date 2019/8/17 20:26
 * @Created by 14241
 *
 * Tencent main4
 * 数楼房
 * <p>
 * 6
 * 5 3 8 3 2 5
 * <p>
 * 3 3 5 4 4 4
 */
public class CountHouse {

    public static void main(String[] args) {
        int n;
        List<Integer> hourse = new ArrayList();
        List<Integer> result = new ArrayList<Integer>();
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        for (int i = 0; i < n; i++) {
            hourse.add(in.nextInt());
        }

        for (int i = 0; i < n; i++) {
            result.add(calcute_1(i, hourse) + calcute_2(i, hourse) + 1);
        }
        System.out.println(result.toString().substring(1, result.toString().length() - 1).replaceAll(",", ""));
    }

    private static int calcute_1(int index, List<Integer> hourse) {
        int nums = 0;
        int flag = 0;
        for (int i = index - 1; i >= 0; i--) {
            if (hourse.get(i) > flag) {
                nums++;
                flag = hourse.get(i);
            }
        }
        return nums;
    }

    private static int calcute_2(int index, List<Integer> hourse) {
        int nums = 0;
        int flag = 0;
        for (int i = index + 1; i < hourse.size(); i++) {
            if (hourse.get(i) > flag) {
                nums++;
                flag = hourse.get(i);
            }
        }
        return nums;
    }


}
