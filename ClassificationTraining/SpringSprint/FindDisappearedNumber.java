package ClassificationTraining.SpringSprint;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname FindDisappearedNumber
 * @Description TODO
 * @Date 2021/2/14 11:40
 * @Created by Administrator
 */
public class FindDisappearedNumber {
    public static void main(String[] args) {
        int[] nums={4,3,2,7,8,2,3,1};
        System.out.println(findDisappearedNumbers(nums));
    }
    public static List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res=new ArrayList<>();
        int[] arr=new int[nums.length+1];
        for(int num:nums){
            arr[num]++;
        }
        for(int i=1;i<arr.length;i++){
            if(arr[i]==0){
                res.add(i);
            }
        }
        return res;
    }
}
