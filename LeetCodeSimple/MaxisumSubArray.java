package LeetCodeSimple;

/**
 * @Classname MaxisumSubArray
 * @Description TODO
 * @Date 2020/6/26 15:48
 * @Created by Administrator
 * Input: [-2,1,-3,4,-1,2,1,-5,4],
 * Output: 6
 */
public class MaxisumSubArray {
    public static void main(String[] args) {
        int[] nums={-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(nums));

    }
    public static int maxSubArray(int[] nums) {
        if(nums==null||nums.length==0){
            return 0;
        }
        int res=nums[0];
        int SegmentSum=nums[0];
        for(int i=1;i< nums.length;i++){
            SegmentSum=Math.max(nums[i],SegmentSum+nums[i]);
            res=Math.max(res,SegmentSum);
        }
        return res;

    }
}
