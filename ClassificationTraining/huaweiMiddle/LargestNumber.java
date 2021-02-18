package ClassificationTraining.huaweiMiddle;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Classname LargestNumber
 * @Description TODO
 * @Date 2020/9/4 0:57
 * @Created by Administrator
 */
public class LargestNumber {
    public static void main(String[] args) {
        int[] nums = {10, 2};
        System.out.println(largestNumber(nums));
    }

    public static String largestNumber(int[] nums) {
        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strs[i] = String.valueOf(nums[i]);
        }
        Comparator<String> comp = (o1, o2) -> (o2 + o1).compareTo(o1 + o2);
        Arrays.sort(strs,comp);

        if(strs[0].equals("0")){
            return "0";
        }

        StringBuilder sb=new StringBuilder();
        for(int i=0;i<strs.length;i++){
            sb.append(strs[i]);
        }
        return sb.toString();
    }
}
