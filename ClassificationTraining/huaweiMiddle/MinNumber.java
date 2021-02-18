package ClassificationTraining.huaweiMiddle;

import java.util.Arrays;

/**
 * @Classname MinNumber
 * @Description TODO
 * @Date 2020/9/13 17:38
 * @Created by Administrator
 */
public class MinNumber {
    public static void main(String[] args) {
        int[] nums = {10, 2};
        System.out.println(minNumber(nums));
    }

    public static String minNumber(int[] nums) {
        String[] value = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            value[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(value, (o1, o2) -> (o1 + o2).compareTo(o2 + o1));
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < value.length; i++) {
            sb.append(value[i]);
        }
        return sb.toString();
    }

    public static String minNumber2(int[] nums) {
        String[] value = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            value[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(value, ((o1, o2) -> (o1 + o2).compareTo(o2 + o1)));
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < value.length; i++) {
            sb.append(value[i]);
        }
        return sb.toString();
    }
}
