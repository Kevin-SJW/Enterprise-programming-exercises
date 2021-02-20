package AutumnRecruitment;

import java.util.Scanner;

/**
 * @Classname DecodeProblem
 * @Description TODO
 * @Date 2019/9/8 19:42
 * @Created by 14241
 */
public class DecodeProblem {
    static int M = 1000000007;

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s= String.valueOf(sc.nextInt());
        System.out.println(numDecodings(s));
    }

    public static int numDecodings(String s) {
        Integer[] memo = new Integer[s.length()];
        return ways(s, s.length() - 1, memo);
    }

    public static int ways(String s, int i, Integer[] memo) {
        if (i < 0) {
            return 1;
        }
        if (memo[i] != null) {
            return memo[i];
        }
        if (s.charAt(i) == '*') {
            long res = 9 * ways(s, i - 1, memo);
            if (i > 0 && s.charAt(i - 1) == '1') {
                res = (res + 9 * ways(s, i - 2, memo)) % M;
            } else if (i > 0 && s.charAt(i - 1) == '2') {
                res = (res + 6 * ways(s, i - 2, memo)) % M;
            } else if (i > 0 && s.charAt(i - 1) == '*') {
                res = (res + 15 * ways(s, i - 2, memo)) % M;
            }
            memo[i] = (int) res;
            return memo[i];
        }
        long res = s.charAt(i) != '0' ? ways(s, i - 1, memo) : 0;
        if (i > 0 && s.charAt(i - 1) == '1') {
            res = (res + ways(s, i - 2, memo)) % M;
        } else if (i > 0 && s.charAt(i - 1) == '2' && s.charAt(i) <= '6') {
            res = (res + ways(s, i - 2, memo)) % M;
        } else if (i > 0 && s.charAt(i - 1) == '*') {
            res = (res + (s.charAt(i) <= '6' ? 2 : 1) * ways(s, i - 2, memo)) % M;
        }
        memo[i] = (int) res;
        return memo[i];
    }
}
