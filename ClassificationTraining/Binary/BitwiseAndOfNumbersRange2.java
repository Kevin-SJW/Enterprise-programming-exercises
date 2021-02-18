package ClassificationTraining.Binary;

/**
 * @Classname BitwiseAndOfNumberRange
 * @Description TODO
 * @Date 2020/9/26 0:44
 * @Created by Administrator
 */
public class BitwiseAndOfNumbersRange2 {
    public static void main(String[] args) {
        int m=5,n=7;
        System.out.println(rangeBitwiseAnd(m,n));

    }
    public static int rangeBitwiseAnd(int m, int n) {
        int count=0;
        while(m!=n){
            m=m>>1;
            n=n>>1;
            count++;

        }
        m=m<<count;
        return m;
    }
}
