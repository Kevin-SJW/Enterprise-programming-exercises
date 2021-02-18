package ClassificationTraining.huaweiSimple;

/**
 * @Classname AddDigits
 * @Description TODO
 * @Date 2020/10/7 21:54
 * @Created by Administrator
 */
public class AddDigits {
    public static void main(String[] args) {
        int num = 38;
        System.out.println(addDigits(num));
    }

    public static int addDigits(int num) {

        while (num > 10) {
            num = num / 10 + num % 10;
        }
        return num;
    }
}
