package ClassificationTraining.huaweiMiddle;


import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @Classname FirstUnique
 * @Description TODO
 * @Date 2020/10/5 20:34
 * @Created by Administrator
 * 给定一系列整数，插入一个队列中，找出队列中第一个唯一整数。
 * 实现 FirstUnique 类：
 * FirstUnique(int[] nums) 用数组里的数字初始化队列。
 * int showFirstUnique() 返回队列中的 第一个唯一 整数的值。如果没有唯一整数，
 * 返回 -1。（译者注：此方法不移除队列中的任何元素）
 * void add(int value) 将 value 插入队列中。
 */
public class FirstUnique {
    Queue<Integer> queue;
    HashMap<Integer, Integer> map;

    public FirstUnique(int[] nums) {
        map = new HashMap<>();
        queue = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            add(nums[i]);
        }
    }

    public int showFirstUnique() {
        while (!queue.isEmpty()) {
            int num = queue.peek();
            int freq = map.get(num);
            if (freq > 1) {
                queue.poll();
            } else {
                return num;
            }

        }
        return -1;
    }

    public void add(int value) {
        map.put(value, map.getOrDefault(value, 0) + 1);
        queue.add(value);
    }

    public int showFirstUnique2() {
        while (!queue.isEmpty()) {
            int val = queue.peek();
            int freq = map.get(val);
            if (freq > 1) {
                queue.poll();
            } else {
                return val;
            }
        }
        return -1;
    }
}
