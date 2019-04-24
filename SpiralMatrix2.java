import java.util.Scanner;

/**
 * @Classname SpiralMatrix2
 * @Description TODO
 * Given a positive integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.
 *
 * Example:
 *
 * Input: 3
 * Output:
 * [
 *  [ 1, 2, 3 ],
 *  [ 8, 9, 4 ],
 *  [ 7, 6, 5 ]
 * ]
 * @Date 2019/4/24 15:24
 * @Created by 14241
 */

public class SpiralMatrix2 {
    public static void main(String[] args){
        Scanner sc =new Scanner(System.in);
        int n=sc.nextInt();
        int[][] matrix=generateMatrix(n);
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static int[][] generateMatrix(int n)
    {
        int[][] res = new int[n][n];

        int total = n*n;
        int num = 1;

        int rowBegin = 0;
        int rowEnd = n-1;
        int colBegin = 0;
        int colEnd = n-1;

        while(num <= total)
        {
            // traverse right (y changes)
            for(int y=colBegin; y<=colEnd; y++){
                res[rowBegin][y] = num++;
            }
            rowBegin++; // move down one row

            // traverse down (x changes)
            for(int x=rowBegin; x<=rowEnd; x++){
                res[x][colEnd] = num++;
            }
            colEnd--; // move left one column

            // traverse left (y changes)
            for(int y=colEnd; y>=colBegin; y--){
                res[rowEnd][y] = num++;
            }
            rowEnd--; // move up one row

            // traverse up (x changes)
            for(int x=rowEnd; x>=rowBegin; x--){
                res[x][colBegin] = num++;
            }
            colBegin++; // move right one column

        }

        return res;
    }
}