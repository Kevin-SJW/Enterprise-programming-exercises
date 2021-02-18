package ClassificationTraining.huaweiMiddle;

import java.util.*;

/**
 * @Classname maxEvents
 * @Description TODO
 * @Date 2021/1/23 21:23
 * @Created by Administrator
 * 给你一个数组 events，其中 events[i] = [startDayi, endDayi] ，
 * 表示会议 i 开始于 startDayi ，结束于 endDayi 。
 * 你可以在满足 startDayi <= d <= endDayi 中的任意一天 d 参加会议 i 。注意，一天只能参加一个会议。
 * 请你返回你可以参加的 最大 会议数目。
 * 然后我们将会议本身按照开始时间升序排序，目的是用于更新有效会议堆和有效与会日期。
 * 每到一天可以选择时首先将所有可选择会议(还没加入堆中)的结束时间加至堆中，
 * 选择最小的结束时间作为选定的会议，以此类推
 */
public class maxEvents {
    public static void main(String[] args) {
        int[][] events = {{1, 2}, {2, 3}, {3, 4}};
        System.out.println(maxEvents(events));
    }
    public static int maxEvents(int[][] events) {
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
        Arrays.sort(events, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return a[0] - b[0];
            }
        });
        int res = 0, index = 0, n = events.length;
        for (int d = 1; d < 10000; ++d) {
            while (index < n &&events[index][0] == d) {
                queue.offer(events[index++][1]);
            }
            while (queue.size() > 0 && queue.peek() < d) {
                queue.poll();
            }
            if (queue.size() > 0) {
                queue.poll();
                res++;
            }
        }
        return res;
    }

    public static int maxEvents3(int[][] events) {
        Arrays.sort(events, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] != o2[1]) {
                    return o1[1] - o2[1];
                } else {
                    return o1[0] = o2[0];
                }
            }
        });
        boolean[] vis = new boolean[100005];
        int res = 0;
        for (int[] item : events) {
            for (int i = item[0]; i <= item[1]; i++) {
                if (vis[i] == false) {
                    vis[i] = true;
                    res++;
                    break;
                }
            }
        }
        return res;

    }

    public static int maxEvents2(int[][] events) {
        Arrays.sort(events, (o1, o2) -> o1[1] - o2[1]);
        Set<Integer> set = new HashSet<>();
        for (int[] event : events) {
            int s = event[0];
            int e = event[1];
            for (int i = s; i <= e; i++) {
                if (!set.contains(i)) {
                    set.add(i);
                    break;
                }
            }
        }
        return set.size();

    }
}
