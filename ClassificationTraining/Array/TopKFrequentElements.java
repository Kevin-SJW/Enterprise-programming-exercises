package ClassificationTraining.Array;


import java.util.*;

/**
 * @Classname TopKFrequentElements
 * @Description TODO
 * @Date 2020/7/26 15:02
 * @Created by Administrator
 */
public class TopKFrequentElements {
    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 2, 3};
        int k = 2;
        Arrays.toString(topKFrequent(nums, k));

    }

    public static int[] topKFrequent(int[] nums, int k) {
        if (nums.length == 1) return nums;
        if (nums.length == 0) return null;
        //
        List<Integer> res = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        Queue<Integer> queue = new PriorityQueue<>((o1, o2) -> map.get(o2) - map.get(o1));
        for (Integer value : map.keySet()) {
            queue.offer(value);
        }

        for (int i = 0; i < k; i++) {

            res.add(queue.poll());
        }

        return res.stream().mapToInt(Integer::valueOf).toArray();


    }
}
