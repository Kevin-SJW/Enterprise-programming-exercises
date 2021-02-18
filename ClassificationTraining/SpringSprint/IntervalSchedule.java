package ClassificationTraining.SpringSprint;

import java.util.Arrays;

/**
 * @Classname IntervalSchedule
 * @Description TODO
 * @Date 2021/2/12 21:53
 * @Created by Administrator
 * 区间调度
 */
public class IntervalSchedule {
    public static void main(String[] args) {
        int[][] intvs={{1,3},{2,4},{3,6}};
        System.out.println(intervalSchedule(intvs));
    }
    public static int intervalSchedule(int[][] intvs){
        if(intvs.length==0){
            return 0;
        }
        //按end升序排序
        Arrays.sort(intvs, (o1, o2) -> o1[1]-o2[1]);
        //至少有一个区间不相交
        int count=1;
        //排序后，第一个区间就是x
        int x_end=intvs[0][1];
        for(int[] interval:intvs){
            int start=interval[0];
            if(start>=x_end){
                //找到下一个选择的区间了
                count++;
                x_end=interval[1];
            }
        }
        return count;
    }

    //无重叠区间
    public static int eraseOverlapInterval(int[][] intvs){
        int n=intvs.length;
        return n-intervalSchedule(intvs);
    }
}
