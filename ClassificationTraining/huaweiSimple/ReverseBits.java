package ClassificationTraining.huaweiSimple;

/**
 * @Classname ReverseBits
 * @Description TODO
 * @Date 2020/8/23 9:18
 * @Created by Administrator
 */
public class ReverseBits {

    public static int reverseBits(int n) {
        int ans = 0;
        for (int bitsSize = 31; n != 0; n = n >>> 1, bitsSize--) {
            ans += (n & 1) << bitsSize;
        }
        return ans;

    }
}
