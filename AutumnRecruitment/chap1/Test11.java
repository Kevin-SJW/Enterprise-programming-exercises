package AutumnRecruitment.chap1;

/**
 * @Classname Test11
 * @Description TODO
 * @Date 2019/9/15 23:45
 * @Created by 14241
 */
public class Test11 {

    public static void printBooleanMatrix(boolean[][] matrix) {
        System.out.print(' ');
        for (int i = 0; i < matrix[0].length; i++) {
            System.out.println(i);
        }
        System.out.println();
        for (int i = 0; i < matrix.length; i++) {
            System.out.print(i);
            for (int j = i + 1; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] ? "*" : " ");
            }
            System.out.println();
        }
    }

    public static int test1(){
        try{
            return 1;
        }catch (Exception e){
            return 2;
        }finally {
            return 3;
        }
    }

    public static void main(String[] args) {
        boolean[][] a = {{true, false, true}, {false, true, false},
                {true, true, false}};
//        printBooleanMatrix(a);
        System.out.println();
        test1();
    }

}
