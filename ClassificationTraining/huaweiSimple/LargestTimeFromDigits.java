package ClassificationTraining.huaweiSimple;

/**
 * @Classname LargestTimeFromDigits
 * @Description TODO
 * @Date 2020/8/21 23:28
 * @Created by Administrator
 * Largest Time for Given Digits
 */
public class LargestTimeFromDigits {
    public static void main(String[] args) {
        int[] A = {1, 2, 3, 4};
        System.out.println(largestTimeFromDigits(A));
    }

    public static String largestTimeFromDigits(int[] A) {
        int res = -1;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (i != j) {
                    for (int m = 0; m < 4; m++) {
                        if (m != j && m != i) {
                            int n = 6 - i - j - m;
                            int hour = 10*A[i] + A[j];
                            int minute = 10*A[m] + A[n];
                            if (hour < 24 && minute < 60) {
                                res = Math.max(res, hour * 60 + minute);
                                System.out.println(res);
                            }
                        }
                    }
                }
            }
        }
        return res >= 0 ? String.format("%02d:%02d", res / 60, res % 60) : "";
    }
}
