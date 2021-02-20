package AutumnRecruitment.chap1;

/**
 * @Classname Ex15
 * @Description TODO
 * @Date 2019/9/21 10:51
 * @Created by 14241
 */
public class Ex15 {
    public static int[] histogram(int[] a, int M) {
        int[] result = new int[M];
        for (int i = 0; i < M; i++) {
            if (a[i] >= 0 && a[i] < M) {
                result[a[i]]++;
            }
        }
        return result;

    }

    public static void main(String[] args) {
        int[] a = { 1, 1, 2, 3, 1, 7, 5, 3, 2, 2, 2 };
        int[] result = histogram(a, 8);
        for (int i = 0; i < result.length; i++) {
            System.out.printf("%3d", result[i]);
        }

    }
}
