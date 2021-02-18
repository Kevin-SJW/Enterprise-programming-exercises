package ClassificationTraining.PatternSlidingWindow;

/**
 * @Classname SubArraySumEqualsK
 * @Description TODO
 * @Date 2020/7/19 18:31
 * @Created by Administrator
 * Given an array of integers and an integer k,
 * you need to find the total number of continuous subarrays whose sum equals to k.
 *
 * Example 1:
 *
 * Input:nums = [1,1,1], k = 2
 * Output: 2
 *。
 */
public class SubArraySumEqualsK {
    public static void main(String[] args) {
        int[] nums={1,1,1};
        int k=2;
        System.out.println(subarraySum(nums,k));
    }
    public static int subarraySum(int[] nums, int k) {
        int sum=0;
        for(int i=0;i<nums.length;i++){
            int res=0;
            for(int j=i;j<nums.length;j++){
                res+=nums[i];
                if(res==k){
                    sum++;
                }
            }
        }
        return sum;
    }
}
