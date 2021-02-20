package AutumnRecruitment.chap5_5;

/**
 * @Classname RandomBits
 * @Description TODO
 * @Date 2020/1/17 22:58
 * @Created by 14241
 */
public class RandomBits {
    public static void main(String[] args) {
        int x = 11111;
        for (int i = 0; i < 1000000; i++) {
            x = x * 314159 + 218281;
            BinaryStdOut.write(x > 0);
        }
        BinaryStdOut.close();
    }
}
