import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @Classname findKthLargest
 * 堆排序 ：时间复杂度 O(NlogK)，空间复杂度 O(K)
 * @Description TODO
 * @Date 2019/4/13 16:01
 * @Created by 14241
 */
public class findKthLargest {
    public static void main(String[] args){
        int[] nums={1,2,4,6,7,5};
        int k=3;
        System.out.print("堆排序之前"+ Arrays.toString(nums));
        System.out.print("\n");
        System.out.print("堆排序之后第K大的值为："+findKthLargest(nums,k));
    }
    public static  int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int val : nums) {
            pq.add(val);
            if (pq.size() > k) {
                pq.poll();
            }

        }
        return pq.peek();
    }
}
