package AutumnRecruitment.chap1;

/**
 * @Classname Ex13
 * @Description TODO
 * @Date 2019/9/17 23:52
 * @Created by 14241
 */
public class Ex13 {

    public static void printTransposedMatrix(int[][] matrix){
        for(int i=0;i<matrix[0].length;i++){
            for(int j=0;j<matrix.length;j++){
                System.out.print(matrix[j][i]+" ");
//                System.out.printf("%4d", matrix[j][i]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args){
        int[][] a = { { 100, 200, 300 }, { 400, 500, 600 } };
        printTransposedMatrix(a);
    }
}
