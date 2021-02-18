package ClassificationTraining.Array;

import java.util.HashSet;
import java.util.Set;

/**
 * @Classname LongestConsecutiveSequence
 * @Description TODO
 * @Date 2020/2/25 15:12
 * @Created by 14241
 * Given an unsorted array of integers,
 * find the length of the longest consecutive elements sequence.
 * <p>
 * Your algorithm should run in O(n) complexity.
 */
public class LongestConsecutiveSequence {
    public static void main(String[] args) {
        int[] nums = {100, 4, 200, 1, 3, 2};
        System.out.println(longestConsecutive(nums));
    }
    public static int longestConsecutive(int[] nums) {
        Set<Integer> num_set = new HashSet<>();
        for (int num : nums) {
            num_set.add(num);
        }
        int res = 0;
        for (int num : num_set) {
            if (!num_set.contains(num - 1)) {
                int currentNum = num;
                int cur = 1;

                while (num_set.contains(currentNum + 1)) {
                    currentNum += 1;
                    cur += 1;
                }
                res = Math.max(res, cur);
            }
        }
        return res;
    }
}
