package AutumnRecruitment.chap1;

/**
 * @Classname Ex14
 * @Description TODO
 * @Date 2019/9/18 0:02
 * @Created by 14241
 */
public class Ex14 {

    private static int lg(int n){
        int shiftRightCount=0;
        do{
            n>>=1;
            shiftRightCount++;
        }while(n!=0);
            return shiftRightCount-1;

    }

    public static void main(String[] args){
        int value = 1025;
        System.out.printf("the result of method log is :%s\r\n", lg(value));

    }
}
