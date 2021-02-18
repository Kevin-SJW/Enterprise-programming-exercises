package ClassificationTraining.huaweiMiddle;

import java.util.*;

/**
 * @Classname RandomIndex
 * @Description TODO
 * @Date 2020/12/29 0:07
 * @Created by Administrator
 */
public class RandomIndex {
    Map<Integer, List<Integer>> map;

    public RandomIndex(int[] nums) {
        map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                List<Integer> list = new ArrayList<Integer>();
                list.add(i);
                map.put(nums[i],list);
            } else {
                map.get(nums[i]).add(i);
            }
        }
    }

    public int pick(int target) {
        List<Integer> list;
        int res = 0;
        if (map.containsKey(target)) {
            list = map.get(target);
            Random random = new Random();
            if (list.size() != 0) {
                res = list.get(random.nextInt(list.size()));
            }

        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 3, 3};
        RandomIndex randomIndex = new RandomIndex(nums);
        //pick(3) 应该返回索引 2,3 或者 4。每个索引的返回概率应该相等。
        System.out.println(randomIndex.pick(3));
        // pick(1) 应该返回 0。因为只有nums[0]等于1。
        System.out.println(randomIndex.pick(1));
    }
}

