package ClassificationTraining.huaweiSimple;

import java.util.Arrays;

/**
 * @Classname CanMakeArithmeticProgression
 * @Description TODO
 * @Date 2020/10/1 14:54
 * @Created by Administrator
 */
public class CanMakeArithmeticProgression {
    public static void main(String[] args) {
        int[] arr = {3, 5, 1};
        System.out.println(canMakeArithmeticProgression(arr));

    }

    public static boolean canMakeArithmeticProgression(int[] arr) {
        if (arr.length < 3) {
            return false;
        }
        Arrays.sort(arr);
        for (int i = 1; i < arr.length-1; i++) {
            if (arr[i]*2!=arr[i-1]+arr[i+1]) {
                return false;
            }
        }
        return true;

    }
}
