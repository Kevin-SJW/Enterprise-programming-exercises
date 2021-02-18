package ClassificationTraining.huaweiSimple;

/**
 * @Classname BitwiseAndOfNumberRange
 * @Description TODO
 * @Date 2020/8/23 9:54
 * @Created by Administrator
 * medium
 */

public class BitwiseAndOfNumberRange {
    public static void main(String[] args) {
        int m=5;
        int n=7;
        System.out.println(rangeBitwiseAnd(m,n));
    }

    public static int rangeBitwiseAnd(int m, int n) {
        int shift = 0;
        //找到公共前缀
        while (m < n) {
            m = m >> 1;
            n = n >> 1;
            shift++;
        }
        return m << shift;
    }
}
