package ClassificationTraining.huaweiMiddle;

/**
 * @Classname BrokenCal
 * @Description TODO
 * @Date 2020/10/3 15:55
 * @Created by Administrator
 */
public class BrokenCal {
    public static void main(String[] args) {
        int x=3,y=4;
        System.out.println(brokenCalc(x,y));

    }
    public static int brokenCalc(int x, int y) {
        if(x==y){
            return 0;
        }
        if(x>y){
            return x-y;
        }
        if(y%2==0){
            return 1+brokenCalc(x,y/2);
        }else{
            return 1+brokenCalc(x,y+1);
        }
    }
}
