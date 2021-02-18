package ClassificationTraining.huaweiMiddle;

/**
 * @Classname MatrixScore
 * @Description TODO
 * @Date 2020/12/17 0:05
 * @Created by Administrator
 * 遍历第一列：当为0的，需要移动该行
 * 遍历剩下的列：当1的个数小于0的个数时，需要移动该列
 * 移动：即与1异或运算
 * 改进方法：（不需要改变原矩阵）
 * 第一列假设都为1
 * 遍历剩下的列：如果值跟第一列的相同，即是1，否则为0
 * 最终1的个数为：0的个数与1的个数的最大值
 */
public class MatrixScore {
    public static void main(String[] args) {
        int[][] A = {{0, 0, 1, 1}, {1, 0, 1, 0}, {1, 1, 0, 0}};
        System.out.println(matrixScore(A));
    }

    public static int matrixScore(int[][] A) {
        if (A.length == 0 || A[0].length == 0) {
            return 0;
        }
        int result = A.length; // 第一列全为1

        for (int w = 1; w < A[0].length; w++) { // 从第二列开始遍历
            int count1 = 0;

            for (int h = 0; h < A.length; h++) {
                if (A[h][w] == A[h][0]) { // 1的个数
                    count1++;
                }
            }
            // 求出0的个数与1的个数的最大值，作为最终1的个数
            result = (result << 1) + Math.max(count1, A.length - count1);
        }
        return result;
    }
}
