package AutumnRecruitment.chap1;

/**
 * @Classname Ex05
 * @Description TODO
 * @Date 2019/9/15 21:07
 * @Created by 14241
 */
public class Ex05 {
    public static void main(String[] args) {
        int f = 0;
        int g = 1;
        for (int i = 0; i <= 15; i++) {
            System.out.println(f);
            f = f + g;
            g = f - g;
        }
    }
}
