package ClassificationTraining.huaweiSimple;

import java.util.PriorityQueue;

/**
 * 设计一个找到数据流中第K大元素的类（class）。注意是排序后的第K大元素，不是第K个不同的元素。
 * 你的 KthLargest 类需要一个同时接收整数 k 和整数数组nums 的构造器，它包含数据流中的初始元素。
 * 每次调用 KthLargest.add，返回当前数据流中第K大的元素。
 */
public class KthLargest {
    PriorityQueue<Integer> queue;
    int fixed_k;

    public KthLargest(int k, int[] nums) {
        queue = new PriorityQueue<>(k);
        fixed_k = k;
        for (int val : nums) {
            add(val);
        }
    }

    public int add(int val) {
        if (queue.size() < fixed_k) {
            queue.offer(val);
        } else {
            if (val > queue.peek()) {
                queue.poll();
                queue.offer(val);
            }
        }
        // PriorityQueue中保存k个大的元素，PriorityQueue中队首元素就是第k个元素
        return queue.peek();

    }

    public static void main(String[] args) {
        int k = 3;
        int[] arr = {4, 5, 8, 2};
        KthLargest KthLargest = new KthLargest(k, arr);
        System.out.println(KthLargest.add(3));
        System.out.println(KthLargest.add(5));
        System.out.println(KthLargest.add(10));
        System.out.println(KthLargest.add(9));
        System.out.println(KthLargest.add(4));


    }
}
