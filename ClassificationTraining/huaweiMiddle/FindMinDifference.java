package ClassificationTraining.huaweiMiddle;

import java.util.Arrays;
import java.util.List;

/**
 * @Classname FindMinDifference
 * @Description TODO
 * @Date 2020/10/8 15:11
 * @Created by Administrator
 * 给定一个 24 小时制（小时:分钟）的时间列表，找出列表中任意两个时间的最小时间差并以分钟数表示。
 */
public class FindMinDifference {
    public static void main(String[] args) {
        List<String> timePoints = Arrays.asList("23:59", "00:00");
        System.out.println(findMinDifference2(timePoints));

    }

    public static int findMinDifference(List<String> timePoints) {
        int n = timePoints.size();
        int[] t = new int[n];
        for (int i = 0; i < timePoints.size(); i++) {
            t[i] = (timePoints.get(i).charAt(0) - '0') * 600
                    + (timePoints.get(i).charAt(1) - '0') * 60
                    + (timePoints.get(i).charAt(3) - '0') * 10
                    + (timePoints.get(i).charAt(4) - '0');
        }
        Arrays.sort(t);
        int res = t[0] + 1440 - t[n - 1];
        for (int i = 1; i < n; i++) {
            res = Math.min(res, t[i] - t[i - 1]);
        }

        return res;
    }

    public static int findMinDifference2(List<String> timePoints) {
        int n = timePoints.size();
        int[] t = new int[n];
        for (int i = 0; i < n; i++) {
            t[i] = (timePoints.get(i).charAt(0) - '0') * 600 +
                    (timePoints.get(i).charAt(1) - '0') * 60 +
                    (timePoints.get(i).charAt(3) - '0') * 10 +
                    (timePoints.get(i).charAt(4) - '0');
        }
        Arrays.sort(t);
        int res = t[0] + 1440 - t[n-1];
        for (int i = 1; i < n; i++) {
            res = Math.min(res, t[i] - t[i - 1]);
        }
        return res;
    }
}
