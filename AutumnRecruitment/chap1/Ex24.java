package AutumnRecruitment.chap1;

/**
 * @Classname Ex24
 * @Description TODO
 * @Date 2019/9/21 12:28
 * @Created by 14241
 */
public class Ex24 {

    public static int euclid(int p, int q) {
        if (p == 0 || q == 0) {
            return 1;
        }
        if (p < q) {
            int t = q;
            q = p;
            p = t;
        }
        if (p % q == 0) {
            return q;
        } else {
            return euclid(q, p % q);
        }
    }

    public static void main(String[] args) {
        System.out.println("result: " + euclid(105, 24));
        System.out.println("result: " + euclid(1111111, 1234567));
    }
}
