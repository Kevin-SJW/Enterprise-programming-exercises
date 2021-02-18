package ClassificationTraining.huaweiSimple;

/**
 * @Classname NumberOf1Bits
 * @Description TODO
 * @Date 2020/8/23 9:51
 * @Created by Administrator
 */
public class NumberOf1Bits {
    public int hangmingWeight(int n){
        int sum=0;
        while(n!=0){
            sum++;
            n=n&(n-1);
        }
        return sum;
    }
}
