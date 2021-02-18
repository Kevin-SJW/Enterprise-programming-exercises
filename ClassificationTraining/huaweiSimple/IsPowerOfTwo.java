package ClassificationTraining.huaweiSimple;

/**
 * @Classname IsPowerOfTwo
 * @Description TODO
 * @Date 2020/8/23 11:19
 * @Created by Administrator
 */
public class IsPowerOfTwo {
    public static void main(String[] args) {
        int n=16;
        System.out.println(isPowerOfTwo(n));

    }
    public static boolean isPowerOfTwo(int n) {
        if (n == 0) return false;
        long x = (long) n;
        return (x & (x - 1)) == 0;
    }
}
