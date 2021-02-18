package ClassificationTraining.SpringSprint;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 有 n 位用户参加活动，他们的 ID 从 0 到 n - 1，每位用户都 恰好 属于某一用户组。
 * 给你一个长度为 n 的数组 groupSizes，
 * 其中包含每位用户所处的用户组的大小，请你返回用户分组情况（存在的用户组以及每个组中用户的 ID）。
 * 你可以任何顺序返回解决方案，ID 的顺序也不受限制。此外，题目给出的数据保证至少存在一种解决方案。
 * 输入：groupSizes = [3,3,3,3,3,1,3]
 * 输出：[[5],[0,1,2],[3,4,6]]
 * 其他可能的解决方案有 [[2,1,6],[5],[0,4,3]] 和 [[5],[0,6,2],[4,3,1]]。
 */
public class GroupThePeople {
    public static void main(String[] args) {
        int[] groupSize = {3, 3, 3, 3, 3, 1, 3};
        System.out.println(groupThePeople(groupSize));
    }

    public static List<List<Integer>> groupThePeople(int[] groupSizes) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        List<List<Integer>> results = new ArrayList<>();
        for (int i = 0; i < groupSizes.length; i++) {
            if (!map.containsKey(groupSizes[i])) {
                map.put(groupSizes[i], new ArrayList<>());
            }
            // 将用户 id 放入对应的用户组
            List<Integer> subList = map.get(groupSizes[i]);
            subList.add(i);
            map.put(groupSizes[i], subList);
            // 当该用户组中的数量满了时，放入 result 集合，并清空 sub
            if (subList.size() == groupSizes[i]) {
                results.add(new ArrayList<>(subList));
                subList.clear();
            }
        }
        return results;
    }
}
