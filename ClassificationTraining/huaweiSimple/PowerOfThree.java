package ClassificationTraining.huaweiSimple;

/**
 * @Classname PowerOfThree
 * @Description TODO
 * @Date 2020/9/8 23:17
 * @Created by Administrator
 */
public class PowerOfThree {
    public static void main(String[] args) {
        int n = 27;
        System.out.println(isPowerOfThree(n));

    }

    public static boolean isPowerOfThree(int n) {
        if (n == 0) {
            return false;
        }
        if (n == 1) {
            return true;
        }
        while (n % 3 == 0) {
            n /= 3;
        }
        return n == 1;
    }
}
