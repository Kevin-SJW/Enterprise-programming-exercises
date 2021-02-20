package CredibleExam.exam_12_6;

/**
 * @Classname SameDemensionArray
 * @Description TODO
 * @Date 2020/7/11 20:26
 * @Created by Administrator
 */
public class SameDemensionArray {
    public static void main(String[] args) {
        int[][] matrixA = {{3, 7, 1}, {2, 4, 0}, {9, 4, 2}};
        int[][] res = getSameDemensionArray(matrixA);
        for (int i = 0; i < matrixA.length; i++) {
            for (int j = 0; j < matrixA[0].length; j++) {
                System.out.print(res[i][j] + " ");
            }
            System.out.println();
        }

    }

    public static int[][] getSameDemensionArray(int[][] matrixA) {
        if (matrixA == null) {
            return null;
        }
        int m = matrixA.length;
        int n = matrixA[0].length;
        int[][] matrixB = new int[m][n];
        matrixB[0][0] = matrixA[0][0];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int linCount = 0;
                int colCount = 0;
                for (int k = 0; k <= j; k++) {
                    linCount += matrixA[i][k];
                }
                for (int l = 0; l <= i; l++) {
                    colCount += matrixA[l][j];
                }
                if (i == 0 && j > 0) {
                    matrixB[i][j] = linCount;
                } else if (i > 0 && j == 0) {
                    matrixB[i][j] = colCount;
                } else if (i > 0 && j > 0) {
                    matrixB[i][j] = matrixB[i - 1][j - 1] + linCount + colCount - matrixA[i][j];
                } else {
                    continue;
                }
            }


        }
        return matrixB;

    }

    public static int[][] getSameDemensionArray2(int[][] matrixA) {
        int res = 0;
        for (int i = 0; i < matrixA.length; i++) {
            for (int j = 0; j < matrixA[0].length; j++) {

                int leftAbove = (i != 0 && j != 0) ? matrixA[i - 1][j - 1] : 0;
                int left = (i != 0) ? matrixA[i - 1][j] : 0;
                int above = (j != 0) ? matrixA[i][j - 1] : 0;
                matrixA[i][j] += left + above - leftAbove;
            }

        }
        return matrixA;
    }
}
