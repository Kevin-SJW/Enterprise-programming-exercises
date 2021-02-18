package ClassificationTraining.huaweiMiddle;

/**
 * @Classname CuttingRope
 * @Description TODO
 * @Date 2020/9/13 11:39
 * @Created by Administrator
 */
public class CuttingRope {
    public static void main(String[] args) {

    }

    public static int cuttingRope(int n) {
        if (n == 2 || n == 3) {
            return n - 1;
        }
        int res = 1;
        while (n > 4) {
            n = n - 3;
            res=res*3;
        }
        return n*res;
    }
}
