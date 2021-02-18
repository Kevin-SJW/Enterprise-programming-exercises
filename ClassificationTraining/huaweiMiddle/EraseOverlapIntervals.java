package ClassificationTraining.huaweiMiddle;

import java.util.*;

/**
 * @Classname EraseOverlapIntervals
 * @Description TODO
 * @Date 2020/12/29 22:37
 * @Created by Administrator
 * 给定一个区间的集合，找到需要移除区间的最小数量，使剩余区间互不重叠。
 * 可以认为区间的终点总是大于它的起点。
 * 区间 [1,2] 和 [2,3] 的边界相互“接触”，但没有相互重叠。
 * 输入: [ [1,2], [2,3], [3,4], [1,3] ]
 * 输出: 1
 * 解释: 移除 [1,3] 后，剩下的区间没有重叠。
 * 使用贪心求出最大不重叠区间，然后用总区间数减去它。
 * 将区间以右端点从小到大排序，然后选取不重叠的区间即可。
 * 为什么贪心是正确的？
 * 简单的说就是优先选择越早结束的区间，会留下更多空间选择其他区间。
 *
 */
public class EraseOverlapIntervals {
    public static void main(String[] args) {
        int[][] intervals = {{1, 2}, {2, 3}, {3, 4}, {1, 3}};
        System.out.println(eraseOverlapIntervals(intervals));
    }

    public static int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0) {
            return 0;
        }
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[1]));

        int end = Integer.MIN_VALUE;
        int count = 0;
        for (int i = 0; i < intervals.length; i++) {
            if (end <= intervals[i][0]) {
                end = intervals[i][1];
                count++;
            }
        }
        return intervals.length - count;
    }
}
