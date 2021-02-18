package ClassificationTraining.Binary;

/**
 * @Classname NumOneInBinary
 * @Description TODO
 * @Date 2020/9/25 23:05
 * @Created by Administrator
 */
public class NumOneInBinary {
    public static void main(String[] args) {
        int n = 00000000000000000000000000001011;
        System.out.println(hammingWeight(n));

    }

    public static int hammingWeight(int n) {
        int count = 0;
        int mask = 1;
        for (int i = 0; i < 32; i++) {
            if ((n & mask) != 0) {
                count++;
            }
            n >>= 1;
        }
        return count;
    }
}
