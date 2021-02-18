package ClassificationTraining.huaweiSimple;

import java.util.Arrays;

/**
 * @Classname LargestPreimeterOfTriangle
 * @Description TODO
 * @Date 2020/9/20 11:29
 * @Created by Administrator
 * 给定由一些正数（代表长度）组成的数组 A，返回由其中三个长度组成的、面积不为零的三角形的最大周长。
 * 如果不能形成任何面积不为零的三角形，返回 0。
 * 输入：[2,1,2]
 * 输出：5
 */
public class LargestPreimeterOfTriangle {
    public static void main(String[] args) {
        int[] A = {2, 1, 2};
        System.out.println(largestPerimeter(A));

    }

    public static int largestPerimeter(int[] A) {
        Arrays.sort(A);
        for(int i = A.length - 1;i >= 2; i--){
            if(A[i-1] + A[i-2] > A[i]){
                return A[i-1] + A[i-2] + A[i];
            }
        }
        return 0;

    }
}
