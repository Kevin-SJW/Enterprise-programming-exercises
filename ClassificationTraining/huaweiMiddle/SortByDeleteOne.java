package ClassificationTraining.huaweiMiddle;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 给定一个正整数数组，请按以下方式处理，使得数组有序（递增或递减）数组已经是有序的，则不作处理
 * 并返回数组中的最小值，如果数组不是有序的，且删除一个元素，使得剩余数组有序，返回需要删除的元素值，
 * 如果存在多个解，则选择删除元素值最小的，若误解，返回-1；
 */
public class SortByDeleteOne {
    public static void main(String[] args) {
        int[] nums = {1, 2,3,7,4};
        System.out.println(sortByDeleteOne(nums));
    }
    private static int sortByDeleteOne(int[] nums) {
        List<Integer> list = new ArrayList<>();
        if (isIncrease(nums) || isReduce(nums)) {
            return Math.min(nums[0], nums[nums.length - 1]);
        }
        for (int i = 0; i < nums.length; i++) {
            List<Integer> resList = new ArrayList<>();
            for (int j = 0; j < nums.length; j++) {
                resList.add(nums[j]);
            }
            resList.remove(i);
            int[] arr = resList.stream().mapToInt(Integer::valueOf).toArray();
            if (isIncrease(arr) || isReduce(arr)) {
                list.add(nums[i]); }
        }
        Collections.sort(list);
        return list.isEmpty() ? -1 : list.get(0);
    }
    private static boolean isIncrease(int[] nums) {
        boolean flag = true;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i + 1] < nums[i]) {
                return false;
            }
        }
        return flag;
    }
    private static boolean isReduce(int[] nums) {
        boolean flag = true;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i + 1] > nums[i]) {
                return false; } }
        return flag;
    }
}
