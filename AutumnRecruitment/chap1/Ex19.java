package AutumnRecruitment.chap1;

/**
 * @Classname Ex19
 * @Description TODO
 * @Date 2019/9/21 11:04
 * @Created by 14241
 */
public class Ex19 {
    public static long[] F(int N) {
        long[] fibonacci = new long[N + 1];
        if (N == 0) {
            return fibonacci;
        }
        fibonacci[1] = 1;
        if (N == 1) {
            return fibonacci;
        }
        for (int i = 2; i <= N; i++) {
            fibonacci[i] = fibonacci[i - 1] + fibonacci[i - 2];
        }
        return fibonacci;
    }

    public static void main(String[] args) {
        long[] fibonacci = F(99);
        for (int N = 0; N < fibonacci.length; N++) {
            System.out.println(N + " " + fibonacci[N]);
        }
    }
}
