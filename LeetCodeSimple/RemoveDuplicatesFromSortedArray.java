package LeetCodeSimple;

/**
 * @Classname RemoveDuplicatesFromSortedArray
 * @Description TODO
 * @Date 2020/6/25 18:05
 * @Created by Administrator
 */
public class RemoveDuplicatesFromSortedArray {
    public static void main(String[] args) {
        int[] nums={1,1,2};
        System.out.println(removeDuplicates(nums));

    }
    public static int removeDuplicates(int[] nums) {
        if(nums.length==0){
            return 0;
        }
        int j=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=nums[j]){
                nums[j++]=nums[i];
            }
        }
        return j+1;

    }
}
