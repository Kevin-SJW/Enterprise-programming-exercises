package coding;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Classname RemoveDuplicates
 * @Description
 * Approach 1: Two Pointers
 * Algorithm
 *
 * Since the array is already sorted, we can keep two pointers ii and jj,
 * where ii is the slow-runner while jj is the fast-runner.
 * As long as nums[i] = nums[j]nums[i]=nums[j], we increment jj to skip the duplicate.
 *
 * When we encounter nums[j] \neq nums[i]nums[j]
 * 
 * ​
 *  =nums[i], the duplicate run has ended so we must copy its value to nums[i + 1]nums[i+1].
 *  ii is then incremented and we repeat the same process again until jj reaches the end of array.
 *  Your input
 * [1,1,2]
 * Output
 * [1,2]
 * @Date 2019/4/21 15:52
 * @Created by 14241
 */
public class RemoveDuplicates {
    public static void main(String[] args){
        Scanner sc =new Scanner(System.in);
        String line=sc.nextLine();
        String[] str=line.split("\\s");
        int[] nums=new int[str.length];
        for(int i=0;i<str.length;i++){
            nums[i]=Integer.parseInt(str[i]);
        }
        System.out.println(Arrays.toString(nums));
        System.out.println(removeDuplicates(nums));

    }
    private  static int removeDuplicates(int[] nums){
        if(nums.length==0){
            return 0;
        }
        int i=0;
        for(int j=1;j<nums.length;j++){
            if(nums[j]!=nums[i]){
                i++;
                nums[i]=nums[j];
            }
        }
        return nums[i+1];
    }
}
