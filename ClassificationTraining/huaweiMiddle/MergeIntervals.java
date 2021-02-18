package ClassificationTraining.huaweiMiddle;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @Classname MergeIntervals
 * @Description TODO
 * @Date 2020/9/4 23:03
 * @Created by Administrator
 * Given a collection of intervals, merge all overlapping intervals.
 * 合并区间
 */
public class MergeIntervals {
    public static void main(String[] args) {
        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        Arrays.stream(merge(intervals)).forEach(t -> Arrays.stream(t)
                .forEach(p -> System.out.print(p + " ")));
    }

    public static int[][] merge(int[][] intervals) {

        if (intervals.length == 0) {
            return new int[0][2];
        }
        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        Deque<int[]> stack = new LinkedList<>();
        for (int[] i : intervals) {
            int[] j = stack.peek();
            if (stack.isEmpty() || i[0] > j[1]) {
                stack.push(i);
            } else {
                j[1] = Math.max(j[1], i[1]);
            }
        }
        int[][] res = new int[stack.size()][2];
        for (int i = res.length - 1; i >= 0; i--) {
            res[i] = stack.pop();
        }
        return res;

    }
}
