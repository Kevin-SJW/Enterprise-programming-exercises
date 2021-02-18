package ClassificationTraining.PatternTwoPointers;

import java.util.Arrays;

/**
 * @Classname SortedSquares
 * @Description TODO
 * @Date 2020/7/20 23:53
 * @Created by Administrator
 */
public class SortedSquares {
    public static void main(String[] args) {
        int[] A={-4,-1,0,3,10};
        Arrays.stream(sortedSquares(A)).forEach(t-> System.out.print(t+" "));

    }

    public static int[] sortedSquares(int[] A) {
        for (int i = 0; i < A.length; i++) {
            A[i] *= A[i];
        }
        Arrays.sort(A);
        return A;
    }
}
