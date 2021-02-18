package ClassificationTraining.huaweiMiddle;

/**
 * @Classname JudgeSquareSum
 * @Description TODO
 * @Date 2020/11/29 16:13
 * @Created by Administrator
 * 给定一个非负整数 c ，你要判断是否存在两个整数 a 和 b，使得 a^2 + b^2 = c 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：c = 5
 * 输出：true
 * 解释：1 * 1 + 2 * 2 = 5
 */
public class JudgeSquareSum {
    public static void main(String[] args) {
        int c = 5;
        System.out.println(judgeSquareSum(c));

    }

    public static boolean judgeSquareSum(int c) {
        int num = (int) Math.sqrt(c);
        int a = 0, b = num;
        int sum ;
        while (a <= b && a >= 0) {
            sum = a * a + b * b;
            if (sum == c) {
                return true;
            } else if (sum < c) {
                a++;
            } else {
                b--;
            }
        }
        return false;
    }
}
