package ClassificationTraining.huaweiMiddle;

/**
 * @Classname ValidSquare
 * @Description TODO
 * @Date 2020/10/7 22:00
 * @Created by Administrator
 */
public class ValidSquare {
    public static void main(String[] args) {
        int[] p1 = {0, 0}, p2 = {1, 1}, p3 = {1, 0}, p4 = {0, 1};
        System.out.println(validSquare(p1, p2, p3, p4));

    }

    public static boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        //任选三个点 都是 一个直角三角形
        return isRightTriangle(p1, p2, p3) && isRightTriangle(p1, p2, p4) && isRightTriangle(p1, p3, p4) && isRightTriangle(p2, p3, p4);
    }

    public static boolean isRightTriangle(int[] p1, int[]p2, int[] p3){
        int d1 = (p1[0] - p2[0]) * (p1[0] - p2[0]) + (p1[1] - p2[1]) * (p1[1] - p2[1]);
        int d2 = (p2[0] - p3[0]) * (p2[0] - p3[0]) + (p2[1] - p3[1]) * (p2[1] - p3[1]);
        int d3 = (p3[0] - p1[0]) * (p3[0] - p1[0]) + (p3[1] - p1[1]) * (p3[1] - p1[1]);
        if(d1 > d2 && d2 == d3 && d2 + d3 == d1 ||
                d2 > d1 && d1 == d3 && d1 + d3 == d2 ||
                d3 > d1 && d1 == d2 && d1 + d2 == d3){
            return true;
        }
        return false;
    }
}
