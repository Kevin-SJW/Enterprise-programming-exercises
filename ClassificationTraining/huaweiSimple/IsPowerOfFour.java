package ClassificationTraining.huaweiSimple;

/**
 * @Classname IsPowerOfFour
 * @Description TODO
 * @Date 2020/8/23 11:42
 * @Created by Administrator
 */
public class IsPowerOfFour {
    public boolean isPowerOfFour(int num) {
        if(num==0){
            return false;
        }
        while(num%4==0){
            num/=4;
        }
        return num==1;
    }
}
