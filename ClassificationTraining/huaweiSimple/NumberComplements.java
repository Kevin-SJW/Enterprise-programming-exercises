package ClassificationTraining.huaweiSimple;

/**
 * @Classname NumberComplements
 * @Description TODO
 * @Date 2020/8/23 12:46
 * @Created by Administrator
 */
public class NumberComplements {
    public static void main(String[] args) {
        int num = 5;
        System.out.println(findComplement(num));
    }

    public static int findComplement(int num) {
        long temp = 1;
        while (num >= temp) {
            temp <<= 1;
        }
        return (int) (temp - 1 - num);
    }
}
