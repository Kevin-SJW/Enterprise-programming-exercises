package ClassificationTraining.SpringSprint;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Classname FindMinArrowShots
 * @Description TODO
 * @Date 2021/2/12 21:57
 * @Created by Administrator
 */
public class FindMinArrowShots {
    public static void main(String[] args) {
        int[][] intvs={{1,3},{2,4},{3,6}};
        System.out.println(findMinArrowShots(intvs));
    }
    public static int findMinArrowShots(int[][] intvs) {
        if (intvs.length == 0) {
            return 0;
        }
        //按end升序排序
        Arrays.sort(intvs, Comparator.comparingInt(o -> o[1]));
        //至少有一个区间不相交
        int count = 1;
        //排序后，第一个区间就是x
        int x_end = intvs[0][1];
        for (int[] interval : intvs) {
            int start = interval[0];
            //箭头如果碰到气球边界也会爆炸
            if (start > x_end) {
                //找到下一个选择的区间了
                count++;
                x_end = interval[1];
            }
        }
        return count;
    }
}
