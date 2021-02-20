package LeetCodeSimple;

/**
 * @Classname Sqrt
 * @Description TODO
 * @Date 2020/6/26 17:22
 * @Created by Administrator
 * 二分法
 */
public class Sqrt {
    public static void main(String[] args) {
        int x = 8;
        System.out.println(mySqrt(x));
    }

    public static int mySqrt(int x) {
        long low = 0;
        //平方根的值按规律发现不会大于它的中值+1。这样每个查找就少了一次
        long high = x / 2 + 1;
        long tmp;
        long mid;
        while (low <= high) {
            mid = (low + high) / 2;
            tmp = mid * mid;
            if (tmp == x) {
                return (int)mid;
            }
            if (tmp > x) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return (int)high;
    }
}
