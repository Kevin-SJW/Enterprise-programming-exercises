package ClassificationTraining.huaweiSimple;

import java.util.*;

/**
 * @Classname ThirdMax
 * @Description TODO
 * @Date 2020/10/3 9:49
 * @Created by Administrator
 */
public class ThirdMax {
    public static void main(String[] args) {
        int[] nums = {3,2,2,1};
        System.out.println(thirdMax(nums));

    }

    public static int thirdMax(int[] nums) {
        Arrays.sort(nums);
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0;i < nums.length;i++){
            if(!list.contains(nums[i])){
                list.add(nums[i]);
            }
        }
        if(list.size() < 3){
            return list.get(list.size()-1);
        }
        return list.get(list.size()-3);

    }

    public static int thirdMax2(int[] nums){
        int k=3;
        if (nums.length < 3) {
            return nums[nums.length - 1];
        }
        //
        List<Integer> res = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        Queue<Integer> queue = new PriorityQueue<>((o1, o2) -> map.get(o1) - map.get(o2));
        for (Integer value : map.keySet()) {
            queue.offer(value);
        }
        Arrays.sort(nums);
        if(queue.size()<3){
            return nums[nums.length - 1];
        }

        for (int i = 0; i < k-1; i++) {

            queue.poll();
        }

        return queue.peek();
    }
}
