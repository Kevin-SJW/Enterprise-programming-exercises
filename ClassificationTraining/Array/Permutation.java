package ClassificationTraining.Array;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname Permutation
 * @Description TODO
 * @Date 2020/8/9 15:20
 * @Created by Administrator
 * quan
 */
public class Permutation {
    public static List<List<Integer>> result = null;

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println(permute(nums));
    }

    public static List<List<Integer>> permute(int[] nums) {
        if (nums == null || nums.length == 0) {
            return result;
        }
        result = new ArrayList<>();
        dfs(nums, 0, new ArrayList<>());
        return result;

    }

    public static void dfs(int[] nums, int start, List<Integer> list) {
        if (start == nums.length) {
            result.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!list.contains(nums[i])) {
                list.add(nums[i]);
                dfs(nums, start + 1, list);
                list.remove(list.size() - 1);
            }
        }
    }

    public static List<List<Integer>> permute2(int[] nums) {
        if (nums.length == 0) {
            return result;
        }
        result = new ArrayList<>();
        dfs2(nums, 0, new ArrayList<>());
        return result;

    }

    public static void dfs2(int[] nums, int start, List<Integer> list) {
        if (start == nums.length) {
            result.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!list.contains(nums[i])) {
                list.add(nums[i]);
                dfs2(nums, start + 1, list);
                list.remove(list.size() - 1);
            }
        }
    }
}
