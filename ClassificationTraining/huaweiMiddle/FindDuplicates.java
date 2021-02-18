package ClassificationTraining.huaweiMiddle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Classname FindDuplicates
 * @Description TODO
 * @Date 2020/9/13 16:26
 * @Created by Administrator
 */
public class FindDuplicates {
    public static void main(String[] args) {
        int[] nums={4,3,2,7,8,2,3,1};
        findDuplicates(nums).stream().forEach(t-> System.out.print(t+" "));

    }

    public static List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 2) {
                res.add(entry.getKey());
            }
        }
        return res;
    }
}
