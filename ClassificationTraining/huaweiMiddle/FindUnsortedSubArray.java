package ClassificationTraining.huaweiMiddle;

import java.util.Arrays;

/**
 * @Classname FindUnsortedSubArray
 * @Description TODO
 * @Date 2020/11/29 10:24
 * @Created by Administrator
 * 给定一个整数数组，你需要寻找一个连续的子数组，如果对这个子数组进行升序排序，那么整个数组都会变为升序排序。
 * 你找到的子数组应是最短的，请输出它的长度。
 * 输入: [2, 6, 4, 8, 10, 9, 15]
 * 输出: 5
 * 解释: 你只需要对 [6, 4, 8, 10, 9] 进行升序排序，那么整个表都会变为升序排序。
 * 说明 :
 * <p>
 * 输入的数组长度范围在 [1, 10,000]。
 * 输入的数组可能包含重复元素 ，所以升序的意思是<=。
 */
public class FindUnsortedSubArray {
    public static void main(String[] args) {
        int[] nums = {2, 6, 4, 8, 10, 9, 15};
        System.out.println(findUnsortedSubarray(nums));

    }

    public static int findUnsortedSubarray(int[] nums) {
        int[] cop = nums.clone(); //将原数组拷贝一份
        Arrays.sort(cop); //将拷贝后的数组排序
        int left = nums.length, right = 0;

        for(int i=0; i<nums.length; i++){ //依次将排序后的数组与原数组进行比较
            if(nums[i]!=cop[i]){
                left = Math.min(left,i);  //找出最左边不相等的位置
                right = Math.max(right,i); ////找出最右边不相等的位置
            }
        }
        return (right>left)?right-left+1:0; //返回结果

    }
}
