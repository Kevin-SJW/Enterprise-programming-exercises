package CredibleExam.exam_7_24;

import java.util.Arrays;

/**
 * @Classname Watering
 * @Description TODO
 * @Date 2020/8/1 15:58
 * @Created by Administrator
 * 数组water表示一排水的水位高度，往瓶子内浇水，1次操作可以使得1个瓶子的水位+1
 * 给定一个整数cnt，表示小明想通过浇水获得cnt个水位一致的瓶子，求最少需要浇水多少次？
 */
public class Watering {
    public static void main(String[] args) {
        int[] nums = {7, 1, 9, 10};
        int k = 3;
        System.out.println(watering(nums, k));

    }

    public static int watering(int[] water, int num) {
        if (water.length == 0 || water.length < num) {
            return 0;
        }
        Arrays.sort(water);
        long[] preSum = new long[water.length + 1];
        preSum[0] = 0;
        for (int k = 0; k < water.length; k++) {
            preSum[k + 1] = preSum[k] + water[k];

        }
        long res = Integer.MAX_VALUE;
        for (int i = water.length - 1; i >= num; i--) {
            long sumAll = (long) num * (long) water[i];
            long cur = sumAll - (preSum[i + 1] - preSum[i + 1 - num]);
            res = Math.min(res,cur);
            if (res == 0) {
                break;
            }
        }
        return (int) (res % 1000000007);


    }

}
