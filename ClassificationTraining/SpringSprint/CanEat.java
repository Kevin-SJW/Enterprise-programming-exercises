package ClassificationTraining.SpringSprint;

import java.util.Arrays;

/**
 * 给你一个下标从 0 开始的正整数数组 candiesCount ，其中 candiesCount[i] 表示你拥有的第 i 类糖果的数目。
 * 同时给你一个二维数组 queries ，其中 queries[i] = [favoriteTypei, favoriteDayi, dailyCapi] 。
 * 你按照如下规则进行一场游戏：你从第 0 天开始吃糖果。你在吃完 所有 第 i - 1 类糖果之前，不能 吃任何一颗第 i 类糖果。
 * 在吃完所有糖果之前，你必须每天 至少 吃 一颗 糖果。
 * 请你构建一个布尔型数组 answer ，
 * 满足 answer.length == queries.length 。
 * answer[i] 为 true 的条件是：在每天吃 不超过 dailyCapi 颗糖果的前提下，
 * 你可以在第 favoriteDayi 天吃到第 favoriteTypei 类糖果；否则 answer[i] 为 false 。
 * 注意，只要满足上面 3 条规则中的第二条规则，你就可以在同一天吃不同类型的糖果。请你返回得到的数组 answer 。
 */
public class CanEat {
    public static void main(String[] args) {
        int[] candiesCount = {7, 4, 5, 3, 8};
        int[][] queries = {{0, 2, 2}, {4, 2, 4}, {2, 13, 1000000000}};
        System.out.println(Arrays.toString(canEat(candiesCount, queries)));

    }

    public static boolean[] canEat(int[] candiesCount, int[][] queries) {
        boolean[] res = new boolean[queries.length];
        int n = candiesCount.length;
        long[] preSum = new long[n + 1];
        for (int i = 0; i < n; i++) {
            preSum[i + 1] = preSum[i] + candiesCount[i];
        }
        for (int i = 0; i < queries.length; i++) {
            int type = queries[i][0];
            long day = queries[i][1];
            long cap = queries[i][2];
            long min = day + 1;
            long max = min * cap;
            if (max > preSum[type] && min <= preSum[type + 1]) {
                res[i] = true;
            }
        }
        return res;
    }
}
