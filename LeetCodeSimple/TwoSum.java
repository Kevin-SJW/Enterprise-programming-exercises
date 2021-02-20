package LeetCodeSimple;

import java.util.HashMap;

/**
 * @Classname TwoSum
 * @Description TODO
 * @Date 2020/6/25 15:35
 * @Created by Administrator
 */
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        int[] res={0,0};
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int v=target-nums[i];
            if(map.containsKey(v)&&i!=map.get(v)){
                res[0]=map.get(v);
                res[1]=i;
            }
            map.put(nums[i],i);
        }
        return res;
    }
//    public int[] twoSum(int[] nums, int target) {
//        int[] res={0,0};
//        for(int i=0;i<nums.length;i++){
//            for(int j=i+1;j<nums.length;j++){
//                if(nums[i]+nums[j]==target){
//                    res[0]=i;
//                    res[1]=j;
//                }
//            }
//
//        }
//        return res;
//    }
}

