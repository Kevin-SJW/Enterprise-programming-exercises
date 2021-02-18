package ClassificationTraining.huaweiSimple;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。
 * 序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。
 * 输入：target = 9
 * 输出：[[2,3,4],[4,5]]
 * 连续正数序列
 */
public class FindContinuousSequence {
    public static void main(String[] args) {
        int target = 9;
        Arrays.stream(findContinuousSequence(target)).forEach(t -> Arrays.stream(t)
                .forEach(p -> System.out.print(p + " ")));
    }

    public static int[][] findContinuousSequence(int target) {
        int left = 1, right = 2;
        List<int[]> res = new ArrayList<>();
        int sum = left + right;
        while (left < right) {
            if (sum == target) {
                int[] temp = new int[right - left + 1];
                int index = 0;
                for (int i = left; i <= right; i++) {
                    temp[index++] = i;
                }
                res.add(temp);
                sum -= left;
                ++left;
            } else if (sum > target) {
                sum -= left;
                ++left;
            } else {
                ++right;
                sum += right;

            }
        }
        return res.toArray(new int[res.size()][]);
    }

    public static int[][] findContinuousSequence2(int target) {
        int left = 1, right = 2;
        List<int[]> res = new ArrayList<>();
        int sum = left + right;
        while (left < right) {
            if (sum == target) {
                int[] temp = new int[right - left + 1];
                int index = 0;
                for (int i = left; i <= right; i++) {
                    temp[index++] = i;
                }
                res.add(temp);
                sum -= left;
                ++left;
            } else if (sum < target) {
                sum -= left;
                ++left;
            } else {
                ++right;
                sum += right;
            }
        }
        return res.toArray(new int[res.size()][2]);

    }
}
