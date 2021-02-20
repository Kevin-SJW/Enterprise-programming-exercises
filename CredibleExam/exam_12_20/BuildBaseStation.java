package CredibleExam.exam_12_20;

import java.util.*;

/**
 * @Classname BuildBaseStation
 * @Description TODO
 * @Date 2020/7/15 23:44
 * @Created by Administrator
 * 返回num个距离基站（0,0）最小的点
 */
public class BuildBaseStation {
    public static void main(String[] args) {
        int[][] positions = {{3, 3}, {-2, 2}};
        int num = 1;

        int[][] res=numClosestPositions(positions,num);
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res[0].length; j++) {
                System.out.print(res[i][j] + " ");
            }
        }

    }

    public static int[][] numClosestPositions(int[][] positions, int num) {
//        Arrays.sort(positions,Comparator.comparingInt(o->o[0]*o[0]+o[1]*o[1]));
//        return Arrays.copyOf(positions,num);
        Queue<int[]> queue=new PriorityQueue<>(Comparator.comparingInt(o->o[0]*o[0]+o[1]*o[1]));
        for(int[] position:positions){
            queue.add(position);
        }
        int[][] ans=new int[num][];
        for(int i=0;i<ans.length;i++){
            ans[i++]=queue.poll();
        }
        return ans;
    }

}
