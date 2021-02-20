package coding;

import java.util.Scanner;

/**
 * @Classname test
 * @Description TODO
 * @Date 2019/4/13 21:05
 * @Created by 14241
 */
public class test {
    public static void main(String[] args){
//        int[] A = {0,1,2,3};
//        Main4 test = new Main4();
//        test.Arrange(A,0,0,4,24);    //此处Max = 4!=24
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[][] distance=new int[n][n];
        for(int i=0;i<distance.length;i++){
            String line=sc.nextLine();
            String[] str=line.split("\\s");
            for(int j=0;j<distance[i].length;j++){

//                distance[i][j]=Integer.parseInt(line.split("\\s"));


            }
        }
    }
}
