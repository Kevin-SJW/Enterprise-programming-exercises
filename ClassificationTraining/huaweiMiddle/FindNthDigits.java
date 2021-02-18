package ClassificationTraining.huaweiMiddle;

/**
 * @Classname FindNthDigits
 * @Description TODO
 * @Date 2020/9/13 12:01
 * @Created by Administrator
 */
public class FindNthDigits {
    public static void main(String[] args) {
        int n=3;
        System.out.println(findNthDigit(n));

    }

    public static int findNthDigit(int n) {
        if (n <= 9) {
            return n;
        }
        n--;
        int num = 1;
        long first = 1;
        while (n > 9 * num * first) {
            n -= 9 * num * first;
            num++;
            first *= 10;
        }
        // 如 456 = 100(first)  +  356（n/num）  n%num 这里表示 456 中的第几位数字
        return String.valueOf(first + n / num).charAt(n % num) - '0';

    }
}
