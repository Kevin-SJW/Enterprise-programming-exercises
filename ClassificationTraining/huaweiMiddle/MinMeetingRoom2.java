package ClassificationTraining.huaweiMiddle;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @Classname MinMeetingRoom2
 * @Description TODO
 * @Date 2020/10/25 10:56
 * @Created by Administrator
 * 给定一个会议时间安排的数组，每个会议时间都会包括开始和结束的时间
 * [[s1,e1],[s2,e2],...] (si < ei)，为避免会议冲突，同时要考虑充分利用会议室资源，
 * 请你计算至少需要多少间会议室，才能满足这些会议安排。
 * 输入: [[0, 30],[5, 10],[15, 20]]
 * 输出: 2
 */
public class MinMeetingRoom2 {
    public static void main(String[] args) {
        int[][] intervals = {{0, 30}, {5, 10}, {15, 20}};
        System.out.println(minMeetingRooms2(intervals));
    }

    public static int minMeetingRooms2(int[][] intervals) {
        Arrays.sort(intervals, (o1, o2) -> {
            if (o1[0] != o2[0]) {
                return o1[0] - o2[0];
            } else {
                return o1[1] - o2[1];
            }
        });
        int cnt = 0;
        Queue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < intervals.length; i++) {
            if (queue.isEmpty() || intervals[i][0] < queue.peek()) {
                cnt++;
                queue.offer(intervals[i][1]);
            } else {
                queue.poll();
                queue.offer(intervals[i][1]);
            }
        }
        return cnt;
    }
}
