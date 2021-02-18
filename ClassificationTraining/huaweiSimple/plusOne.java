package ClassificationTraining.huaweiSimple;

import java.util.Arrays;

/**
 * @Classname plusOne
 * @Description TODO
 * @Date 2020/8/26 0:36
 * @Created by Administrator
 */
public class plusOne {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        Arrays.stream(plusOne(nums)).forEach(t -> System.out.print(t + " "));
    }

    public static int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] != 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }
        //跳出for循环，说明数字全部是9
        int[] newDigits = new int[digits.length + 1];
        newDigits[0] = 1;
        return newDigits;
    }
}
