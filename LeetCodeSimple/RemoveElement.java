package LeetCodeSimple;

/**
 * @Classname RemoveElement
 * @Description TODO
 * @Date 2020/6/26 8:49
 * @Created by Administrator
 */
public class RemoveElement {
    public static void main(String[] args) {
        int[] nums={3,2,2,3};
        int val=3;
        System.out.println(removeElement(nums,val));

    }
    public static int removeElement(int[] nums, int val) {
        int j=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=val){
                nums[j++]=nums[i];
            }
        }
        return j;
    }
}
