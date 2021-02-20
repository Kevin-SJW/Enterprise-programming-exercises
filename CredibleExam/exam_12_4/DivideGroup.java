package CredibleExam.exam_12_4;

import java.util.Arrays;

/**
 * @Classname DivideGroup
 * @Description TODO
 * @Date 2020/12/27 16:44
 * @Created by Administrator
 * 按升序排序后，mutexPosition的内容变为[[0,1],[3,5]],进入for循环前，
 * right=mutexPosition[0][1]=1;
 * 当i=1时，找到第一个分割点，right=mutexPosition[i][1]=5,即下一个分割点。
 * 任务列表tasks中有N个任务，任务编号Ni的值范围为[0,N-1].
 * 由于存在资源竞争，某些任务间存在两两互斥关系，并记录在二维数组mutexPairs中，该二维数组元素为[Ni,Nj],
 * 其中Ni，Nj，为互斥的两个任务编号。
 * 现在需要对任务列表tasks进行切割分组，要求：
 * 存在互斥关系的任务不能分在同一组
 * 单个任务也可以单独一组
 * 一个任务可能和多个任务互斥
 * 请判断 最少可将任务列表tasks切割成几组？（切割后的小组是原列表的连续子数组）
 * 输入:tasks=[1,4,2,3,0],mutexPairs=[]
 * 输出：1
 * 解释：无互斥关系，所有任务可分在同一组
 */
public class DivideGroup {
    public static void main(String[] args) {
        int[] tasks = {1, 4, 2, 3, 0};
        int[][] mutexPairs = {};
        System.out.println(divideGroup(tasks, mutexPairs));
    }

    public static int divideGroup(int[] tasks, int[][] mutexPairs) {
        if (mutexPairs.length == 0) {
            return 1;
        }
        if (mutexPairs.length == 0) {
            return 2;
        }
        //保存每个编号为i的任务在数组的位置
        int[] position = new int[tasks.length];
        for (int i = 0; i < tasks.length; i++) {
            position[tasks[i]] = i;
        }
        //找到mutexPair数组中的任务的位置
        //对于任务3,1,2,4,0 互斥(1,3)转化为（1,0），同时转成（0,1）;
        int[][] mutexPosition = new int[mutexPairs.length][2];
        for (int i = 0; i < mutexPairs.length; i++) {
            mutexPairs[i][0] = position[mutexPairs[i][0]];
            mutexPairs[i][1] = position[mutexPairs[i][1]];
            if (mutexPosition[i][0] > mutexPosition[i][1]) {
                int temp = mutexPosition[i][1];
                mutexPosition[i][1] = mutexPosition[i][0];
                mutexPosition[i][0] = temp;
            }
        }
        Arrays.sort(mutexPairs, (m1, m2) -> {
            if (m1[0] == m2[0]) {
                return m1[1] - m2[1];
            }
            return m1[1] - m2[1];
        });
        int div = 0;
        int right = mutexPosition[0][1];
        for (int i = 1; i < mutexPosition.length; i++) {
            if (mutexPosition[i][0] < right) {
                if (mutexPosition[i][1] < right) {
                    right = mutexPosition[i][1];
                }
            } else {
                div++;
                right = mutexPosition[i][1];
            }
        }
        return div + 2;

    }
}
