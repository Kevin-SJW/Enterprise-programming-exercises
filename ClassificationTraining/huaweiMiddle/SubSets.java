package ClassificationTraining.huaweiMiddle;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname SubSets
 * @Description TODO
 * @Date 2020/10/7 19:54
 * @Created by Administrator
 */
public class SubSets {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println(subsets(nums));

    }

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        res.add(new ArrayList<>());

        for (int i = 0; i < nums.length; i++) {
            int size = res.size();
            for (int j = 0; j < size; j++) {
                List<Integer> copyItem = new ArrayList<>(res.get(j));
                copyItem.add(nums[i]);
                res.add(copyItem);
            }
        }
        return res;
    }
}
