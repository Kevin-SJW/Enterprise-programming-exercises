package ClassificationTraining.Array;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @Classname MergeIntervals
 * @Description TODO
 * @Date 2020/9/30 23:45
 * @Created by Administrator
 */
public class MergeIntervals {
    public static void main(String[] args) {

        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
//        Arrays.stream(merge(intervals)).forEach(t ->
//                Arrays.stream(t).forEach(p -> System.out.print(p + " ")));
        System.out.println(getIntervalLength(merge(intervals)));

    }

    private static int getIntervalLength(int[][] res) {

        int length = 0;
        for (int i = 0; i < res.length; i++) {
            length += res[i][1] - res[i][0];
        }
        return length;
    }

    public static int[][] merge(int[][] intervals) {

        if (intervals.length == 0) {
            return intervals;
        }
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        Deque<int[]> stack = new LinkedList<>();
        for (int[] i : intervals) {
            int[] j = stack.peek();

            if (stack.isEmpty() || i[0] > j[1]) {
                stack.push(i);

            } else {
                j[1] = Math.max(i[1], j[1]);
            }
        }

        int[][] res = new int[stack.size()][2];
        for (int i = stack.size() - 1; i >= 0; i--) {
            res[i] = stack.pop();
        }

        return res;
    }
}


