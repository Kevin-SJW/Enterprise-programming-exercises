package ClassificationTraining.huaweiMiddle;

import java.util.Arrays;

/**
 * @Classname TaskSchedule
 * @Description TODO
 * @Date 2020/8/27 0:52
 * @Created by Administrator
 */
public class TaskSchedule {
    public static void main(String[] args) {
        char[] task = {'A', 'A', 'A', 'B', 'B', 'B'};
        int n = 2;
        System.out.println(leastInterval(task, n));
    }

    public static int leastInterval(char[] tasks, int n) {
        if (tasks.length < 1 || n < 1) {
            return tasks.length;
        }
        int[] counts = new int[26];
        for (int i = 0; i < tasks.length; i++) {
            counts[tasks[i] - 'A']++;
        }

        Arrays.sort(counts);
        int maxCount = counts[25];
        int retCount = (maxCount - 1) * (n + 1) + 1;
        int i = 24;
        while (i >= 0 && counts[i] == maxCount) {
            retCount++;
            i--;
        }
        return Math.max(retCount, tasks.length);

    }
}
