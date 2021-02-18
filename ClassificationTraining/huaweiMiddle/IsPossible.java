package ClassificationTraining.huaweiMiddle;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @Classname IsPossible
 * @Description TODO
 * @Date 2020/12/2 0:25
 * @Created by Administrator
 * 给你一个按升序排序的整数数组 num（可能包含重复数字），请你将它们分割成一个或多个子序列，
 * 其中每个子序列都由连续整数组成且长度至少为 3 。
 * 如果可以完成上述分割，则返回 true ；否则，返回 false 。
 * 输入: [1,2,3,3,4,5]
 * 输出: True
 * 解释:
 * 你可以分割出这样两个连续子序列 :
 * 1, 2, 3
 * 3, 4, 5
 */
public class IsPossible {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 3, 4, 5};
        System.out.println(isPossible(nums));
    }

    public static boolean isPossible(int[] nums) {
        Map<Integer, PriorityQueue<Integer>> map = new HashMap<>();
        for (int num : nums) {
            PriorityQueue<Integer> queue = map.get(num - 1);
            int value;
            if (queue == null || queue.isEmpty()) {
                value = 1;
            } else {
                value = queue.poll() + 1;
            }
            if (!map.containsKey(num)) {
                map.put(num, new PriorityQueue<>());
            }
            map.get(num).add(value);
        }
        return map.values().stream().flatMap(Collection::stream).noneMatch(i -> i < 3);
    }

    public static boolean isPossible2(int[] nums) {
        Map<Integer, PriorityQueue<Integer>> map = new HashMap<>();
        for (int num : nums) {
            PriorityQueue<Integer> queue = map.get(num - 1);
            int value;
            if (queue == null || queue.isEmpty()) {
                value = 1;
            } else {
                value = queue.poll() + 1;
            }
            if (!map.containsKey(num)) {
                map.put(num, new PriorityQueue<>());
            }
            map.get(num).add(value);
        }
        return map.values().stream().flatMap(Collection::stream).noneMatch(i -> i < 3);
    }
}
