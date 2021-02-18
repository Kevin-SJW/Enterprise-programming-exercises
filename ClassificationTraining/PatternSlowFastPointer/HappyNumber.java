package ClassificationTraining.PatternSlowFastPointer;

/**
 * @Classname HappyNumber
 * @Description TODO
 * @Date 2020/7/25 0:02
 * @Created by Administrator
 * medium
 */
public class HappyNumber {
    public static void main(String[] args) {
        int n = 19;
        System.out.println(isHappy(n));
    }

    public static boolean isHappy(int n) {
        int fast = n;
        int slow = n;
        do {
            slow = genNumber(slow);
            fast = genNumber(fast);
            fast = genNumber(fast);
        } while (fast != slow);
        return fast==1;
    }

    public static int genNumber(int n) {
        int res = 0;
        while (n != 0) {
            res += Math.pow(n % 10, 2);
            n /= 10;
        }
        return res;
    }
}
