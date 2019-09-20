package AutumnRecruitment;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Classname PhoneNumber
 * @Description TODO
 * @Date 2019/9/20 20:23
 * @Created by 14241
 */
public class PhoneNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        List<String> result = new ArrayList<>();
        for (int i = 0; i < t; i++) {
            int len = sc.nextInt();
            sc.nextLine();
            String str = sc.nextLine();
            result.add(helper(len, str));
        }
        for (String str : result) {
            System.out.println(str);
        }
    }

    private static String helper(int len, String str) {
        if (len < 11) {
            return "NO";
        }
        if (str.indexOf('8') == -1) {
            return "NO";
        }
        if (str.charAt(0) == '8') {
            return "YES";
        }
        int count = 0;
        for (int i = 0; i < len; i++) {
            if (str.charAt(i) != '8') {
                count++;
            } else {
                break;
            }
        }
        if (len - count < 11) {
            return "NO";
        } else {
            return "YSE";
        }
    }
}
