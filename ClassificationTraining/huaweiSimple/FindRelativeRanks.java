package ClassificationTraining.huaweiSimple;

import java.util.*;

/**
 * @Classname FindRelativeRanks
 * @Description TODO
 * @Date 2020/10/17 17:24
 * @Created by Administrator
 */
public class FindRelativeRanks {
    public static void main(String[] args) {
        int[] nums = {5, 4, 3, 2, 1};
        int[] nums2 = {10, 3, 8, 9, 4};
        Arrays.stream(findRelativeRanks(nums2)).forEach(t -> System.out.print(t + " "));
    }

    public static String[] findRelativeRanks(int[] nums) {
        int[] copy = nums.clone();
        Arrays.sort(copy);
        int index = 0;
        int[] temp = new int[copy.length];
        for (int i = copy.length - 1; i >= 0; i--) {
            temp[index++] = copy[i];
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < temp.length; i++) {
            map.put(temp[i], i + 1);
        }
        String[] res = new String[temp.length];
        for (int i = 0; i < nums.length; i++) {
            int order = map.get(nums[i]);
            String s;
            if (order == 1) {
                s = "Gold Medal";
            } else if (order == 2) {
                s = "Silver Medal";
            } else if (order == 3) {
                s = "Bronze Medal";
            } else {
                s = String.valueOf(order);
            }
            res[i] = s;
        }
        return res;
    }
}
