package ClassificationTraining.huaweiMiddle;

import java.util.Arrays;
import java.util.List;

/**
 * @Classname MinTimeDifference
 * @Description TODO
 * @Date 2020/9/19 23:30
 * @Created by Administrator
 * 输入: ["23:59","00:00"]
 * 输出: 1
 */
public class MinTimeDifference {
    public static void main(String[] args) {
        List<String> timePoints = Arrays.asList("23:59", "00:00");
        System.out.println(findMinDifference(timePoints));

    }

    public static int findMinDifference(List<String> timePoints) {
        int n = timePoints.size();
        int[] t = new int[n];
        for (String str : timePoints) {
            for (int i = 0; i < timePoints.size(); i++) {
                t[i] = (str.substring(0, 2).charAt(0) * 60 + str.substring(3, 5).charAt(0));
            }
        }
        Arrays.sort(t);
        int min = t[0] + 1440 - t[n - 1];
        for (int i = 1; i < n; i++) {
            min = Math.min(min, t[i] - t[i - 1]);
        }
        return min;
    }

    public static int findMinDifference2(List<String> timePoints) {
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


}

