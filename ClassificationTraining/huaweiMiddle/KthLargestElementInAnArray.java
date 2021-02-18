package ClassificationTraining.huaweiMiddle;

import java.util.Arrays;
import java.util.Stack;

/**
 * @Classname KthLargestElementInAnArray
 * @Description TODO
 * @Date 2020/9/4 0:25
 * @Created by Administrator
 */
public class KthLargestElementInAnArray {
    public static void main(String[] args) {
        int[] nums={3,2,1,5,6,4};
        int k=2;
        System.out.println(findKthLargest(nums,k));

    }
    public static int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);

        Stack<Integer> stack=new Stack<>();
        for(int i=0;i<nums.length;i++){
            stack.push(nums[i]);
        }
        for(int i=0;i<k-1;i++){
            stack.pop();
        }
        return stack.peek();
    }
}
