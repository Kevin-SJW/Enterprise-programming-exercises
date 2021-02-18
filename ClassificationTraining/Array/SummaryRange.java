package ClassificationTraining.Array;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname SummaryRange
 * @Description TODO
 * @Date 2020/4/7 15:07
 * @Created by 14241
 * Given a sorted integer array without duplicates,
 * return the summary of its ranges.
 * 相邻的两个数字若差距为1，则继续向后读，直到不满足条件为止，
 * 则把起始到终点的结果表示出来。如此，直到读到数组的最后位置为止。
 */
public class SummaryRange {
    public static void main(String[] args) {
        int[] nums = {0, 1, 2, 4, 5, 7};
        summaryRanges(nums).forEach(t -> System.out.print(t + " "));

    }

    public static List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int front = nums[i];
            while (i < nums.length - 1 && nums[i + 1] - nums[i] == 1) {
                i++;

            }
            int end = nums[i];
            if (front == end) {
                result.add(front + "");
            } else {
                result.add(front + "->" + end);
            }
        }
        return result;
    }

    public static List<String> summaryRanges2(int[] nums) {
        List<String> res = new ArrayList<>();
        for (int i = 1; i < nums.length; i++) {
            int front = nums[i];
            while (i < nums.length && nums[i] - nums[i - 1] == 1) {
                i++;
            }
            int end = nums[i];
            if (front == end) {
                res.add(front + " ");
            } else {
                res.add(front + "->" + end);
            }
        }
        return res;
    }

}
