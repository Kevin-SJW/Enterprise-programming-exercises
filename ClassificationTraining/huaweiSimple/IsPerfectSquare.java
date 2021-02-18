package ClassificationTraining.huaweiSimple;

/**
 * @Classname IsPerfectSquare
 * @Description TODO
 * @Date 2020/9/20 16:22
 * @Created by Administrator
 */
public class IsPerfectSquare {
    public static void main(String[] args) {
        int num = 16;
        System.out.println(isPerfectSquare(num));

    }

    public static boolean isPerfectSquare(int num) {
        int left = 1;
        int right = num;
        while (left <= right) {
            int mid = (left + right) / 2;
            if ((double) mid * mid < num) {
                left = mid + 1;
            } else if ((double) mid * mid > num) {
                right = mid - 1;
            } else {
                return true;
            }
        }
        return false;


    }
}
