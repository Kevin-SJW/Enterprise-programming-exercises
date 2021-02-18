package ClassificationTraining.Array;

/**
 * @Classname MaxConsecutiveOnes
 * @Description TODO
 * @Date 2020/9/25 23:19
 * @Created by Administrator
 */
public class MaxConsecutiveOnes {
    public static void main(String[] args) {
        int[] nums = {1, 1, 0, 1, 1, 1};
        System.out.println(findMaxConsecutiveOnes(nums));

    }

    public static int findMaxConsecutiveOnes(int[] nums) {
        int max=0;
        int count=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==1){
                count++;
            }else{
                count=0;

            }
            max=Math.max(max,count);
        }
        return max;
    }
}
