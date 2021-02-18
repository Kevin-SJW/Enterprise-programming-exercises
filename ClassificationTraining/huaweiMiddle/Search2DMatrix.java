package ClassificationTraining.huaweiMiddle;

/**
 * @Classname Search2DMatrix
 * @Description TODO
 * @Date 2020/9/6 9:30
 * @Created by Administrator
 */
public class Search2DMatrix {
    public static void main(String[] args) {
        int[][] matrix={{1,3,5,7},{10,11,16,20},{23,30,34,50}};
        int target=3;
        System.out.println(searchMatrix(matrix,target));
    }
    public static boolean searchMatrix(int[][] matrix, int target){
        if(matrix.length==0){
            return false;
        }
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if (matrix[i][j]==target){
                    return true;
                }
            }
        }
        return false;
    }
}
