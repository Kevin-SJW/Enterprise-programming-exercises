package ClassificationTraining.huaweiMiddle;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Classname MinMeetingRoom
 * @Description TODO
 * @Date 2020/10/25 23:10
 * @Created by Administrator
 */
public class MinMeetingRoom {
    public static void main(String[] args) {
        int[][] intervals = {{0, 30}, {5, 10}, {15, 20}};
        System.out.println(canAttendMeetings(intervals));
    }

    public static boolean canAttendMeetings(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        for (int i = 0; i < intervals.length - 1; i++) {
            if (intervals[i][1] > intervals[i + 1][0]) {
                return false;

            }
        }
        return true;
    }
}
