package AutumnRecruitment.chap1;

/**
 * @Classname Ex20
 * @Description TODO
 * @Date 2019/9/21 11:17
 * @Created by 14241
 */
public class Ex20 {
    public static double ln(int N) {
        if (N == 0) {
            return 0;
        } else {
            return Math.log(N) + ln(N - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(ln(10));
    }
}
